package spyeedy.mods.applications.shop.tasks;

import com.mrcrayfish.device.api.task.Task;
import com.mrcrayfish.device.api.utils.BankUtil;
import com.mrcrayfish.device.programs.system.object.Account;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class TaskBuy extends Task {

	private int amount;
	
	private TaskBuy() {
		super("shop_buy");
	}
	
	public TaskBuy(int amount) {
		this();
		this.amount = amount;
	}

	@Override
	public void prepareRequest(NBTTagCompound nbt) {
		nbt.setInteger("amount", this.amount);
	}

	@Override
	public void prepareResponse(NBTTagCompound nbt) {
		nbt.setInteger("balance", this.amount);
	}

	@Override
	public void processRequest(NBTTagCompound nbt, World world, EntityPlayer player) {
		int amount = nbt.getInteger("amount");
		Account account = BankUtil.INSTANCE.getAccount(player);
		if(account.withdraw(amount)) {			
			this.amount = account.getBalance();
			this.setSuccessful();
		}
	}

	@Override
	public void processResponse(NBTTagCompound nbt) {}
}