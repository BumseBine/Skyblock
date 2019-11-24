package de.xenoncraft.bumsebine.main;

import java.io.File;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

public class Variables {

	public static final Material bronzem = Material.BRICK;
	public static final Material silverm = Material.IRON_INGOT;

	public static final File folder = new File("./plugins/XenonCraft-Skyblocksystem");
	public static final File configf = new File(folder + "/config");
	public static final File clanf = new File(folder + "/clan.json");

	public static final String ServerColor = new String("§6");
	public static final String colorprefix = new String("§3");
	public static final String Serverprefix = new String(ServerColor + "[XenonCraft] ");
	public static final String Rand4 = new String(colorprefix + "§kdashu§r" + colorprefix);

	public static final String edeathMessage = new String(Serverprefix + colorprefix + "%s died!");
	public static final String edeathTeleportMessage = new String(Serverprefix + colorprefix + "You died and will be teleported to the spawn!");
	public static final String eQuitMessage = new String(Serverprefix + colorprefix + "%s has left the Server");
	public static final String eJoinMessage = new String(Serverprefix + colorprefix + "%s has joined the Server");
	
	
	// World
	public static final World eWorld = Bukkit.getWorld("spawn");
	
	
	// Location
	public static final Location hLoc = new Location(eWorld, -0.5, 90, 14.5);
	
	
	// Hologram Messages
	
	public static final String hPlayerStatsPlayer = new String(Rand4 + " Stats of Player " + ServerColor + "%%player%% " + Rand4);
	public static final String hPlayerStatsCoins = new String(colorprefix + "Coins: " + ServerColor + "%%coins%%");
	public static final String hPlayerStatsTime = new String(colorprefix + "Playtime: " + ServerColor + "%%time%%");
	public static final String hPlayerStatsXP = new String(colorprefix + "XP Level: " + ServerColor + "%%XP%%");
	public static final String hPlayerStatsUpdate = new String(colorprefix + "Latest Update: " + ServerColor + "%%time%%");

	
	
	// Permissions
	
	public static final String pSupport = new String("Skyblock.Support");
	
	// Commands
	
	
	// ClanSkyblock
	public static final String cClanSkyblockNoClan = new String(Serverprefix + colorprefix + "You are in no clan. Create or join a clan to create a clan skyblock");
	
	public static final String cSkyblockNotAvalible = new String(Serverprefix + colorprefix + "You don't have a Skyblock.");
	public static final String cSkyblockTeleport = new String(Serverprefix + colorprefix + "You are beeing teleported in a few seconds!.");
	public static final String cSkyblockalreadyExists = new String(Serverprefix + colorprefix + "You have currently a Skyblock. To delete your Skyblock please use /skyblock delete.");
	public static final String cSkyblockpleaseuseinvite = new String(Serverprefix + colorprefix + "Please use /skyblock invite <Player>.");
	public static final String cSkyblockpleaseusejoin = new String(Serverprefix + colorprefix + "Please use /skyblock join <Player>.");
	public static final String cSkyblockSuccelsfullyCreated = new String(Serverprefix + colorprefix + "Your Skyblock was created successfully!");
	public static final String cSkyblockSuccelsfullyDeleted = new String(Serverprefix + colorprefix + "Your Skyblock was deleted successfully!");
	public static final String cSkyblockPlayerOnline = new String(Serverprefix + colorprefix + "The player §5%s " + colorprefix + " is not online!");
	public static final String cSkyblockInvitedSender = new String(Serverprefix + colorprefix + "You have invited the player §5%s" + colorprefix + "!");
	public static final String cSkyblockNotInvited = new String(Serverprefix + colorprefix + "You are not invited to the skyblock of $5%s!");
	public static final String cSkyblockNoPermission = new String(Serverprefix + colorprefix + "You do not have the permissions to execute this command!");
	public static final String cSkyblockInvitedPlayer = new String(Serverprefix + colorprefix + "You have been invited to the Skyblock of §5%s" + colorprefix + "! Use /skyblock join <Player> to join the Skyblock.");
	public static final String cSkyblockAdminTpNoPlayer = new String(Serverprefix + colorprefix + "You have to specify a destination skyblock!");
	public static final String cSkyblockAdminTpPlayerError = new String(Serverprefix + colorprefix + "The skyblock of player %s does not exists!");
	
	// HELP
	public static final String cSkyblockHelpPrefixSufix = new String(ServerColor + "------------------------HELP------------------------");
	public static final String cSkyblockHelpCreate = new String(Serverprefix + colorprefix + " /skyblock create: Creates your skyblock!");
	public static final String cSkyblockHelpTeleport = new String(Serverprefix + colorprefix + " /skyblock teleport: Teleports you to your Skyblock!");
	public static final String cSkyblockHelpInvite = new String(Serverprefix + colorprefix + " /skyblock invite <Player>: Invites players to your skyblock!");
	public static final String cSkyblockHelpJoin = new String(Serverprefix + colorprefix + " /skyblock join <Player>: Joins a skyblock that you were invited to!");

	public static final String cSpawn = new String(Serverprefix + colorprefix + "You are at the Spawn!");

	public static final String cTrashCan = new String("§l§0TrashCan");
	
	
	
	public static final HashMap<ItemStack, ItemStack> VillagerItems = new HashMap<>();
}
