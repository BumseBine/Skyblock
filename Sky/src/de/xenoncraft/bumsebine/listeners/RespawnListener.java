package de.xenoncraft.bumsebine.listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import de.xenoncraft.bumsebine.main.Variables;

public class RespawnListener implements Listener{
	@EventHandler
	   public void OnPlayerRespawn(PlayerRespawnEvent e) {
		Player p = (Player) e.getPlayer();
		p.setGameMode(GameMode.ADVENTURE);
		p.sendMessage(Variables.edeathTeleportMessage);
	}

}
