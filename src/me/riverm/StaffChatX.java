package me.riverm;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class StaffChatX extends JavaPlugin {
	
	
	public void onEnable() {
		this.saveDefaultConfig();
	}
	public void onDisable() {
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("sc")) {
		    if(!(sender instanceof Player)) {
		        return false;
		    }
		    if (args.length == 0 || !(sender.hasPermission("StaffChatX.send"))) {
		        return false;
		    } else {
		    String sperm = "StaffChatX.receive";
		       
		    String msg = StringUtils.join(args, " ");
		    Player play = (Player) sender;
		    
		    for(Player p : Bukkit.getServer().getOnlinePlayers()) {
		    	if (p.hasPermission(sperm)) {
		    		String message = this.getConfig().getString("prefix");
		            message = message.replaceAll("&", "§");
		    		p.sendMessage(ChatColor.BLUE + message + " " + ChatColor.WHITE + play.getDisplayName() + "> " + msg);
		    		}
		    	}
		    }
	    }
		return false;	
	}

}
