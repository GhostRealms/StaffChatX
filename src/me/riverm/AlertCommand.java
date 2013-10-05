package me.riverm;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AlertCommand implements CommandExecutor {
	
	private StaffChatX plugin;
	String prefix = plugin.colorize(plugin.getConfig().getString("alert.prefix"));
	boolean sounds = plugin.getConfig().getBoolean("alert.play-sound");
	String color = plugin.getConfig().getString("alert.color");

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
			sender.sendMessage(prefix + " " + ChatColor.RED + "Invalid Arguments, please supply a message");
		} else if(args.length >= 1 && sender.hasPermission("staffchat.alert")) {
			if(sounds) {
				String msg = StringUtils.join(args, " ");
				for(Player p : Bukkit.getServer().getOnlinePlayers()) {
					p.sendMessage(prefix + " " + plugin.colorize(msg));
					p.playSound(p.getLocation(), Sound.ORB_PICKUP, 10, 1);
				}
			} else {
				String msg = StringUtils.join(args, " ");
				for(Player p : Bukkit.getServer().getOnlinePlayers()) {
					p.sendMessage(prefix +  " " + plugin.colorize(msg));
				}
			}
		} else {
			sender.sendMessage(prefix + " " + ChatColor.RED + "You dont have permission to preform this action");
		}
		return false;
	}

}
