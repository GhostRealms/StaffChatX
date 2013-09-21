package me.riverm;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class StaffChatX extends JavaPlugin {
	
	String prefix;
	
	public void onEnable() {
		this.saveDefaultConfig();
		prefix = colorize(this.getConfig().getString("prefix"));
		
	}
	public void onDisable() {
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("sc")) {
			if(sender instanceof Player) {
				String msg = StringUtils.join(args);
				Player p = (Player) sender;
				if(sender.hasPermission("staffchat.chat") || sender.isOp()) {
					sendStaffMsg(p, msg);
				}
			}
		}
		return false;
	}
	
	private void sendStaffMsg(Player p, String msg) {
		for(Player ops : Bukkit.getServer().getOnlinePlayers()) {
			if(ops.isOp()) {
				p.sendMessage(prefix + " " + ChatColor.WHITE + p.getName() + ": " + msg);
			}
		}
		
	}
	String colorize(String m) {
		m = m.replaceAll("&", "§");
		return m;
	}
}
