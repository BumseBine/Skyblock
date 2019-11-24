package de.xenoncraft.bumsebine.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import de.xenoncraft.bumsebine.functions.GoToSpawn;

public class DamageListener implements Listener{
	@EventHandler
	public void OnPlayerDamage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if(p.getWorld().equals(Bukkit.getWorld("Spawn"))) {
				e.setCancelled(true);
				if(p.getLocation().getY() < 20) {
					GoToSpawn.teleport(p);
				}
			}
		}
		if(e.getEntity().getWorld().equals(Bukkit.getWorld("Spawn"))) {
			e.setCancelled(true);
		}
		
	}
}
