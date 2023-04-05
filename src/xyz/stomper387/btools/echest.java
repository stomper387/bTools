package xyz.stomper387.btools;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class echest implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
			ConsoleCommandSender c = Bukkit.getServer().getConsoleSender();
		
			
			if (!(sender instanceof Player)) {
				c.sendMessage(ChatColor.DARK_RED + "Console doesn't have an echest. Silly :P");
				return false;
			}
		
		
			if (label.equalsIgnoreCase("echest")) {
				
				Player p = (Player) sender;
				
				if(!(p.hasPermission("btools.echest"))) {
					p.sendMessage((ChatColor.DARK_RED + "You do not have permission."));
					return false;
				} else {
					p.openInventory(p.getEnderChest());
					p.saveData();
					return true;
				}
					
				
			}
			
			if (label.equalsIgnoreCase("ec")) {
				
				Player p = (Player) sender;
				
				if(!(p.hasPermission("btools.echest"))) {
					p.sendMessage((ChatColor.DARK_RED + "You do not have permission."));
					return false;
				} else {
					p.openInventory(p.getEnderChest());
					p.saveData();
					return true;
				}
				
				
			}
			return false;
	}
}

//by: stomper387