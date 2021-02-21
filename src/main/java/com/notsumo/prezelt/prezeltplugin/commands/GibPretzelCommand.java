package com.notsumo.prezelt.prezeltplugin.commands;

import com.notsumo.prezelt.prezeltplugin.PrezeltPlugin;
import com.notsumo.prezelt.prezeltplugin.items.PretzelItem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

@SuppressWarnings("NullableProblems")
public class GibPretzelCommand implements CommandExecutor {
	private final PrezeltPlugin PLUGIN;

	public GibPretzelCommand(PrezeltPlugin plugin) {
		this.PLUGIN = plugin;
		Objects.requireNonNull(this.PLUGIN.getCommand("givepretzel")).setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length > 1) {
			sender.sendMessage("Too many arguments!");
			return false;
		}
		if (!(sender instanceof Player)) {
			if (args.length == 1) {
				return givePretzelToPlayer(sender, args[0]);
			}
			sender.sendMessage("If running this from the console, you gotta specify a player to give the pretzel to");
			return false;
		}

		Player player = (Player) sender;
		if (args.length == 1) {
			return givePretzelToPlayer(player, args[0]);
		}
		player.getInventory().addItem(PretzelItem.pretzel);
		return true;
	}

	private boolean givePretzelToPlayer(CommandSender sender, String target) {
		Player targetPlayer = this.PLUGIN.getServer().getPlayer(target);
		if (targetPlayer == null) {
			sender.sendMessage("That player does not exist or is not online!");
			return true;
		}

		targetPlayer.getInventory().addItem(PretzelItem.pretzel);
		return true;
	}
}
