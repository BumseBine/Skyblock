package de.xenoncraft.bumsebine.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import de.xenoncraft.bumsebine.functions.VillagerInterface;
import de.xenoncraft.bumsebine.main.Variables;



public class EntityInteractListener implements Listener{
	
	VillagerInterface api = new VillagerInterface();
	@EventHandler
	public void OnPlayerInteract(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		if(p.getWorld().equals(Variables.eWorld)) {
			if(e.getRightClicked() instanceof Villager) {
				
				Villager v = (Villager) e.getRightClicked();
				
				v.setCustomName(Variables.ServerColor + "Shop");
				
				api.clearTrades(v);
				
				api.addTrade(v, new ItemStack(Variables.bronzem, 1) , null, new ItemStack(Material.COBBLESTONE, 1), Integer.MAX_VALUE);
				api.addTrade(v, new ItemStack(Variables.bronzem, 1) , null, new ItemStack(Material.SANDSTONE, 4),Integer.MAX_VALUE);
				//api.addTrade(v, new ItemStack(Variables.silverm, 2) , null, new ItemStack(Material.LAVA, 1),Integer.MAX_VALUE);
				api.addTrade(v, new ItemStack(Variables.silverm, 1) , null, new ItemStack(Material.BUCKET, 1),Integer.MAX_VALUE);
				api.addTrade(v, new ItemStack(Variables.silverm, 4) , null, new ItemStack(Material.LAVA_BUCKET, 1),Integer.MAX_VALUE);
				api.addTrade(v, new ItemStack(Variables.silverm, 2) , null, new ItemStack(Material.WATER_BUCKET, 1),Integer.MAX_VALUE);
				
			}
		}
		
	}

}
