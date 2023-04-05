package xyz.stomper387.btools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class kick implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (label.equalsIgnoreCase("kick")) {
			
			ConsoleCommandSender c = Bukkit.getServer().getConsoleSender();
			
			if (sender instanceof Player ) {
				Player p = (Player) sender;	
				
				if(!(p.hasPermission("btools.kick"))) {
					p.sendMessage((ChatColor.DARK_RED + "You do not have permission."));
					return false;
				}
				
				
				if (args.length == 0) {
					p.sendMessage(ChatColor.DARK_RED + "Usage: /<kick> <username> <reason>");
					return false;
				}
				
				
				if (args.length == 1) {
					for (Player playerToKick : Bukkit.getServer().getOnlinePlayers()) {
						if(playerToKick.getName().equalsIgnoreCase(args[0])) {
							playerToKick.kickPlayer(ChatColor.DARK_RED + "You have been kicked by: " + ChatColor.GOLD + ChatColor.BOLD + p.getName());
							p.sendMessage(ChatColor.DARK_RED + playerToKick.getName() + ChatColor.GOLD + " has been kicked!");
							return true;
						} else {
							p.sendMessage(ChatColor.DARK_RED + args[0] + " was not found");
							return false;
						}
					}
				}
				
				
				if (args.length == 2) {
					for (Player playerToKick : Bukkit.getServer().getOnlinePlayers()) {
						if(playerToKick.getName().equalsIgnoreCase(args[0])) {
							playerToKick.kickPlayer(ChatColor.DARK_RED + "You have been kicked for: " + ChatColor.GOLD + ChatColor.BOLD + args[1] + ChatColor.DARK_RED + " by: " + p.getName());
							p.sendMessage(ChatColor.DARK_RED + playerToKick.getName() + ChatColor.GOLD + " has been kicked!");
							return true;
						} else {
							p.sendMessage(ChatColor.DARK_RED + args[0] + " was not found");
							return false;
						}
					}
				}
		} else {
			if (args.length == 0) {
				c.sendMessage(ChatColor.DARK_RED + "Usage: /<kick> <username> <reason>");
				return false;
			}
			
			
			if (args.length == 1) {
				for (Player playerToKick : Bukkit.getServer().getOnlinePlayers()) {
					if(playerToKick.getName().equalsIgnoreCase(args[0])) {
						playerToKick.kickPlayer(ChatColor.DARK_RED + "You have been kicked by: " + ChatColor.GOLD + ChatColor.BOLD + "Console");
						c.sendMessage(ChatColor.DARK_RED + playerToKick.getName() + ChatColor.GOLD + " has been kicked!");
						return true;
					} else {
						c.sendMessage(ChatColor.DARK_RED + args[0] + " was not found");
						return false;
					}
				}
			}
			
			
			if (args.length == 2) {
				for (Player playerToKick : Bukkit.getServer().getOnlinePlayers()) {
					if(playerToKick.getName().equalsIgnoreCase(args[0])) {
						playerToKick.kickPlayer(ChatColor.DARK_RED + "You have been kicked for: " + ChatColor.GOLD + ChatColor.BOLD + args[1] + ChatColor.DARK_RED + " by: Console");
						c.sendMessage(ChatColor.DARK_RED + playerToKick.getName() + ChatColor.GOLD + " has been kicked!");
						return true;
					} else {
						c.sendMessage(ChatColor.DARK_RED + args[0] + " was not found");
						return false;
					}
				}
			}
		}
			
			
		}
		return false;
	}
}