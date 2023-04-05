package xyz.stomper387.btools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class seeinv implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			ConsoleCommandSender c = Bukkit.getServer().getConsoleSender();
			c.sendMessage(ChatColor.DARK_RED + "Console is unable to display inventories.");
			return false;
		}
		
		if (label.equalsIgnoreCase("seeinv")) {
			
			Player p = (Player) sender;
			
			if (!(p.hasPermission("btools.seeinv"))) {
				p.sendMessage((ChatColor.DARK_RED + "You do not have permission."));
				return false;
			}
						
			if (args.length == 0) {
				p.sendMessage(ChatColor.DARK_RED + "Usage: /<seeinv> <username>");
				return false;
			}
			

			for (Player playerToInv : Bukkit.getServer().getOnlinePlayers()) {
				
				if(playerToInv.getName().equalsIgnoreCase(args[0])) {
					
					p.sendMessage(ChatColor.DARK_GREEN + "Opened: "+ ChatColor.RED + playerToInv.getName() + ChatColor.DARK_GREEN + "'s inventory.");
					p.openInventory(playerToInv.getInventory());
				
				return true;
				
				} else {
					p.sendMessage(ChatColor.DARK_RED + args[0] + " was not found.");
					return false;
				}
			}
		}
		
		return false;
	}
}

//by: stomper387