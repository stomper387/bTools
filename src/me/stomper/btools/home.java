package me.stomper.btools;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class home implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (!(player.hasPermission("btools.home"))) {
			player.sendMessage(ChatColor.DARK_RED + "You do not have the sufficient permissions");
		}
		if (args[0].contains("set")) {
			
		}
			 
		return false;
	}
}
