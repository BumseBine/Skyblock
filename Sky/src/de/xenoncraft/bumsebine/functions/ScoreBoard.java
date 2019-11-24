package de.xenoncraft.bumsebine.functions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreBoard {
	private static int X;
	private static int Y;
	private static int Z;
	private static String world;
	
	
	public static void create(Player p) {
		final Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
		
		@SuppressWarnings("deprecation")
		final Objective ob = sb.registerNewObjective("Location", "dummy");
		ob.setDisplaySlot(DisplaySlot.SIDEBAR);
		ob.setDisplayName("Loaction");
		
		X = (int) p.getLocation().getX();
		Y = (int) p.getLocation().getY();
		Z = (int) p.getLocation().getZ();
		world = " ";
		
		
		//update(p);
		
		p.setScoreboard(sb);
	}
	
	public static void create() {
		for(Player p : Bukkit.getOnlinePlayers()) {
			create(p);
		}
	}
	public static void update(Player p) {
		final Scoreboard sb = p.getScoreboard();
		final Objective ob = sb.getObjective(DisplaySlot.SIDEBAR);
		
		sb.resetScores(String.valueOf(X));
		sb.resetScores(String.valueOf(Y));
		sb.resetScores(String.valueOf(Z));
		sb.resetScores(world);
		
		
		X = (int) p.getLocation().getX();
		Y = (int) p.getLocation().getY();
		Z = (int) p.getLocation().getZ();
		world = p.getWorld().getName();
		
		
		
		
		
		
		
		ob.getScore("World: " + world).setScore(5);
		
		ob.getScore("X: " + X).setScore(4);
		
		ob.getScore("Y: " + Y).setScore(3);
		
		ob.getScore("Z: " + Z).setScore(2);
	}
}
