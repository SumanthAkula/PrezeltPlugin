package com.notsumo.prezelt.prezeltplugin.events;

import com.notsumo.prezelt.prezeltplugin.PrezeltPlugin;
import com.notsumo.prezelt.prezeltplugin.items.PretzelItem;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class ChargedCreeperKilledEvent implements Listener {
	private final PrezeltPlugin PLUGIN;

	public ChargedCreeperKilledEvent(PrezeltPlugin plugin) {
		this.PLUGIN = plugin;
		this.PLUGIN.getServer().getPluginManager().registerEvents(this, this.PLUGIN);
	}

	@EventHandler
	public void chargedCreeperKilled(EntityDeathEvent e) {
		LivingEntity entity = e.getEntity();

		if (!(entity instanceof Creeper)) {
			return;
		}

		if (!(((Creeper) entity).isPowered())) {
			return;
		}

		if (Math.random() < this.PLUGIN.getConfig().getDouble("charged_creeper_drop_rate")) {
			entity.getLocation().getWorld().dropItemNaturally(entity.getLocation(), PretzelItem.pretzel.clone());
		}
	}
}
