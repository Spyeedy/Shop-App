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
		COOKED_PORKCHOP = new ShopData(1, Items.COOKED_PORKCHOP, "cooked_porkchop");
		COOKED_FISH = new ShopData(1, Items.COOKED_FISH, 1, 0, "cooked_fish", true);
		COOKED_SALMON = new ShopData(3, Items.COOKED_FISH, 1, 1, "cooked_salmon", true);
		STEAK = new ShopData(2, Items.COOKED_BEEF, "steak");
		COOKED_CHICKEN = new ShopData(2, Items.COOKED_CHICKEN, "cooked_chicken");
		COOKED_RABBIT = new ShopData(2, Items.COOKED_RABBIT, "cooked_rabbit");
		COOKED_MUTTON = new ShopData(1, Items.COOKED_MUTTON, "cooked_mutton");
		APPLE = new ShopData(5, Items.APPLE, "apple");
		GOLDEN_APPLE = new ShopData(7, Items.GOLDEN_APPLE, 1, 0, "golden_apple", true);
		ENCHANTED_GOLDEN_APPLE = new ShopData(10, Items.GOLDEN_APPLE, 1, 1, "enchanted_golden_apple", true);
		
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
		
		LEATHER_HELMET = new ShopData(5, Items.LEATHER_HELMET, "leather_helmet");
		LEATHER_CHESTPLATE = new ShopData(5, Items.LEATHER_CHESTPLATE, "leather_chestplate");
		LEATHER_LEGGINGS = new ShopData(5, Items.LEATHER_LEGGINGS, "leather_leggings");
		LEATHER_BOOTS = new ShopData(5, Items.LEATHER_BOOTS, "leather_boots");
		
		GOLDEN_HELMET = new ShopData(10, Items.GOLDEN_HELMET, "golden_helmet");
		GOLDEN_CHESTPLATE = new ShopData(10, Items.GOLDEN_CHESTPLATE, "golden_chestplate");
		GOLDEN_LEGGINGS = new ShopData(10, Items.GOLDEN_LEGGINGS, "golden_leggings");
		GOLDEN_BOOTS = new ShopData(10, Items.GOLDEN_BOOTS, "golden_boots");
		
		IRON_HELMET = new ShopData(15, Items.IRON_HELMET, "iron_helmet");
		IRON_CHESTPLATE = new ShopData(15, Items.IRON_CHESTPLATE, "iron_chestplate");
		IRON_LEGGINGS = new ShopData(15, Items.IRON_LEGGINGS, "iron_leggings");
		IRON_BOOTS = new ShopData(15, Items.IRON_BOOTS, "iron_boots");
		
		DIAMOND_HELMET = new ShopData(20, Items.DIAMOND_HELMET, "diamond_helmet");
		DIAMOND_CHESTPLATE = new ShopData(20, Items.DIAMOND_CHESTPLATE, "diamond_chestplate");
		DIAMOND_LEGGINGS = new ShopData(20, Items.DIAMOND_LEGGINGS, "diamond_leggings");
		DIAMOND_BOOTS = new ShopData(20, Items.DIAMOND_BOOTS, "diamond_boots");
		
		
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
		WOODEN_PICKAXE = new ShopData(1, Items.WOODEN_PICKAXE, "wooden_pickaxe");
		WOODEN_AXE = new ShopData(1, Items.WOODEN_AXE, "wooden_axe");
		WOODEN_SHOVEL = new ShopData(1, Items.WOODEN_SHOVEL, "wooden_shovel");
		WOODEN_HOE = new ShopData(1, Items.WOODEN_HOE, "wooden_hoe");
		WOODEN_SWORD = new ShopData(1, Items.WOODEN_SWORD, "wooden_sword");
		GOLDEN_PICKAXE = new ShopData(1, Items.GOLDEN_PICKAXE, "golden_pickaxe");
		GOLDEN_AXE = new ShopData(1, Items.GOLDEN_AXE, "golden_axe");
		GOLDEN_SHOVEL = new ShopData(1, Items.GOLDEN_SHOVEL, "golden_shovel");
		GOLDEN_HOE = new ShopData(1, Items.GOLDEN_HOE, "golden_hoe");
		GOLDEN_SWORD = new ShopData(1, Items.GOLDEN_SWORD, "golden_sword");
		IRON_PICKAXE = new ShopData(1, Items.IRON_PICKAXE, "iron_pickaxe");
		IRON_AXE = new ShopData(1, Items.IRON_AXE, "iron_axe");
		IRON_SHOVEL = new ShopData(1, Items.IRON_SHOVEL, "iron_shovel");
		IRON_HOE = new ShopData(1, Items.IRON_HOE, "iron_hoe");
		IRON_SWORD = new ShopData(1, Items.IRON_SWORD, "iron_sword");
		DIAMOND_PICKAXE = new ShopData(1, Items.DIAMOND_PICKAXE, "diamond_pickaxe");
		DIAMOND_AXE = new ShopData(1, Items.DIAMOND_AXE, "diamond_axe");
		DIAMOND_SHOVEL = new ShopData(1, Items.DIAMOND_SHOVEL, "diamond_shovel");
		DIAMOND_HOE = new ShopData(1, Items.DIAMOND_HOE, "diamond_hoe");
		DIAMOND_SWORD = new ShopData(1, Items.DIAMOND_SWORD, "diamond_sword");
		
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
	private String name;
	private ItemStack stackProduct;
	private int qty;
	private int meta;
	private boolean isStack;
	
	private ShopData(int price, Item product, String name) {
		this(price, product, 1, 0, name, false);
	}
	
	private ShopData(int price, Item product, int qty, int meta, String name, boolean isStack) {
		this.price = price;
		this.stackProduct = new ItemStack(product, qty, meta);
		this.name = name;
		this.isStack = isStack;
	}
	
	public ShopData setQty(int qty) {
		this.qty = qty;
		return this;
	}
	
	public String getUnlocalizedName() {
		return RenderHelper.unlocaliseName("appShop." + name);
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