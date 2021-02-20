package com.notsumo.prezelt.prezeltplugin.events;

import com.notsumo.prezelt.prezeltplugin.PrezeltPlugin;
import com.notsumo.prezelt.prezeltplugin.items.PretzelItem;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EnderDragonKilledEvent implements Listener {
	private final PrezeltPlugin PLUGIN;

	public EnderDragonKilledEvent(PrezeltPlugin plugin) {
		this.PLUGIN = plugin;
		this.PLUGIN.getServer().getPluginManager().registerEvents(this, this.PLUGIN);
	}

	@EventHandler
	public void enderDragonKilled(EntityDeathEvent e) {
		LivingEntity entity = e.getEntity();

		if (!(entity instanceof EnderDragon)) {
			return;
		}

		if (Math.random() < this.PLUGIN.getConfig().getDouble("ender_dragon_drop_rate")) {
			entity.getLocation().getWorld().dropItemNaturally(entity.getLocation(), PretzelItem.pretzel.clone());
		}
	}
}
