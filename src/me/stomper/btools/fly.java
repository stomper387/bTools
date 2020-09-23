package me.stomper.btools;



import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;


public class fly implements CommandExecutor{

	@Override
	public boolean onCommand( CommandSender sender,  Command cmd,  String label, String[] args) {
		Player player = (Player) sender;
		if (!(sender instanceof Player)){
			sender.sendMessage("You cannot fly as console.");
			return true;
		}
		
		if (!(player.hasPermission("btools.fly"))) {
			 player.sendMessage(ChatColor.DARK_RED + "You do not have the sufficient permissions");
		}
		
		if (player.hasPermission("btools.fly")) {
			if (player.isFlying()) {
				player.setFlying(false);
				player.setAllowFlight(false);
				player.sendMessage(ChatColor.DARK_GREEN + "You are no longer flying.");
				return true;
				} else {
				player.setAllowFlight(true);
				player.setFlying(true);
				player.sendMessage(ChatColor.DARK_GREEN + "You are now flying.");
				return true;
				}
		}
		return false;
	}
}