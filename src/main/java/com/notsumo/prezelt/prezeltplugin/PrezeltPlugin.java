package com.notsumo.prezelt.prezeltplugin;

import com.notsumo.prezelt.prezeltplugin.commands.GibPretzelCommand;
import com.notsumo.prezelt.prezeltplugin.commands.ReloadCommand;
import com.notsumo.prezelt.prezeltplugin.events.ChargedCreeperKilledEvent;
import com.notsumo.prezelt.prezeltplugin.events.WitherKilledEvent;
import com.notsumo.prezelt.prezeltplugin.items.ItemManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class PrezeltPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		this.getLogger().log(Level.INFO, "YOOO WE IN HERE!");
		saveDefaultConfig();
		ItemManager.init();
		new ReloadCommand(this);
		new GibPretzelCommand(this);
		new WitherKilledEvent(this);
		new ChargedCreeperKilledEvent(this);
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
