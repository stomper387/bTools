package xyz.stomper387.btools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class feed implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		ConsoleCommandSender c = Bukkit.getServer().getConsoleSender();
	
		if (label.equalsIgnoreCase("feed")) {
			if (sender instanceof Player) {
				
				Player p = (Player) sender;
				if (!(p.hasPermission("btools.feed"))) {
					p.sendMessage((ChatColor.DARK_RED + "You do not have permission."));
					return false;
				}
				
				
				if (args.length == 0) {
					p.setFoodLevel(20);
					p.setSaturation(20);
					p.sendMessage(ChatColor.DARK_GREEN + "You have been Fed.");
					return true;
				}
				
				
				if (args.length == 1) {
					for (Player playerToFeed : Bukkit.getServer().getOnlinePlayers()) {
						if (playerToFeed.getName().equalsIgnoreCase(args[0])) {
							playerToFeed.setFoodLevel(20);
							playerToFeed.setSaturation(20);
							playerToFeed.sendMessage(ChatColor.DARK_GREEN + "You have been Fed.");
							p.sendMessage(ChatColor.DARK_GREEN + "You've Fed: " + ChatColor.RED + playerToFeed.getName());
							return true;
						} else {
							p.sendMessage(ChatColor.DARK_RED + args[0] + " was not found.");
							return false;
					}
				}
		
			}	
				
			} else {
				if (args.length == 0) {
					c.sendMessage(ChatColor.DARK_RED + "Mmmm... yummy?");
					return true;
				}
				
				
				if (args.length == 1) {
					for (Player playerToFeed : Bukkit.getServer().getOnlinePlayers()) {
						if	(playerToFeed.getName().equalsIgnoreCase(args[0])) {
							playerToFeed.setFoodLevel(20);
							playerToFeed.setSaturation(20);
							playerToFeed.sendMessage(ChatColor.DARK_GREEN + "You have been Fed.");
							c.sendMessage(ChatColor.DARK_GREEN + "You've Fed: " + ChatColor.RED + playerToFeed.getName());
						} else {
							c.sendMessage(ChatColor.DARK_RED + args[0] + " was not found.");
							return false;
						}
					}
				}
			}
		}
		return false;
	}
}
