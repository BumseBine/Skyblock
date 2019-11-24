package de.xenoncraft.bumsebine.functions;

import org.bukkit.Bukkit;

import de.xenoncraft.bumsebine.main.Main;

public class RandomText {
	public static Integer scheudler = null;

	public static void initalize() {

		scheudler = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {

			@Override
			public void run() {
				
			}
		}, 0, 1);
	}

}
