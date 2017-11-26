package spyeedy.mods.applications.shop.data;

import spyeedy.mods.applications.shop.util.RenderHelper;

public class Category {

	public static String[] categories = { "FOOD", "ARMOR", "TOOL" };
	
	public static int getSize() {
		return categories.length;
	}
	
	public static String getUnlocalizedName(int i) {
		return RenderHelper.unlocaliseName("appShop.category." + categories[i].toLowerCase());
	}
}