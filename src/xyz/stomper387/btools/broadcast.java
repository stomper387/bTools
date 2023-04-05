package xyz.stomper387.btools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class broadcast implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	
				
		if (label.equalsIgnoreCase("broadcast")) {
			
			
			ConsoleCommandSender c = Bukkit.getServer().getConsoleSender();
			
			
			if (sender instanceof Player) {
				
				
				Player p = (Player) sender;
				
				
				if (!(p.hasPermission("btools.broadcast"))) {
					p.sendMessage(ChatColor.DARK_RED + "You do not have the sufficient permissions");
					return true;
				}
				
				
				if (args.length == 0) {
					p.sendMessage(ChatColor.DARK_RED + "Usage: /<broadcast> <message>");
					return true;
				} else {
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "[Broadcast] " + ChatColor.GOLD + ChatColor.BOLD + String.join(" ", args));
				}
				
				
			} else {
				
				
				if (args.length == 0) {
					c.sendMessage(ChatColor.DARK_RED + "Usage: /<broadcast> <message>");
					return true;
				} else {
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "[Broadcast] " + ChatColor.GOLD + ChatColor.BOLD + String.join(" ", args));
				}
				
				
			}
		}
		return true;
	}
}

//by: stomper387
