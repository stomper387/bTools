package me.stomper.btools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class gapple implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("g")) {
			Player player = (Player) sender;
			if (!player.hasPermission("btools.gapple")) {
				player.sendMessage(ChatColor.DARK_RED + "You do not have the sufficient permissions");
				return true;
			}
			if (args.length == 0) {
				player.setHealth(20.0);
				player.setFoodLevel(20);
				player.setAbsorptionAmount(20);
				player.setSaturation(20);		 
				player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 6000, 2));
				player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 6000, 1));
				player.sendMessage(ChatColor.GOLD + "You have been blessed.");
				return true;
			}
			if (args.length == 1) {
				
				boolean playerFound = false;
				
				for (Player playerToBless : Bukkit.getServer().getOnlinePlayers()) {
					if(playerToBless.getName().equalsIgnoreCase(args[0])) {
						playerToBless.setHealth(20.0);
						playerToBless.setFoodLevel(20);
						playerToBless.setAbsorptionAmount(20);
						playerToBless.setSaturation(20);
						playerToBless.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 6000, 2));
						playerToBless.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 6000, 1));
						playerToBless.sendMessage(ChatColor.GOLD + "You have been blessed by " + player.getName());
						player.sendMessage(ChatColor.GOLD + playerToBless.getName() + " was blessed successfully");
						playerFound = true;
						break;
					}
				}
				
				if (playerFound == false) {
					player.sendMessage(ChatColor.DARK_RED + args[0] + " was not found");
				}
			} else player.sendMessage(ChatColor.DARK_RED + "correct usage: /g <username>");
			
			return true;
		}
		
		return true;
	}
}
