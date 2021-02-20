package com.notsumo.prezelt.prezeltplugin.events;

import com.notsumo.prezelt.prezeltplugin.PrezeltPlugin;
import com.notsumo.prezelt.prezeltplugin.items.PretzelItem;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class WitherKilledEvent implements Listener {
	private final PrezeltPlugin PLUGIN;

	public WitherKilledEvent(PrezeltPlugin plugin) {
		this.PLUGIN = plugin;
		this.PLUGIN.getServer().getPluginManager().registerEvents(this, this.PLUGIN);
	}

	@EventHandler
	public void witherKilled(EntityDeathEvent e) {
		LivingEntity entity = e.getEntity();

		if (!(entity instanceof Wither)) {
			return;
		}

		if (Math.random() < 0.25) {
			entity.getLocation().getWorld().dropItemNaturally(entity.getLocation(), PretzelItem.pretzel.clone());
		}
	}
}
