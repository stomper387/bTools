package xyz.stomper387.btools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class trash implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Inventory inv = Bukkit.createInventory(null, 27, ChatColor.DARK_RED + "THE BURNER");
		
		
			if(!(sender instanceof Player)) {
				ConsoleCommandSender c = Bukkit.getServer().getConsoleSender();
				c.sendMessage(ChatColor.DARK_RED + "Console doesn't have an inventory. Silly :P");
				return true;
			}
		
		
			if (label.equalsIgnoreCase("trash")) {
				Player p = (Player) sender;
				if (!p.hasPermission("btools.trash")) {
					p.sendMessage((ChatColor.DARK_RED + "You do not have permission."));
					return false;
				} else {
					p.openInventory(inv);
					return true;
			}
			}
			
			
			if (label.equalsIgnoreCase("t")) {
				Player p = (Player) sender;
				if (!p.hasPermission("btools.trash")) {
					p.sendMessage((ChatColor.DARK_RED + "You do not have permission."));
					return false;
				} else {
					p.openInventory(inv);
					return true;
			}
			}
		
		return false;
	}
}
