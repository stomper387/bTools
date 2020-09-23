package me.stomper.btools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class gmc implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("gmc")) {
			Player player = (Player) sender;
			if (!player.hasPermission("btools.gmc")) {
				player.sendMessage(ChatColor.DARK_RED + "You do not have the sufficient permissions");
				return true;
			}
			
			if (args.length == 0) {
				player.setGameMode(GameMode.CREATIVE);
				player.sendMessage(ChatColor.DARK_GREEN + "You have been set into gamemode " + player.getGameMode());
				return true;
			}
			
			if (args.length == 1) {
				
				boolean playerFound = false;
				
				for (Player playerToGMC : Bukkit.getServer().getOnlinePlayers()) {
					if(playerToGMC.getName().equalsIgnoreCase(args[0])) {
						playerToGMC.setGameMode(GameMode.CREATIVE);
						playerToGMC.sendMessage(ChatColor.DARK_GREEN + " You have been set into gamemode " + playerToGMC.getGameMode() + " by " + player.getName());
						player.sendMessage(ChatColor.DARK_GREEN + playerToGMC.getName() + " has been set into " + playerToGMC.getGameMode());
						playerFound = true;
						break;
					}
				}
				if (playerFound == false) {
					player.sendMessage(ChatColor.DARK_RED + args[0] + "was not found");
				}
				
			} else player.sendMessage(ChatColor.DARK_RED + "correct usage: /gmc <username>");
			
			return true;
		}

		return false;
	}

}
