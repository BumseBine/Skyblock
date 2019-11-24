package de.xenoncraft.bumsebine.functions;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import de.xenoncraft.bumsebine.main.Main;

public class Hologram {

	private List<EntityArmorStand> entitylist = new ArrayList<EntityArmorStand>();
	private String[] Text;
	private Location location;
	private double DISTANCE = 0.25D;
	int count;

	public Hologram(String[] Text, Location location) {
		this.Text = Text;
		this.location = location;
		create();
	}

	public Hologram(String Text, Location location) {

		String[] ArrText = { Text };

		this.Text = ArrText;
		this.location = location;
		create();
	}

	public Hologram(ArrayList<String> lines, Location location) {

		String[] strArr = lines.toArray(new String[lines.size()]);

		this.Text = strArr;
		this.location = location;
		create();
	}

	public void showPlayerTemp(final Player p, int Time) {
		showPlayer(p);
		Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
			public void run() {
				hidePlayer(p);
			}
		}, Time);
	}

	public void showAllTemp(final Player p, int Time) {
		showAll();
		Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
			public void run() {
				hideAll();
			}
		}, Time);
	}

	public void showPlayer(Player p) {
		for (EntityArmorStand armor : entitylist) {
			PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving(armor);
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
		}
	}

	public void hidePlayer(Player p) {
		for (EntityArmorStand armor : entitylist) {
			PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(armor.getId());
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);

		}
	}

	public void showAll() {
		for (Player player : Bukkit.getOnlinePlayers()) {
			for (EntityArmorStand armor : entitylist) {
				PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving(armor);
				((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
			}
		}
	}

	public void hideAll() {
		for (Player player : Bukkit.getOnlinePlayers()) {
			for (EntityArmorStand armor : entitylist) {
				PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(armor.getId());
				((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
			}
		}
	}

	private void create() {
		for (String Text : this.Text) {
			EntityArmorStand entity = new EntityArmorStand(((CraftWorld) this.location.getWorld()).getHandle(),
					this.location.getX(), this.location.getY(), this.location.getZ());
			entity.setCustomName(new ChatComponentText(Text));
			entity.setCustomNameVisible(true);
			entity.setInvisible(true);
			entity.setNoGravity(true);
			entitylist.add(entity);
			this.location.subtract(0, this.DISTANCE, 0);
			count++;
		}

		for (int i = 0; i < count; i++) {
			this.location.add(0, this.DISTANCE, 0);
		}
		this.count = 0;
	}
	public String[] getText() {
		return Text;
	}

}