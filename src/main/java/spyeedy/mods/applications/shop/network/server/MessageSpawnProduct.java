package spyeedy.mods.applications.shop.network.server;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageSpawnProduct implements IMessage {

	private ItemStack product;

	public MessageSpawnProduct() {}
	
	public MessageSpawnProduct(ItemStack product) {
		this.product = product;
	}
	
	// Read
	@Override
	public void fromBytes(ByteBuf buf) {
		product = ByteBufUtils.readItemStack(buf);
	}

	// Write
	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeItemStack(buf, product);
	}
	
	public static class Handler implements IMessageHandler<MessageSpawnProduct, IMessage> {
		@Override
		public IMessage onMessage(MessageSpawnProduct message, MessageContext ctx) {
			WorldServer thread = (WorldServer) ctx.getServerHandler().playerEntity.world;
			thread.addScheduledTask(() -> {
				EntityPlayer player = ctx.getServerHandler().playerEntity;
				if (!message.product.isEmpty()) {
					player.world.spawnEntity(new EntityItem(player.world, player.posX, player.posY, player.posZ, message.product));
				}
			});
			return null;
		}
	}
}