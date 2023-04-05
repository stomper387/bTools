package xyz.stomper387.btools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;




public class Main extends JavaPlugin implements Listener {
	
	
	// variables
	
	ConsoleCommandSender c = getServer().getConsoleSender();
	double version = 1.0;
	
	
	// onEnable/Disable
	
	
	public void onEnable() {
		c.sendMessage(ChatColor.GREEN + "bTools by: stomper387." + ChatColor.RED + " v" + version);
		// gamemode/gmc/gms, fly, day/d/night/n, broadcast, seeinv, echest/ec, trash/t, feed, heal, gapple/g, kick & ban
		this.getCommand("gamemode").setExecutor(new gamemode());
		this.getCommand("gmc").setExecutor(new gamemode());
		this.getCommand("gms").setExecutor(new gamemode());
		this.getCommand("fly").setExecutor(new fly());
		this.getCommand("day").setExecutor(new time());
		this.getCommand("d").setExecutor(new time());
		this.getCommand("night").setExecutor(new time());
		this.getCommand("n").setExecutor(new time());
		this.getCommand("broadcast").setExecutor(new broadcast());
		this.getCommand("seeinv").setExecutor(new seeinv());
		this.getCommand("echest").setExecutor(new echest());
		this.getCommand("ec").setExecutor(new echest());
		this.getCommand("trash").setExecutor(new trash());
		this.getCommand("t").setExecutor(new trash());
		this.getCommand("feed").setExecutor(new feed());
		this.getCommand("heal").setExecutor(new heal());
		this.getCommand("gapple").setExecutor(new gapple());
		this.getCommand("g").setExecutor(new gapple());
		this.getCommand("kick").setExecutor(new kick());
		this.getCommand("ban").setExecutor(new ban());
		Bukkit.getPluginManager().registerEvents(this, this);
		
	}
	
	
	public void onDisable() {
		Bukkit.getWorld("world").save(); // <3
		c.sendMessage(ChatColor.DARK_RED + "SERVER MUST BE RELOADING");
	}
	
	
	// join and leave events
	
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent ev) {
		Player p = (Player) ev.getPlayer();
		ev.setQuitMessage(ChatColor.DARK_RED + p.getName() + ChatColor.BOLD + " has left the server!");
	}
	
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent ev) {
		Player p = (Player) ev.getPlayer();
			ev.setJoinMessage(null);
			if (!(p.hasPlayedBefore())) {
				Bukkit.broadcastMessage(ChatColor.RED + p.getName() + ChatColor.GOLD + ChatColor.BOLD + " has joined for the first time!");
			} else {
		    	ev.setJoinMessage(ChatColor.RED + p.getName() + ChatColor.GOLD + ChatColor.BOLD + " has joined back!"); // credit - jenn <3

		}
	} 

}

// by: stomper387
//
// credits:
// jenn <3 - you know what you've done :)
