package me.stomper.btools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class heal implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("heal")) {
			if (!(sender instanceof Player)) {
			sender.sendMessage("You cannot heal console.");
			return true;
			}
			Player player = (Player) sender;
			if (!player.hasPermission("btools.heal")) {
				player.sendMessage(ChatColor.DARK_RED + "You do not have the sufficient permissions");
				return true;
			}
			if (args.length == 0) {
				player.setHealth(20);
				player.setFoodLevel(20);
				player.sendMessage(ChatColor.DARK_GREEN + "You have been healed.");
				return true;
			}
			
			if (args.length == 1) {
				
				boolean playerFound = false;
				
				for (Player playerToHeal : Bukkit.getServer().getOnlinePlayers()) {
					if(playerToHeal.getName().equalsIgnoreCase(args[0])) {
						playerToHeal.setHealth(20.0);
						playerToHeal.setFoodLevel(20);
						playerToHeal.sendMessage(ChatColor.DARK_GREEN + "You have been healed by " + player.getName());
						player.sendMessage(ChatColor.DARK_GREEN + playerToHeal.getName() + " was healed successfully");
						playerFound = true;
						break;
					}
				}
				if (playerFound == false) {
					player.sendMessage(ChatColor.DARK_RED + args[0] + " was not found");
				}
				
			} else player.sendMessage(ChatColor.DARK_RED + "correct usage: /heal <username>");
			
			return true;
		}

		return false;
	}

}
