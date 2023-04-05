package xyz.stomper387.btools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class heal implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		ConsoleCommandSender c = Bukkit.getServer().getConsoleSender();
	
		if (label.equalsIgnoreCase("heal")) {
			
			if (sender instanceof Player) {
				
				Player p = (Player) sender;
				if (!(p.hasPermission("btools.heal"))) {
					p.sendMessage((ChatColor.DARK_RED + "You do not have permission."));
					return false;
				}
				
				if (args.length == 0) {
					p.setHealth(20);
					p.setFoodLevel(20);
					p.setSaturation(20);
					p.sendMessage(ChatColor.DARK_GREEN + "You have been Healed.");
					return true;
				}
				
				
				if (args.length == 1) {
					for (Player playerToHeal : Bukkit.getServer().getOnlinePlayers()) {
						if	(playerToHeal.getName().equalsIgnoreCase(args[0])) {
							playerToHeal.setFoodLevel(20);
							playerToHeal.setSaturation(20);
							playerToHeal.setHealth(20);
							playerToHeal.sendMessage(ChatColor.DARK_GREEN + "You have been Healed.");
							p.sendMessage(ChatColor.DARK_GREEN + "You've Healed: " + ChatColor.RED + playerToHeal.getName());
							return true;
						} else {
							p.sendMessage(ChatColor.DARK_RED + args[0] + " was not found.");
							return false;
					}
				}
		
			}	
				
			} else {
				if (args.length == 0) {
					c.sendMessage(ChatColor.DARK_RED + "I feel better I guess?");
					return true;
				}
				
				
				if (args.length == 1) {
					for (Player playerToHeal : Bukkit.getServer().getOnlinePlayers()) {
						if	(playerToHeal.getName().equalsIgnoreCase(args[0])) {
							playerToHeal.setFoodLevel(20);
							playerToHeal.setSaturation(20);
							playerToHeal.setHealth(20);
							playerToHeal.sendMessage(ChatColor.DARK_GREEN + "You have been Healed.");
							c.sendMessage(ChatColor.DARK_GREEN + "You've Healed: " + ChatColor.RED + playerToHeal.getName());
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
