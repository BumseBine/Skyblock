 package de.xenoncraft.bumsebine.listeners;
 
import de.xenoncraft.bumsebine.main.Variables;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
 
 public class DeathListener implements Listener
 {
   @EventHandler
   public void OnPlayerDeath(PlayerDeathEvent e)
   {
     Player p = e.getEntity();
     p.setGameMode(GameMode.ADVENTURE);
     e.setDeathMessage(new String(String.format(Variables.edeathMessage, p.getName())));
   }
 }


