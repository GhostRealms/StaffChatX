package me.riverm;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {
	
	PluginDescriptionFile pdfFile = this.getDescription();
	
	public void onEnable() {
		getCommand("sc").setExecutor(new scexe());
		getCommand("scinfo").setExecutor(new scinfoexe());
	}
	
	public void onDisable() {
		
	}
}
