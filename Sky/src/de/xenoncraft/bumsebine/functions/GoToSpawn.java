package de.xenoncraft.bumsebine.functions;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class GoToSpawn {
	public static void teleport(Player p) {
		World spawn = Bukkit.getWorld("Spawn");
		spawn.setStorm(false);
		spawn.setThundering(false);
		spawn.setWeatherDuration(Integer.MAX_VALUE);
		Location loc;
		loc = spawn.getSpawnLocation();
		loc.setYaw(180);
		loc.setX(loc.getX() + 0.5);
		p.teleport(loc);
	}

}
