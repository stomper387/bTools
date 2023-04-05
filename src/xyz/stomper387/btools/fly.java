package xyz.stomper387.btools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class fly implements CommandExecutor {
	public boolean onCommand( CommandSender sender,  Command cmd,  String label, String[] args) {
		
		
		if(!(sender instanceof Player)) {
			ConsoleCommandSender c = Bukkit.getServer().getConsoleSender();
			c.sendMessage(ChatColor.DARK_RED + "Cannot fly as console. Silly :P");
			return false;
		}
		
		
		if (label.equalsIgnoreCase("fly")) {
			
			
			Player p = (Player) sender;
			
			
			if (!(p.hasPermission("btools.fly"))) {
				p.sendMessage((ChatColor.DARK_RED + "You do not have permission."));
				return false;
			}
			
			
				if (p.isFlying()) {
						p.setFlying(false);
						p.setAllowFlight(false);
						p.playSound(p.getEyeLocation(), Sound.BLOCK_ANVIL_FALL, SoundCategory.PLAYERS, 100, 100);
						p.sendMessage(ChatColor.DARK_GREEN + "You are no longer flying.");
						return true;
				} else {
						p.setAllowFlight(true);
						p.setFlying(true);
						p.playSound(p.getEyeLocation(), Sound.ENTITY_PARROT_FLY, SoundCategory.PLAYERS, 100, 100);
						p.sendMessage(ChatColor.DARK_GREEN + "You are now flying.");
						return true;
				}
				
		}
		return false;
	}
}

//by: stomper387