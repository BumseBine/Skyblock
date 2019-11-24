package de.xenoncraft.bumsebine.main;

import de.xenoncraft.bumsebine.commands.SkyBlockCommand;
import de.xenoncraft.bumsebine.commands.SpawnCommand;
import de.xenoncraft.bumsebine.commands.TrashCommand;
import de.xenoncraft.bumsebine.functions.SQL;
import de.xenoncraft.bumsebine.listeners.BlockListener;
import de.xenoncraft.bumsebine.listeners.DamageListener;
import de.xenoncraft.bumsebine.listeners.DeathListener;
import de.xenoncraft.bumsebine.listeners.EntityInteractListener;
import de.xenoncraft.bumsebine.listeners.JoinListener;
import de.xenoncraft.bumsebine.listeners.LeaveListener;
import de.xenoncraft.bumsebine.listeners.MoveListener;
import de.xenoncraft.bumsebine.listeners.PortalListener;
import de.xenoncraft.bumsebine.listeners.RespawnListener;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	private static Main plugin;
	
	public void onEnable() {
		plugin = this;
		
		getCommand("skyblock").setExecutor(new SkyBlockCommand());
		getCommand("trash").setExecutor(new TrashCommand());

		getCommand("spawn").setExecutor(new SpawnCommand());
		getCommand("hub").setExecutor(new SpawnCommand());
		getCommand("lobby").setExecutor(new SpawnCommand());

		
		
		Variables.folder.mkdirs();
		
		getServer().createWorld(new WorldCreator("Spawn"));


		Bukkit.getWorld("Spawn").setDifficulty(Difficulty.PEACEFUL);

		PluginManager pm = Bukkit.getPluginManager();

		pm.registerEvents(new JoinListener(), this);
		pm.registerEvents(new LeaveListener(), this);
		pm.registerEvents(new DeathListener(), this);
		pm.registerEvents(new RespawnListener(), this);
		pm.registerEvents(new DamageListener(), this);
		pm.registerEvents(new PortalListener(), this);
		pm.registerEvents(new EntityInteractListener(), this);
		pm.registerEvents(new MoveListener(), this);
		pm.registerEvents(new BlockListener(), this);
		
		System.out.println("------------------------------------------------");
		System.out.println("------------------------------------------------");
		SQL.start();
		System.out.println("------------------------------------------------");
		System.out.println("------------------------------------------------");
	}

	public void onDisable() {
		
	}

	public static Main getPlugin() {
		return plugin;
	}
}