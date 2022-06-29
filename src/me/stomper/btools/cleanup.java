package me.stomper.btools;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class cleanup implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		World world = Bukkit.getWorlds().get(0);
	if (label.equalsIgnoreCase("cleanup")) {
		if (!(player.hasPermission("btools.cleanup"))) {
			player.sendMessage(ChatColor.DARK_RED + "You do not have the sufficient permissions");
			return true;
		} else {
			world.setStorm(false);
			world.setThundering(false);
			world.setTime(6000);
			player.sendMessage(ChatColor.DARK_GREEN + "Weather cleared successfully");
			return true;
		}
	}
	return true;
}
}
