package me.stomper.btools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;




public class kick implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	Player player = (Player) sender;
	
			if(label.equalsIgnoreCase("kick")) {
				if(!player.hasPermission("btools.kick")) {
					player.sendMessage(ChatColor.DARK_RED + "You do not have the sufficient permissions");
					return true;
			}
		
				boolean playerFound = false;
		
				if (args.length == 1) {
					for (Player playerToKick : Bukkit.getServer().getOnlinePlayers()) {
						if(playerToKick.getName().equalsIgnoreCase(args[0])) {
							playerToKick.kickPlayer(ChatColor.DARK_RED + "You have been kicked by " + ChatColor.GOLD + player.getName());
							player.sendMessage(ChatColor.DARK_RED + playerToKick.getName() + " has been kicked successfully");
							playerFound = true;
							break;
						}
					}
				if (playerFound == false) {
					player.sendMessage(ChatColor.DARK_RED + args[0] + " was not found");
				}
				} else player.sendMessage(ChatColor.DARK_RED + "correct usage: /kick <username>");
		}
		return true;
	}
}