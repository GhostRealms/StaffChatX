package me.riverm;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class StaffChatX extends JavaPlugin {
	
	Player play;
	String user = play.toString();
	String prefix = colorize(getConfig().getString("prefix"));
	
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
		    String msg = StringUtils.join(args, " ");
		    play = (Player) sender;
		    sendMessage(msg);
		    }
		}
		return false;
	}
	
	void sendMessage(String msg) {
		for(Player p : getServer().getOnlinePlayers()) {
			if(p.hasPermission("staffchatx.chat") || p.isOp()) {
				String m = colorize(msg);
				p.sendMessage(prefix + play.getDisplayName() + ChatColor.WHITE + ": " + m);
			}
		}
	}
	
	String colorize(String m) {
		m = m.replaceAll("&", "§");
		return m;
	}
	
	void loadConf() {
		getConfig().addDefault("prefix", "&c[Staff]");
		saveConfig();
	}

}
