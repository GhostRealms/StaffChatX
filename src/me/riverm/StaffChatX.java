package me.riverm;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class StaffChatX extends JavaPlugin {
	
	public void onEnable() {
		loadConf();
	}
	public void onDisable() {
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("sc")) {
		    if(!(sender instanceof Player)) {
		        return false;
		    }
		    if (args.length == 0 || !(sender.hasPermission("StaffChatX.send")) || !(sender.isOp())) {
		        return false;
		    } else {		       
		    for(Player p : getServer().getOnlinePlayers()) {
		    	if(p.hasPermission("staffchatx.chat") || p.isOp()) {
		    		String format = getConfig().getString("format");
		    		format = StringUtils.replace("%prefix", null, getConfig().getString("prefix"));
		    		format = StringUtils.replace("%player", null, sender.toString());
		    		format = StringUtils.replace("%message", null, StringUtils.join(args, " "));
		    		p.sendMessage(colorize(format));
		    		} else {
		    			sender.sendMessage(colorize(getConfig().getString("prefix")) + ChatColor.RED + " You dont have permission.");
		    		}
		    	}
		    }
		}
		return false;	
	}
	
	String colorize(String m) {
		m = m.replaceAll("&", "§");
		return m;
	}
	
	void loadConf() {
		getConfig().addDefault("prefix", "&c[Staff]");
		getConfig().addDefault("format", "%prefix %player &f: %message");
		getConfig().addDefault("mode", "Not implemented at this time");
		saveConfig();
	}

}
