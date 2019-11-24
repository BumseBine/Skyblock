package de.xenoncraft.bumsebine.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

import de.xenoncraft.bumsebine.main.Variables;

public class PortalListener implements Listener{
	@EventHandler
	public void OnPlayerDamage(PlayerPortalEvent e) {
		Player p = (Player) e.getPlayer();
		if(p.getWorld().equals(Variables.eWorld)) {
			e.setCancelled(true);
			p.performCommand("skyblock teleport");
		}
	}

}
