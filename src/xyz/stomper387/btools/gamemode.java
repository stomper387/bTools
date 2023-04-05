package xyz.stomper387.btools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class gamemode implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			ConsoleCommandSender c = Bukkit.getServer().getConsoleSender();
			c.sendMessage(ChatColor.DARK_RED + "Currently out of use by console.");
			return true;
		}
		
		// gamemode survival shortcut
		
		
		
		if (label.equalsIgnoreCase("gms")) {
			Player p = (Player) sender;
			if (!(p.hasPermission("btools.gamemode"))) {
				p.sendMessage((ChatColor.DARK_RED + "You do not have permission."));
				return false;
			} else {
				p.setGameMode(GameMode.SURVIVAL);
				p.sendMessage(ChatColor.DARK_GREEN + "Your gamemode has been set to: " + ChatColor.RED + "Survival.");
				p.spawnParticle(Particle.VILLAGER_HAPPY, p.getEyeLocation(), 100);
				p.playSound(p.getEyeLocation(), Sound.BLOCK_ANVIL_USE, SoundCategory.PLAYERS , 50, 50);
				return true;
			}
			
		}
		
		// gamemode creative shortcut
		
		if (label.equalsIgnoreCase("gmc")) {
			Player p = (Player) sender;
			if (!(p.hasPermission("btools.gamemode"))) {
				p.sendMessage((ChatColor.DARK_RED + "You do not have permission."));
				return false;
			} else {
				p.setGameMode(GameMode.CREATIVE);
				p.sendMessage(ChatColor.DARK_GREEN + "Your gamemode has been set to: " + ChatColor.RED + "Creative.");
				p.spawnParticle(Particle.VILLAGER_HAPPY, p.getEyeLocation(), 100);
				p.playSound(p.getEyeLocation(), Sound.BLOCK_ANVIL_USE, SoundCategory.PLAYERS , 50, 50);
				return true;
			}
			
		}
		
		
		// main gamemode branch
		
		
		if (label.equalsIgnoreCase("gamemode")) {
			
			Player p = (Player) sender;
		
			if (!(p.hasPermission("btools.gamemode"))) {
				p.sendMessage((ChatColor.DARK_RED + "You do not have permission."));
				return false;
			}
			
			
			if (args.length == 0) {
				p.sendMessage(ChatColor.DARK_RED + "Usage: /<gamemode> <mode> <username>");
				return false;
			}
			
			
			if (args.length == 1) {
					
				Location pl = p.getEyeLocation();
					
					if (args[0].equalsIgnoreCase("survival")) {
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage(ChatColor.DARK_GREEN + "Your gamemode has been set to: " + ChatColor.RED + "Survival.");
						p.spawnParticle(Particle.VILLAGER_HAPPY, pl, 100);
						p.playSound(pl, Sound.BLOCK_ANVIL_USE, SoundCategory.PLAYERS , 50, 50);
						return true;
					} 
					
					if (args[0].equalsIgnoreCase("creative")) {
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage(ChatColor.DARK_GREEN + "Your gamemode has been set to: " + ChatColor.RED + "Creative.");
						p.spawnParticle(Particle.VILLAGER_HAPPY, pl, 100);
						p.playSound(pl, Sound.BLOCK_ANVIL_USE, SoundCategory.PLAYERS , 50, 50);
						return true;
					}
					
					if (args[0].equalsIgnoreCase("spectator")) {
						p.setGameMode(GameMode.SPECTATOR);
						p.sendMessage(ChatColor.DARK_GREEN + "Your gamemode has been set to: " + ChatColor.RED + "Spectator.");
						p.spawnParticle(Particle.VILLAGER_HAPPY, pl, 100);
						p.playSound(pl, Sound.BLOCK_ANVIL_USE, SoundCategory.PLAYERS , 50, 50);
						return true;
					}
					
					if (args[0].equalsIgnoreCase("adventure")) {
						p.setGameMode(GameMode.ADVENTURE);
						p.sendMessage(ChatColor.DARK_GREEN + "Your gamemode has been set to: " + ChatColor.RED + "Adventure.");
						p.spawnParticle(Particle.VILLAGER_HAPPY, pl, 100);
						p.playSound(pl, Sound.BLOCK_ANVIL_USE, SoundCategory.PLAYERS , 50, 50);
						return true;
					}	
			}
			
			if (args.length == 2) {
				
				Location pl = p.getEyeLocation();
				
				for (Player playerToGamemode : Bukkit.getServer().getOnlinePlayers()) {
					
					
					if (playerToGamemode.getName().equalsIgnoreCase(args[1])) {
						
						if (args[0].equalsIgnoreCase("survival")) {
							playerToGamemode.setGameMode(GameMode.SURVIVAL);
							playerToGamemode.sendMessage(ChatColor.DARK_GREEN + "Your gamemode has been set to " + ChatColor.RED + "survival by: "+ ChatColor.DARK_GREEN + p.getName());
							playerToGamemode.spawnParticle(Particle.VILLAGER_HAPPY, pl, 100);
							playerToGamemode.playSound(pl, Sound.BLOCK_ANVIL_USE, SoundCategory.PLAYERS , 50, 50);
							p.sendMessage(ChatColor.DARK_GREEN + playerToGamemode.getName() + " has been set to survival.");
							return true;
						} 
						
						if (args[0].equalsIgnoreCase("creative")) {
							playerToGamemode.setGameMode(GameMode.CREATIVE);
							playerToGamemode.sendMessage(ChatColor.DARK_GREEN + "Your gamemode has been set to " + ChatColor.RED + "creative by: "+ ChatColor.DARK_GREEN + p.getName());
							playerToGamemode.spawnParticle(Particle.VILLAGER_HAPPY, pl, 100);
							playerToGamemode.playSound(pl, Sound.BLOCK_ANVIL_USE, SoundCategory.PLAYERS , 50, 50);
							p.sendMessage(ChatColor.DARK_GREEN + playerToGamemode.getName() + " has been set to creative.");
							return true;
						}
						
						if (args[0].equalsIgnoreCase("spectator")) {
							playerToGamemode.setGameMode(GameMode.SPECTATOR);
							playerToGamemode.sendMessage(ChatColor.DARK_GREEN + "Your gamemode has been set to " + ChatColor.RED + "spectator by: "+ ChatColor.DARK_GREEN + p.getName());
							playerToGamemode.spawnParticle(Particle.VILLAGER_HAPPY, pl, 100);
							playerToGamemode.playSound(pl, Sound.BLOCK_ANVIL_USE, SoundCategory.PLAYERS , 50, 50);
							p.sendMessage(ChatColor.DARK_GREEN + playerToGamemode.getName() + " has been set to spectator.");
							return true;
						}
						
						if (args[0].equalsIgnoreCase("adventure")) {
							playerToGamemode.setGameMode(GameMode.ADVENTURE);
							playerToGamemode.sendMessage(ChatColor.DARK_GREEN + "Your gamemode has been set to " + ChatColor.RED + "adventure by: "+ ChatColor.DARK_GREEN + p.getName());
							playerToGamemode.spawnParticle(Particle.VILLAGER_HAPPY, pl, 100);
							playerToGamemode.playSound(pl, Sound.BLOCK_ANVIL_USE, SoundCategory.PLAYERS , 50, 50);
							p.sendMessage(ChatColor.DARK_GREEN + playerToGamemode.getName() + " has been set to adventure.");
							return true;
						}	
						
						
					} else {
						p.sendMessage(ChatColor.DARK_RED + args[1] + " was not found.");
						return false;
					}
				}
			}
			
		}
		return false;
	}
}

// by: stomper387