package me.riverm;

import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {
	
	public void onEnable() {
		getCommand("sc").setExecutor(new scexe());
		getCommand("scinfo").setExecutor(new scinfoexe());
	}
	
	public void onDisable() {
		
	}
}
