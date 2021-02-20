package com.notsumo.prezelt.prezeltplugin.commands;

import com.notsumo.prezelt.prezeltplugin.PrezeltPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;
import java.util.logging.Level;

@SuppressWarnings("NullableProblems")
public class ReloadCommand implements CommandExecutor {
	private final PrezeltPlugin PLUGIN;

	public ReloadCommand(PrezeltPlugin plugin) {
		this.PLUGIN = plugin;
		Objects.requireNonNull(this.PLUGIN.getCommand("prezelt_reload")).setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length != 0) {
			sender.sendMessage("This command takes no arguments!");
			return false;
		}

		this.PLUGIN.reloadConfig();
		sender.sendMessage("Reloaded PrezeltPlugin");
		this.PLUGIN.getLogger().log(Level.INFO, "PrezeltPlugin config reloaded");
		return true;
	}
}
