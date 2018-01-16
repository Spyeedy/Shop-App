package spyeedy.mods.applications.shop.data;

import java.util.ArrayList;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import spyeedy.mods.applications.shop.util.RenderHelper;

public class ShopData {
	
	private static void registerFoodProduct(ShopData product) {
		if (!foodList.contains(product)) foodList.add(product);
	}

	private static void registerArmorProduct(ShopData product) {
		if (!armorList.contains(product)) armorList.add(product);
	}
	
	private static void registerToolProduct(ShopData product) {
		if (!toolList.contains(product)) toolList.add(product);
	}
	
//	-----------------------------------------------------------------------
	
	// FOOD
	public static ArrayList<ShopData> foodList = new ArrayList();
	private static ShopData COOKED_PORKCHOP;
	private static ShopData COOKED_FISH;
	private static ShopData COOKED_SALMON;
	private static ShopData STEAK;
	private static ShopData COOKED_CHICKEN;
	private static ShopData COOKED_RABBIT;
	private static ShopData COOKED_MUTTON;
	private static ShopData APPLE;
	private static ShopData GOLDEN_APPLE;
	private static ShopData ENCHANTED_GOLDEN_APPLE;
	
	public static void registerFoodProducts() {
		COOKED_PORKCHOP = new ShopData(1, Items.COOKED_PORKCHOP);
		COOKED_FISH = new ShopData(1, Items.COOKED_FISH, 1, 0, true);
		COOKED_SALMON = new ShopData(3, Items.COOKED_FISH, 1, 1, true);
		STEAK = new ShopData(2, Items.COOKED_BEEF);
		COOKED_CHICKEN = new ShopData(2, Items.COOKED_CHICKEN);
		COOKED_RABBIT = new ShopData(2, Items.COOKED_RABBIT);
		COOKED_MUTTON = new ShopData(1, Items.COOKED_MUTTON);
		APPLE = new ShopData(5, Items.APPLE);
		GOLDEN_APPLE = new ShopData(7, Items.GOLDEN_APPLE, 1, 0, true);
		ENCHANTED_GOLDEN_APPLE = new ShopData(10, Items.GOLDEN_APPLE, 1, 1, true);
		
		registerFoodProduct(COOKED_PORKCHOP);
		registerFoodProduct(COOKED_FISH);
		registerFoodProduct(COOKED_SALMON);
		registerFoodProduct(STEAK);
		registerFoodProduct(COOKED_CHICKEN);
		registerFoodProduct(COOKED_RABBIT);
		registerFoodProduct(COOKED_MUTTON);
		registerFoodProduct(APPLE);
		registerFoodProduct(GOLDEN_APPLE);
		registerFoodProduct(ENCHANTED_GOLDEN_APPLE);
	}
	
//	-----------------------------------------------------------------------
	
	public static ArrayList<ShopData> armorList = new ArrayList();
	private static ShopData LEATHER_HELMET;
	private static ShopData LEATHER_CHESTPLATE;
	private static ShopData LEATHER_LEGGINGS;
	private static ShopData LEATHER_BOOTS;
	private static ShopData GOLDEN_HELMET;
	private static ShopData GOLDEN_CHESTPLATE;
	private static ShopData GOLDEN_LEGGINGS;
	private static ShopData GOLDEN_BOOTS;
	private static ShopData IRON_HELMET;
	private static ShopData IRON_CHESTPLATE;
	private static ShopData IRON_LEGGINGS;
	private static ShopData IRON_BOOTS;
	private static ShopData DIAMOND_HELMET;
	private static ShopData DIAMOND_CHESTPLATE;
	private static ShopData DIAMOND_LEGGINGS;
	private static ShopData DIAMOND_BOOTS;
	
	public static void registerArmorProducts() {
		
		LEATHER_HELMET = new ShopData(5, Items.LEATHER_HELMET);
		LEATHER_CHESTPLATE = new ShopData(5, Items.LEATHER_CHESTPLATE);
		LEATHER_LEGGINGS = new ShopData(5, Items.LEATHER_LEGGINGS);
		LEATHER_BOOTS = new ShopData(5, Items.LEATHER_BOOTS);
		
		GOLDEN_HELMET = new ShopData(10, Items.GOLDEN_HELMET);
		GOLDEN_CHESTPLATE = new ShopData(10, Items.GOLDEN_CHESTPLATE);
		GOLDEN_LEGGINGS = new ShopData(10, Items.GOLDEN_LEGGINGS);
		GOLDEN_BOOTS = new ShopData(10, Items.GOLDEN_BOOTS);
		
		IRON_HELMET = new ShopData(15, Items.IRON_HELMET);
		IRON_CHESTPLATE = new ShopData(15, Items.IRON_CHESTPLATE);
		IRON_LEGGINGS = new ShopData(15, Items.IRON_LEGGINGS);
		IRON_BOOTS = new ShopData(15, Items.IRON_BOOTS);
		
		DIAMOND_HELMET = new ShopData(20, Items.DIAMOND_HELMET);
		DIAMOND_CHESTPLATE = new ShopData(20, Items.DIAMOND_CHESTPLATE);
		DIAMOND_LEGGINGS = new ShopData(20, Items.DIAMOND_LEGGINGS);
		DIAMOND_BOOTS = new ShopData(20, Items.DIAMOND_BOOTS);
		
		
		registerArmorProduct(LEATHER_HELMET);
		registerArmorProduct(LEATHER_CHESTPLATE);
		registerArmorProduct(LEATHER_LEGGINGS);
		registerArmorProduct(LEATHER_BOOTS);
		registerArmorProduct(GOLDEN_HELMET);
		registerArmorProduct(GOLDEN_CHESTPLATE);
		registerArmorProduct(GOLDEN_LEGGINGS);
		registerArmorProduct(GOLDEN_BOOTS);
		registerArmorProduct(IRON_HELMET);
		registerArmorProduct(IRON_CHESTPLATE);
		registerArmorProduct(IRON_LEGGINGS);
		registerArmorProduct(IRON_BOOTS);
		registerArmorProduct(DIAMOND_HELMET);
		registerArmorProduct(DIAMOND_CHESTPLATE);
		registerArmorProduct(DIAMOND_LEGGINGS);
		registerArmorProduct(DIAMOND_BOOTS);
	}
//	-----------------------------------------------------------------------
	
	// TOOLS
	public static ArrayList<ShopData> toolList = new ArrayList();
	private static ShopData WOODEN_PICKAXE;
	private static ShopData WOODEN_AXE;
	private static ShopData WOODEN_SHOVEL;
	private static ShopData WOODEN_HOE;
	private static ShopData WOODEN_SWORD;
	private static ShopData GOLDEN_PICKAXE;
	private static ShopData GOLDEN_AXE;
	private static ShopData GOLDEN_SHOVEL;
	private static ShopData GOLDEN_HOE;
	private static ShopData GOLDEN_SWORD;
	private static ShopData IRON_PICKAXE;
	private static ShopData IRON_AXE;
	private static ShopData IRON_SHOVEL;
	private static ShopData IRON_HOE;
	private static ShopData IRON_SWORD;
	private static ShopData DIAMOND_PICKAXE;
	private static ShopData DIAMOND_AXE;
	private static ShopData DIAMOND_SHOVEL;
	private static ShopData DIAMOND_HOE;
	private static ShopData DIAMOND_SWORD;
	
	public static void registerToolProducts() {
		WOODEN_PICKAXE = new ShopData(1, Items.WOODEN_PICKAXE);
		WOODEN_AXE = new ShopData(1, Items.WOODEN_AXE);
		WOODEN_SHOVEL = new ShopData(1, Items.WOODEN_SHOVEL);
		WOODEN_HOE = new ShopData(1, Items.WOODEN_HOE);
		WOODEN_SWORD = new ShopData(1, Items.WOODEN_SWORD);
		GOLDEN_PICKAXE = new ShopData(1, Items.GOLDEN_PICKAXE);
		GOLDEN_AXE = new ShopData(1, Items.GOLDEN_AXE);
		GOLDEN_SHOVEL = new ShopData(1, Items.GOLDEN_SHOVEL);
		GOLDEN_HOE = new ShopData(1, Items.GOLDEN_HOE);
		GOLDEN_SWORD = new ShopData(1, Items.GOLDEN_SWORD);
		IRON_PICKAXE = new ShopData(1, Items.IRON_PICKAXE);
		IRON_AXE = new ShopData(1, Items.IRON_AXE);
		IRON_SHOVEL = new ShopData(1, Items.IRON_SHOVEL);
		IRON_HOE = new ShopData(1, Items.IRON_HOE);
		IRON_SWORD = new ShopData(1, Items.IRON_SWORD);
		DIAMOND_PICKAXE = new ShopData(1, Items.DIAMOND_PICKAXE);
		DIAMOND_AXE = new ShopData(1, Items.DIAMOND_AXE);
		DIAMOND_SHOVEL = new ShopData(1, Items.DIAMOND_SHOVEL);
		DIAMOND_HOE = new ShopData(1, Items.DIAMOND_HOE);
		DIAMOND_SWORD = new ShopData(1, Items.DIAMOND_SWORD);
		
		registerToolProduct(WOODEN_PICKAXE);
		registerToolProduct(WOODEN_AXE);
		registerToolProduct(WOODEN_SHOVEL);
		registerToolProduct(WOODEN_HOE);
		registerToolProduct(WOODEN_SWORD);
		
		registerToolProduct(GOLDEN_PICKAXE);
		registerToolProduct(GOLDEN_AXE);
		registerToolProduct(GOLDEN_SHOVEL);
		registerToolProduct(GOLDEN_HOE);
		registerToolProduct(GOLDEN_SWORD);
		
		registerToolProduct(IRON_PICKAXE);
		registerToolProduct(IRON_AXE);
		registerToolProduct(IRON_SHOVEL);
		registerToolProduct(IRON_HOE);
		registerToolProduct(IRON_SWORD);

		registerToolProduct(DIAMOND_PICKAXE);
		registerToolProduct(DIAMOND_AXE);
		registerToolProduct(DIAMOND_SHOVEL);
		registerToolProduct(DIAMOND_HOE);
		registerToolProduct(DIAMOND_SWORD);
	}
	
//	-----------------------------------------------------------------------

	private int price;
	private Item product;
	private ItemStack stackProduct;
	private int qty;
	private int meta;
	private boolean isStack;
	
	private ShopData(int price, Item product) {
		this(price, product, 1, 0, false);
	}
	
	private ShopData(int price, Item product, int qty, int meta, boolean isStack) {
		this.price = price;
		this.product = product;
		this.stackProduct = new ItemStack(product, qty, meta);
		this.qty = qty;
		this.meta = meta;
		this.isStack = isStack;
	}
	
	public ShopData setQty(int qty) {
		this.qty = qty;
		return this;
	}
	
	public String getUnlocalizedName() {
		return RenderHelper.unlocaliseName(this.product.getUnlocalizedName(stackProduct) + ".name");
	}
	
	public int getPrice() {
		return price;
	}

	public Item getProduct() {
		return product;
	}
	
	public ItemStack getStackProduct() {
		return stackProduct;
	}
	
	public int getQty() {
		return qty;
	}
	
	public int getMeta() {
		return meta;
	}
}