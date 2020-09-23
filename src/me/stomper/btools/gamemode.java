package me.stomper.btools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class gamemode implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("gamemode")) {
			Player player = (Player) sender;
			if (!player.hasPermission("btools.gamemode")) {
				player.sendMessage(ChatColor.DARK_RED + "You do not have the sufficient permissions");
				return true;
			}
				
				if (args.length == 0) {
					player.sendMessage(ChatColor.DARK_GREEN + "correct usage: /gamemode <1,2> <username>");
					return true;
				}
				
			
				if (args[0].contains("1")) {
				for (Player playerToGMCA : Bukkit.getServer().getOnlinePlayers()) {
					if(playerToGMCA.getName().equalsIgnoreCase(args[1])) {
						playerToGMCA.setGameMode(GameMode.CREATIVE);
						playerToGMCA.sendMessage(ChatColor.DARK_GREEN + " You have been set into gamemode " + playerToGMCA.getGameMode() + " by " + player.getName());
						player.sendMessage(ChatColor.DARK_GREEN + playerToGMCA.getName() + " has been set into " + playerToGMCA.getGameMode());
					}
				}
				}
				if (args[0].contains("0")) {
				for (Player playerToGMSA : Bukkit.getServer().getOnlinePlayers()) {
					if(playerToGMSA.getName().equalsIgnoreCase(args[1])) {
						playerToGMSA.setGameMode(GameMode.SURVIVAL);
						playerToGMSA.sendMessage(ChatColor.DARK_GREEN + "You have been set into gamemode " + playerToGMSA.getGameMode() + " by " + player.getName());
						player.sendMessage(ChatColor.DARK_GREEN + playerToGMSA.getName() + " has been set into " + playerToGMSA.getGameMode());
						
					}
				}
				}
				
		}
		return false;
	}
}
		
	


						

			
