package xyz.stomper387.btools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class gapple implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		ConsoleCommandSender c = Bukkit.getServer().getConsoleSender();
	
		if (label.equalsIgnoreCase("gapple")) {
			
			if (sender instanceof Player) {
				
				Player p = (Player) sender;
				if (!(p.hasPermission("btools.gapple"))) {
					p.sendMessage((ChatColor.DARK_RED + "You do not have permission."));
					return false;
				}
				
				if (args.length == 0) {
					p.setAbsorptionAmount(20);
					p.setHealth(20);
					p.setFoodLevel(20);
					p.setSaturation(20);
					p.sendMessage(ChatColor.DARK_GREEN + "You have been Blessed.");
					return true;
				}
				
				
				if (args.length == 1) {
					for (Player playerToBless : Bukkit.getServer().getOnlinePlayers()) {
						if	(playerToBless.getName().equalsIgnoreCase(args[0])) {
							playerToBless.setFoodLevel(20);
							playerToBless.setSaturation(20);
							playerToBless.setHealth(20);
							playerToBless.setAbsorptionAmount(20);
							playerToBless.sendMessage(ChatColor.DARK_GREEN + "You have been blessed.");
							p.sendMessage(ChatColor.DARK_GREEN + "You've blessed: " + ChatColor.RED + playerToBless.getName());
							return true;
						} else {
							p.sendMessage(ChatColor.DARK_RED + args[0] + " was not found.");
							return false;
					}
				}
		
			}	
				
			} else {
				if (args.length == 0) {
					c.sendMessage(ChatColor.GOLD + "I CAN SEE IT ALL!!!");
					return true;
				}
				
				
				if (args.length == 1) {
					for (Player playerToBless : Bukkit.getServer().getOnlinePlayers()) {
						if(playerToBless.getName().equalsIgnoreCase(args[0])) {
							playerToBless.setFoodLevel(20);
							playerToBless.setSaturation(20);
							playerToBless.setHealth(20);
							playerToBless.setAbsorptionAmount(20);
							playerToBless.sendMessage(ChatColor.DARK_GREEN + "You have been blessed.");
							c.sendMessage(ChatColor.DARK_GREEN + "You've blessed: " + ChatColor.RED + playerToBless.getName());
							return true;
						} else {
							c.sendMessage(ChatColor.DARK_RED + args[0] + " was not found.");
							return false;
						}
					}
				}
			}
		}
		
		
		if (label.equalsIgnoreCase("g")) {
			
			if (sender instanceof Player) {
				
				Player p = (Player) sender;
				if (!(p.hasPermission("btools.gapple"))) {
					p.sendMessage((ChatColor.DARK_RED + "You do not have permission."));
					return false;
				}
				
				if (args.length == 0) {
					p.setAbsorptionAmount(20);
					p.setHealth(20);
					p.setFoodLevel(20);
					p.setSaturation(20);
					p.sendMessage(ChatColor.DARK_GREEN + "You have been Blessed.");
					return true;
				}
				
				
				if (args.length == 1) {
					for (Player playerToBless : Bukkit.getServer().getOnlinePlayers()) {
						if	(playerToBless.getName().equalsIgnoreCase(args[0])) {
							playerToBless.setFoodLevel(20);
							playerToBless.setSaturation(20);
							playerToBless.setHealth(20);
							playerToBless.setAbsorptionAmount(20);
							playerToBless.sendMessage(ChatColor.DARK_GREEN + "You have been blessed.");
							p.sendMessage(ChatColor.DARK_GREEN + "You've blessed: " + ChatColor.RED + playerToBless.getName());
							return true;
						} else {
							p.sendMessage(ChatColor.DARK_RED + args[0] + " was not found.");
							return false;
					}
				}
		
			}	
				
			} else {
				if (args.length == 0) {
					c.sendMessage(ChatColor.GOLD + "I CAN SEE IT ALL!!!");
					return true;
				}
				
				
				if (args.length == 1) {
					for (Player playerToBless : Bukkit.getServer().getOnlinePlayers()) {
						if	(playerToBless.getName().equalsIgnoreCase(args[0])) {
							playerToBless.setFoodLevel(20);
							playerToBless.setSaturation(20);
							playerToBless.setHealth(20);
							playerToBless.setAbsorptionAmount(20);
							playerToBless.sendMessage(ChatColor.DARK_GREEN + "You have been blessed.");
							c.sendMessage(ChatColor.DARK_GREEN + "You've blessed: " + ChatColor.RED + playerToBless.getName());
							return true;
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
