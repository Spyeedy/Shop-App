package spyeedy.mods.applications.shop;

import java.awt.Color;

import com.mrcrayfish.device.api.app.Application;
import com.mrcrayfish.device.api.app.Icons;
import com.mrcrayfish.device.api.app.component.Button;
import com.mrcrayfish.device.api.app.component.ItemList;
import com.mrcrayfish.device.api.app.component.Label;
import com.mrcrayfish.device.api.app.component.TextField;
import com.mrcrayfish.device.api.task.Callback;
import com.mrcrayfish.device.api.task.TaskManager;
import com.mrcrayfish.device.api.utils.BankUtil;
import com.mrcrayfish.device.api.utils.RenderUtil;
import com.mrcrayfish.device.core.Laptop;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import spyeedy.mods.applications.shop.data.Category;
import spyeedy.mods.applications.shop.data.ShopData;
import spyeedy.mods.applications.shop.network.server.MessageSpawnProduct;
import spyeedy.mods.applications.shop.tasks.TaskBuy;
import spyeedy.mods.applications.shop.util.RenderHelper;

public class ApplicationShop extends Application {
	
	// APPLICATION
	Label labelBalance;
	Label labelAmount;
	
	// SHOP
	ItemList<String> categoryList;
	ItemList<String> foodList;
	ItemList<String> armorList;
	ItemList<String> toolList;
	Button btnBuy;
	Label labelPrice;
	int price;
	
	// QUANTITY
	Label labelTimes;
	Label labelQty;
	Button btn1;
	Button btn2;
	Button btn3;
	Button btn4;
	Button btn5;
	Button btn6;
	Button btn7;
	Button btn8;
	Button btn9;
	Button btn0;
	Button btnClr;
	TextField qtyField;
	
	public ApplicationShop() {
		this.setDefaultWidth(286);
		this.setDefaultHeight(120);
	}
	
	@Override
	public void init() {
		// APPLICATION
		{			
			labelBalance = new Label(TextFormatting.BOLD + RenderHelper.unlocaliseName("shop.balance"), 2, 2);
			labelBalance.setShadow(false);
			labelBalance.setTextColour(Color.BLACK);
			
			labelAmount = new Label("Loading balance...", 53, 2);
			labelAmount.setShadow(false);
			labelAmount.setTextColour(Color.BLUE);
			
			BankUtil.getBalance((nbt, success) ->
			{
				if (success) {
					int balance = nbt.getInteger("balance");
					labelAmount.setText("$" + balance);
					price = nbt.getInteger("balance");
				}
			});
			
			categoryList = new ItemList(125, 0, 100, 2);
			for (int i = 0; i < Category.getSize(); i++) {
				categoryList.addItem(Category.getUnlocalizedName(i));
			}
			categoryList.setItemClickListener((c, i, mouseBtn) -> {
				if (i < 0 | i == 0) { // Category = Food
					foodList.setEnabled(true);
					foodList.setVisible(true);
					foodList.setSelectedIndex(0);
					armorList.setEnabled(false);
					armorList.setVisible(false);
					armorList.setSelectedIndex(-1);
					toolList.setEnabled(false);
					toolList.setVisible(false);
					toolList.setSelectedIndex(-1);
				} else if (i == 1) { // Category = Armor
					foodList.setEnabled(false);
					foodList.setVisible(false);
					foodList.setSelectedIndex(-1);
					armorList.setEnabled(true);
					armorList.setVisible(true);
					armorList.setSelectedIndex(0);
					toolList.setEnabled(false);
					toolList.setVisible(false);
					toolList.setSelectedIndex(-1);
				} else if (i == 2) { // Category = Tool
					foodList.setEnabled(false);
					foodList.setVisible(false);
					foodList.setSelectedIndex(-1);
					armorList.setEnabled(false);
					armorList.setVisible(false);
					armorList.setSelectedIndex(-1);
					toolList.setEnabled(true);
					toolList.setVisible(true);
					toolList.setSelectedIndex(0);
				}
			});
	
			super.addComponent(labelBalance);
			super.addComponent(labelAmount);
			super.addComponent(categoryList);
		}
		
		// SHOP
		{
			
			labelPrice = new Label("", 191, 67);
			
			foodList = new ItemList<String>(5, 35, 170, 5);
			foodList.setItemClickListener((e, index, mouseButton) -> {
				if (index >= 0) {
					btnBuy.setEnabled(true);
				}
			});
			// ADDING FOOD TO LIST
			for (int k = 0; k < ShopData.foodList.size(); k++) {
				foodList.addItem(ShopData.foodList.get(k).getUnlocalizedName());
			}
			
			armorList = new ItemList<>(5, 35, 170, 5);
			armorList.setEnabled(false);
			armorList.setVisible(false);
			armorList.setItemClickListener((e, index, mouseBtn) -> {
				if (index >= 0) {
					btnBuy.setEnabled(true);
				}
			});
			for (int k = 0; k < ShopData.armorList.size(); k++) {
				armorList.addItem(ShopData.armorList.get(k).getUnlocalizedName());
			}
			
			toolList = new ItemList<>(5, 35, 170, 5);
			toolList.setEnabled(false);
			toolList.setVisible(false);
			toolList.setItemClickListener((e, index, mouseBtn) -> {
				if (index >= 0) {
					btnBuy.setEnabled(true);
				}
			});
			for (int k = 0; k < ShopData.toolList.size(); k++) {
				toolList.addItem(ShopData.toolList.get(k).getUnlocalizedName());
			}
			
			
			btnBuy = new Button(180, 86, "Buy", Icons.SHOPPING_CART);
			btnBuy.setEnabled(false);
			btnBuy.setClickListener((int mouseX, int mouseY, int mouseButton) -> {
				if (mouseButton == 0) {
					int qty;
					if (qtyField.getText().equals("0")) {
						qty = 1;
					} else {
						qty = Integer.parseInt(qtyField.getText());
					}
					if (Integer.parseInt(qtyField.getText()) > 64) {
						qty = 64;
					}
					if (foodList.getSelectedIndex() >= 0) {
						int index = foodList.getSelectedIndex();
						if (!ShopData.foodList.get(index).getStackProduct().isEmpty()) {
							buy(ShopData.foodList.get(index).getPrice() * qty, (nbt, success) -> {
								if (success) {
									int balance = nbt.getInteger("balance");
									labelAmount.setText("$" + balance);
								}
								if (qtyField.getText().equals("0")) {
									Main.networkWrapper.sendToServer(new MessageSpawnProduct(ShopData.foodList.get(index).getStackProduct()));
								} else {
									for (int i = 1; i <= Integer.parseInt(qtyField.getText()); i++)
										Main.networkWrapper.sendToServer(new MessageSpawnProduct(ShopData.foodList.get(index).setQty(i).getStackProduct()));
								}
								if (Integer.parseInt(qtyField.getText()) > 64) {
									for (int i = 1; i <= 64; i++) Main.networkWrapper.sendToServer(new MessageSpawnProduct(ShopData.foodList.get(index).setQty(i).getStackProduct()));
								}
							});
						}
					} else if (armorList.getSelectedIndex() >= 0) {
						int index = armorList.getSelectedIndex();
						if (!ShopData.armorList.get(index).getStackProduct().isEmpty()) {
							buy(ShopData.armorList.get(index).getPrice() * qty, (nbt, success) -> {
								if (success) {
									int balance = nbt.getInteger("balance");
									labelAmount.setText("$" + balance);
								}
								if (qtyField.getText().equals("0")) {
									Main.networkWrapper.sendToServer(new MessageSpawnProduct(ShopData.armorList.get(index).getStackProduct()));
								} else {
									for (int i = 1; i <= Integer.parseInt(qtyField.getText()); i++)
										Main.networkWrapper.sendToServer(new MessageSpawnProduct(ShopData.armorList.get(index).setQty(i).getStackProduct()));
								}
								if (Integer.parseInt(qtyField.getText()) > 64) {
									for (int i = 1; i <= 64; i++) Main.networkWrapper.sendToServer(new MessageSpawnProduct(ShopData.armorList.get(index).setQty(i).getStackProduct()));
								}
							});
						}
					} else if (toolList.getSelectedIndex() >= 0) {
						int index = toolList.getSelectedIndex();
						if (!ShopData.toolList.get(index).getStackProduct().isEmpty()) {
							buy(ShopData.toolList.get(index).getPrice() * qty, (nbt, success) -> {
								if (success) {
									int balance = nbt.getInteger("balance");
									labelAmount.setText("$" + balance);
								}
								if (qtyField.getText().equals("0")) {
									Main.networkWrapper.sendToServer(new MessageSpawnProduct(ShopData.toolList.get(index).getStackProduct()));
								} else {
									for (int i = 1; i <= Integer.parseInt(qtyField.getText()); i++)
										Main.networkWrapper.sendToServer(new MessageSpawnProduct(ShopData.toolList.get(index).setQty(i).getStackProduct()));
								}
								if (Integer.parseInt(qtyField.getText()) > 64) {
									for (int i = 1; i <= 64; i++) Main.networkWrapper.sendToServer(new MessageSpawnProduct(ShopData.toolList.get(index).setQty(i).getStackProduct()));
								}
							});
						}
					}
				}
			});
			
			super.addComponent(foodList);
			super.addComponent(armorList);
			super.addComponent(toolList);
			/*super.addComponent(blockList);*/
			super.addComponent(btnBuy);
			super.addComponent(labelPrice);
		}
		
		// QUANTITY
		{
			labelQty = new Label("", 207, 50);
			labelTimes = new Label("", 197, 50);
			
			qtyField = new TextField(229 + 16, 14, 22);
			qtyField.setEditable(false);
			qtyField.setText("0");
			
			btn1 = new Button(229, 32, 16, 16, "1");
			addNumberClickListener(btn1, qtyField, 1);
			
			btn2 = new Button(248, 32, 16, 16, "2");
			addNumberClickListener(btn2, qtyField, 2);
			
			btn3 = new Button(267, 32, 16, 16, "3");
			addNumberClickListener(btn3, qtyField, 3);

			btn4 = new Button(229, 51, 16, 16, "4");
			addNumberClickListener(btn4, qtyField, 4);

			btn5 = new Button(248, 51, 16, 16, "5");
			addNumberClickListener(btn5, qtyField, 5);

			btn6 = new Button(267, 51, 16, 16, "6");
			addNumberClickListener(btn6, qtyField, 6);

			btn7 = new Button(229, 70, 16, 16, "7");
			addNumberClickListener(btn7, qtyField, 7);

			btn8 = new Button(248, 70, 16, 16, "8");
			addNumberClickListener(btn8, qtyField, 8);

			btn9 = new Button(267, 70, 16, 16, "9");
			addNumberClickListener(btn9, qtyField, 9);

			btn0 = new Button(229, 89, 16, 16, "0");
			addNumberClickListener(btn0, qtyField, 0);
			
			btnClr = new Button(248, 89, 35, 16, "Clear");
			btnClr.setClickListener((int mouseX, int mouseY, int mouseButton) -> {
				qtyField.setText("0");
			});
			
			super.addComponent(labelQty);
			super.addComponent(labelTimes);
			super.addComponent(qtyField);
			super.addComponent(btn1);
			super.addComponent(btn2);
			super.addComponent(btn3);
			super.addComponent(btn4);
			super.addComponent(btn5);
			super.addComponent(btn6);
			super.addComponent(btn7);
			super.addComponent(btn8);
			super.addComponent(btn9);
			super.addComponent(btn0);
			super.addComponent(btnClr);
		}
	}
	
	@Override
	public void render(Laptop laptop, Minecraft mc, int x, int y, int mouseX, int mouseY, boolean active, float partialTicks) {
		Gui.drawRect(x, y, x + 225, y + 28, Color.GRAY.getRGB()); // BALANCE AREA
		Gui.drawRect(x + 225, y, x + 226, y + getHeight(), Color.DARK_GRAY.getRGB()); // CALCULATOR DIVIDER
		Gui.drawRect(x + 226, y, x + 226 + 60, y + getHeight(), Color.GRAY.getRGB()); // CALCULATOR AREA
		Gui.drawRect(x, y + 28, x + 225, y + 29, Color.BLACK.getRGB());
		
		super.render(laptop, mc, x, y, mouseX, mouseY, active, partialTicks);
		
		if (foodList.getSelectedIndex() >= 0 | armorList.getSelectedIndex() >= 0 | toolList.getSelectedIndex() >= 0) {
			
			if (qtyField.getText().equals("0")) {
				labelQty.setText("" + 1);
			} else {
				labelQty.setText(qtyField.getText());
			}
			if (Integer.parseInt(qtyField.getText()) > 64) {
				labelQty.setText("" + 64);
			}
			
			String qty = "Qty: " + qtyField.getText();
			
			labelTimes.setText("x");
		}

		int qty;
		if (qtyField.getText().equals("0")) {
			qty = 1;
		} else {
			qty = Integer.parseInt(qtyField.getText());
		}
		if (Integer.parseInt(qtyField.getText()) > 64) {
			qty = 64;
		}
		
		if (foodList.getSelectedIndex() >= 0) {
			int index = foodList.getSelectedIndex();
			RenderUtil.renderItem(x + 180, y + 45, ShopData.foodList.get(index).getStackProduct(), false);
			labelPrice.setText("$" + (ShopData.foodList.get(index).getPrice() * qty));
			labelPrice.setTextColour(Color.CYAN);
		}
		
		if (armorList.getSelectedIndex() >= 0) {
			int index = armorList.getSelectedIndex();
			RenderUtil.renderItem(x + 180, y + 45, ShopData.armorList.get(armorList.getSelectedIndex()).getStackProduct(), false);
			labelPrice.setText("$" + (ShopData.armorList.get(index).getPrice() * qty));
			labelPrice.setTextColour(Color.CYAN);
		}
		if (toolList.getSelectedIndex() >= 0) {
			int index = toolList.getSelectedIndex();
			RenderUtil.renderItem(x + 180, y + 45, ShopData.toolList.get(index).getStackProduct(), false);
			labelPrice.setText("$" + (ShopData.toolList.get(index).getPrice() * qty));
			labelPrice.setTextColour(Color.CYAN);
		}
	}

	@Override
	public void load(NBTTagCompound tagCompound) {}

	@Override
	public void save(NBTTagCompound tagCompound) {}
	
	private void buy(int amount, Callback<NBTTagCompound> callback)
	{
		TaskManager.sendTask(new TaskBuy(amount).setCallback(callback));
	}
	
	private void addNumberClickListener(Button btn, TextField field, final int number) {
		btn.setClickListener((int mouseX, int mouseY, int mouseButton) -> {
			if (!(field.getText().equals("0") && number == 0) ) {
				if (field.getText().equals("0")) field.clear();
				field.writeText(Integer.toString(number));
			}
		});
	}
}