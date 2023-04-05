package xyz.stomper387.btools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class time implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		World world = Bukkit.getWorlds().get(0);
		ConsoleCommandSender c = Bukkit.getServer().getConsoleSender();
		
		
		if (label.equalsIgnoreCase("day")) {
			if (sender instanceof Player ) {
				Player player = (Player) sender;
				if (!(player.hasPermission("btools.day"))) {
					player.sendMessage(ChatColor.DARK_RED + "You do not have the sufficient permissions");
					return false;
				} else {
					world.setStorm(false);
					world.setThundering(false);
					world.setTime(6000);
					player.sendMessage(ChatColor.DARK_GREEN + "Set to day and weather cleared.");
					return true;
				}
			} else {
				world.setStorm(false);
				world.setThundering(false);
				world.setTime(6000);
				c.sendMessage(ChatColor.DARK_GREEN + "Set to day and weather cleared");
			}
		}
		
		
		if (label.equalsIgnoreCase("d")) {
			if (sender instanceof Player ) {
				Player player = (Player) sender;
				if (!(player.hasPermission("btools.day"))) {
					player.sendMessage(ChatColor.DARK_RED + "You do not have the sufficient permissions");
					return false;
				} else {
					world.setStorm(false);
					world.setThundering(false);
					world.setTime(6000);
					player.sendMessage(ChatColor.DARK_GREEN + "Set to day and weather cleared.");
					return true;
				}
			} else {
				world.setStorm(false);
				world.setThundering(false);
				world.setTime(6000);
				c.sendMessage(ChatColor.DARK_GREEN + "Set to day and weather cleared");
			}
		}
		
		
		if (label.equalsIgnoreCase("night")) {
			if (sender instanceof Player ) {
				Player player = (Player) sender;
				if (!(player.hasPermission("btools.night"))) {
					player.sendMessage(ChatColor.DARK_RED + "You do not have the sufficient permissions");
					return false;
				} else {
					world.setStorm(false);
					world.setThundering(false);
					world.setTime(13000);
					player.sendMessage(ChatColor.DARK_GREEN + "Set to night and weather cleared.");
					return true;
				}
			} else {
				world.setStorm(false);
				world.setThundering(false);
				world.setTime(13000);
				c.sendMessage(ChatColor.DARK_GREEN + "Set to night and weather cleared");
			}
		}
		
		if (label.equalsIgnoreCase("n")) {
			if (sender instanceof Player ) {
				Player player = (Player) sender;
				if (!(player.hasPermission("btools.night"))) {
					player.sendMessage(ChatColor.DARK_RED + "You do not have the sufficient permissions");
					return false;
				} else {
					world.setStorm(false);
					world.setThundering(false);
					world.setTime(13000);
					player.sendMessage(ChatColor.DARK_GREEN + "Set to night and weather cleared.");
					return true;
				}
			} else {
				world.setStorm(false);
				world.setThundering(false);
				world.setTime(13000);
				c.sendMessage(ChatColor.DARK_GREEN + "Set to night and weather cleared");
			}
		}
		return false;
	}
}

//by: stomper387