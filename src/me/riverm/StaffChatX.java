package me.riverm;

import org.bukkit.plugin.java.JavaPlugin;

public final class StaffChatX extends JavaPlugin {
	
	
	public void onEnable() {
		getCommand("sc").setExecutor(new sc());
		this.saveDefaultConfig();
	}
	
	public void onDisable() {
		
	}
}
