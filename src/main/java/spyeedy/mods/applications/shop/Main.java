package spyeedy.mods.applications.shop;

import com.mrcrayfish.device.MrCrayfishDeviceMod;
import com.mrcrayfish.device.Reference;
import com.mrcrayfish.device.api.ApplicationManager;
import com.mrcrayfish.device.api.task.TaskManager;
import com.mrcrayfish.device.core.Laptop;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import spyeedy.mods.applications.shop.data.ShopData;
import spyeedy.mods.applications.shop.network.server.MessageSpawnProduct;
import spyeedy.mods.applications.shop.proxy.CommonProxy;
import spyeedy.mods.applications.shop.tasks.TaskBuy;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION, dependencies = Main.DEPENDENCY)
public class Main {

	public static final String MODID = "spyshop";
	public static final String NAME = "Spyeedy's Shop Application";
	public static final String VERSION = "1.11.2-1.0";
	public static final String CLIENT_PROXY = "spyeedy.mods.applications.shop.proxy.ClientProxy";
	public static final String SERVER_PROXY = "spyeedy.mods.applications.shop.proxy.CommonProxy";
	public static final String DEPENDENCY = "required-after:cdm@[" + Reference.VERSION + ",)";
	
	@SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
	public static CommonProxy proxy;
	
	public static SimpleNetworkWrapper networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit();
		ShopData.registerFoodProducts();
		ShopData.registerArmorProducts();
		ShopData.registerToolProducts();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
		registerMessage();
		
		ApplicationManager.registerApplication(new ResourceLocation(MODID, "shop"), ApplicationShop.class);
		Laptop.addWallpaper(new ResourceLocation(MODID, "textures/gui/background_1.png"));
		Laptop.addWallpaper(new ResourceLocation(MODID, "textures/gui/background_2.png"));
		Laptop.addWallpaper(new ResourceLocation(MODID, "textures/gui/background_3.png"));
		Laptop.addWallpaper(new ResourceLocation(MODID, "textures/gui/background_4.png"));
		Laptop.addWallpaper(new ResourceLocation(MODID, "textures/gui/background_5.png"));
		
		TaskManager.registerTask(TaskBuy.class);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}
	
	public void registerMessage() {
		int id = 0;
		networkWrapper.registerMessage(MessageSpawnProduct.Handler.class, MessageSpawnProduct.class, id++, Side.SERVER);
	}
}