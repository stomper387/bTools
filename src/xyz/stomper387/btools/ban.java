package xyz.stomper387.btools;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ban implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (label.equalsIgnoreCase("ban")) {
			
			ConsoleCommandSender c = Bukkit.getServer().getConsoleSender();
			
			if (sender instanceof Player ) {
				Player p = (Player) sender;	
				
				if(!(p.hasPermission("btools.ban"))) {
					p.sendMessage((ChatColor.DARK_RED + "You do not have permission."));
					return false;
				}
				
				
				if (args.length == 0) {
					p.sendMessage(ChatColor.DARK_RED + "Usage: /<ban> <username> <reason>");
					return false;
				}
				
				
				if (args.length == 1) {
					for (Player playerToBan : Bukkit.getServer().getOnlinePlayers()) {
						if(playerToBan.getName().equalsIgnoreCase(args[0])) {
							Bukkit.getBanList(BanList.Type.NAME).addBan(args[0], null, null, sender.getName());
							playerToBan.kickPlayer(ChatColor.DARK_RED + "You have been banned permanently by: " + ChatColor.GOLD + p.getName());
							p.sendMessage(ChatColor.DARK_RED + playerToBan.getName() + ChatColor.GOLD + " has been banned!");
							return true;
						} else {
							p.sendMessage(ChatColor.DARK_RED + args[0] + " was not found");
							return false;
						}
					}
				}
				
				
				if (args.length == 2) {
					for (Player playerToBan : Bukkit.getServer().getOnlinePlayers()) {
						if(playerToBan.getName().equalsIgnoreCase(args[0])) {
							Bukkit.getBanList(BanList.Type.NAME).addBan(args[0], args[1], null, sender.getName());
							playerToBan.kickPlayer(ChatColor.DARK_RED + "You have been banned permanently by: " + ChatColor.GOLD + p.getName() + ChatColor.DARK_RED + " for: " + args[1]);
							p.sendMessage(ChatColor.DARK_RED + playerToBan.getName() + ChatColor.GOLD + " has been banned!");
							return true;
						} else {
							p.sendMessage(ChatColor.DARK_RED + args[0] + " was not found");
							return false;
						}
					}
				}
		} else {
			if (args.length == 0) {
				c.sendMessage(ChatColor.DARK_RED + "Usage: /<ban> <username> <reason>");
				return false;
			}
			
			
			if (args.length == 1) {
				for (Player playerToBan : Bukkit.getServer().getOnlinePlayers()) {
					if(playerToBan.getName().equalsIgnoreCase(args[0])) {
						Bukkit.getBanList(BanList.Type.NAME).addBan(args[0], null, null, sender.getName());
						playerToBan.kickPlayer(ChatColor.DARK_RED + "You have been banned permanently by: " + ChatColor.GOLD + "Console");
						c.sendMessage(ChatColor.DARK_RED + playerToBan.getName() + ChatColor.GOLD + " has been banned!");
						return true;
					} else {
						c.sendMessage(ChatColor.DARK_RED + args[0] + " was not found");
						return false;
					}
				}
			}
			
			
			if (args.length == 2) {
				for (Player playerToBan : Bukkit.getServer().getOnlinePlayers()) {
					if(playerToBan.getName().equalsIgnoreCase(args[0])) {
						Bukkit.getBanList(BanList.Type.NAME).addBan(args[0], args[1], null, sender.getName());
						playerToBan.kickPlayer(ChatColor.DARK_RED + "You have been banned permanently by: " + ChatColor.GOLD + "Console" + ChatColor.DARK_RED + " for: " + args[1]);
						c.sendMessage(ChatColor.DARK_RED + playerToBan.getName() + ChatColor.GOLD + " has been banned!");
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