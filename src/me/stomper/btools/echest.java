package me.stomper.btools;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class echest implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			Player player = (Player) sender;
			if (label.equalsIgnoreCase("echest")) {
			if(player.hasPermission("btools.echest")) {
			player.openInventory(player.getEnderChest());
			player.sendMessage(ChatColor.DARK_GREEN + "Opened Ender Chest");
			
			} else {
			player.sendMessage(ChatColor.DARK_RED + "You do not have the sufficient permissions");
			}
			}
			return false;
	}
}