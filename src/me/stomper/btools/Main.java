package me.stomper.btools;


import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
	

			@Override
			public void onEnable() {
			this.getCommand("heal").setExecutor(new heal()); 
			this.getCommand("fly").setExecutor(new fly());
			this.getCommand("kick").setExecutor(new kick());
			this.getCommand("ban").setExecutor(new ban());
			this.getCommand("echest").setExecutor(new echest());
			this.getCommand("gmc").setExecutor(new gmc());
			this.getCommand("gms").setExecutor(new gms());
			this.getCommand("gamemode").setExecutor(new gamemode());
			this.getCommand("broadcast").setExecutor(new broadcast());
			}
}
