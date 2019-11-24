package de.xenoncraft.bumsebine.listeners;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.xenoncraft.bumsebine.functions.GoToSpawn;
import de.xenoncraft.bumsebine.functions.Hologram;
import de.xenoncraft.bumsebine.functions.SQL;
import de.xenoncraft.bumsebine.functions.ScoreBoard;
import de.xenoncraft.bumsebine.main.Variables;

public class JoinListener implements Listener {

	public static HashMap<Player, Hologram> holos = new HashMap<Player, Hologram>();
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String pname = p.getPlayerListName();
		e.setJoinMessage(new String(String.format(Variables.eJoinMessage, new Object[] { pname })));
		
		GoToSpawn.teleport(p);
		p.setGameMode(GameMode.ADVENTURE);
		
		ScoreBoard.create(p);
		
		ArrayList<String> htext = new ArrayList<String>();
		htext.add(Variables.hPlayerStatsPlayer.replace("%%player%%", p.getName()));
		htext.add(Variables.hPlayerStatsCoins.replace("%%coins%%", "1000"));
		htext.add(Variables.hPlayerStatsTime.replace("%%time%%", String.valueOf(p.getPlayerTime())));
		htext.add(Variables.hPlayerStatsXP.replace("%%XP%%", String.valueOf(p.getLevel())));
		htext.add(Variables.hPlayerStatsUpdate.replace("%%time%%", new SimpleDateFormat("yyyy.MM.dd  HH:mm").format(new Date())));
		
		Hologram hologram = new Hologram(htext, Variables.hLoc);
		
		hologram.showPlayer(p);
		holos.put(p, hologram);
		
		SQL.insert(p.getUniqueId().toString(), 100, "Test");
	}
}
