package me.stomper.btools;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class ban implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	Player player = (Player) sender;
			if(label.equalsIgnoreCase("ban")) {
				if(!player.hasPermission("btools.ban")) {
					player.sendMessage(ChatColor.DARK_RED + "You do not have the sufficient permissions");
					return true;
				}
		
				if (args.length == 0) {
					player.sendMessage(ChatColor.DARK_RED + "correct usage: /ban <username>");
					return true;
				}
		
				if (args.length == 1) {
					for (Player playerToBan : Bukkit.getServer().getOnlinePlayers()) {
						if(playerToBan.getName().equalsIgnoreCase(args[0])) {
							Bukkit.getBanList(BanList.Type.NAME).addBan(args[0], null, null, null);
							playerToBan.kickPlayer(ChatColor.DARK_RED + "You have been banned permanently by: " + ChatColor.GOLD + player.getName());
							return true;
						} else {
							player.sendMessage(ChatColor.DARK_RED + playerToBan.getName() + " was not found.");
							return true;
						}
					}
				}
			}
			return true;
	}
}

//ChatColor.DARK_RED +