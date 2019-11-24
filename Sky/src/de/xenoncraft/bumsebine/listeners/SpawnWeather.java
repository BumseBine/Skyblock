package de.xenoncraft.bumsebine.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

import de.xenoncraft.bumsebine.main.Variables;

public class SpawnWeather implements Listener {
	@EventHandler
	public void OnPlayerDeath(WeatherChangeEvent e) {
		if(e.getWorld().equals(Variables.eWorld)) {
			e.setCancelled(true);
			e.getWorld().setStorm(false);
			e.getWorld().setThundering(false);
			e.getWorld().setWeatherDuration(Integer.MAX_VALUE);
		}
	}

}