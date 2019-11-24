package de.xenoncraft.bumsebine.functions;

import java.lang.reflect.Field;import org.bukkit.craftbukkit.v1_14_R1.entity.CraftVillager;import org.bukkit.craftbukkit.v1_14_R1.inventory.CraftItemStack;import org.bukkit.entity.Villager;
import de.xenoncraft.bumsebine.Trade.VillagerTrade;import net.minecraft.server.v1_14_R1.EntityVillager;import net.minecraft.server.v1_14_R1.ItemStack;import net.minecraft.server.v1_14_R1.MerchantRecipe;import net.minecraft.server.v1_14_R1.MerchantRecipeList;

public class VillagerInterface {

	public void clearTrades(Villager villager) {
		EntityVillager v = ((CraftVillager) villager).getHandle();
		
		try {
			Field recipes = v.getClass().getDeclaredField("trades");
			recipes.setAccessible(true);
			MerchantRecipeList list = new MerchantRecipeList();
			recipes.set(v, list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void addTrade(Villager villager, org.bukkit.inventory.ItemStack stack1,
			org.bukkit.inventory.ItemStack stack2, org.bukkit.inventory.ItemStack stack3, int maxUses) {
		EntityVillager entityVillager = ((CraftVillager) villager).getHandle();
		VillagerTrade villagerTrade = setMerchant(stack1, stack2, stack3);
		try {
			Field recipes = entityVillager.getClass().getDeclaredField("trades");
			recipes.setAccessible(true);
			MerchantRecipeList list = (MerchantRecipeList) recipes.get(entityVillager);
			if (villagerTrade.hasItem2()) {
				ItemStack item1 = CraftItemStack.asNMSCopy(villagerTrade.getItem1());
				ItemStack item2 = CraftItemStack.asNMSCopy(villagerTrade.getItem2());
				ItemStack rewardItem = CraftItemStack.asNMSCopy(villagerTrade.getRewardItem());
				MerchantRecipe recipe = new MerchantRecipe(item1, item2, rewardItem, stack1.getAmount(), stack2.getAmount(), stack3.getAmount(), 0);
				recipe.maxUses = maxUses;
				list.add(recipe);
			} else {
				ItemStack item1 = CraftItemStack.asNMSCopy(villagerTrade.getItem1());
				ItemStack rewardItem = CraftItemStack.asNMSCopy(villagerTrade.getRewardItem());
				MerchantRecipe recipe = new MerchantRecipe(item1, rewardItem, stack1.getAmount(), stack3.getAmount(), 0);
				recipe.maxUses = maxUses;
				list.add(recipe);
			}
			recipes.set(entityVillager, list);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	private VillagerTrade setMerchant(org.bukkit.inventory.ItemStack item1, org.bukkit.inventory.ItemStack item2,
			org.bukkit.inventory.ItemStack rewardItem) {
		if (item2 == null) {
			return new VillagerTrade(item1, rewardItem);
		}
		return new VillagerTrade(item1, item2, rewardItem);
	}

}
