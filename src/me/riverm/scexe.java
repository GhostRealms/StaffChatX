package me.riverm;


import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class scexe implements CommandExecutor {

	public boolean onCommand(CommandSender sndr, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("sc")) {
		    if(!(sndr instanceof Player)) {
		        return false;
		    }
		    if (args.length == 0) {
		        return false;
		    }  
		    Player player = (Player) sndr;
		       
		    String msg = StringUtils.join(args, " ");
		    for(Player p: Bukkit.getServer().getOnlinePlayers()) {
		    	if (p.hasPermission("StaffChatX.chat")) {
				    Bukkit.broadcastMessage(ChatColor.BLUE + "[STAFF] " + ChatColor.WHITE + player.getDisplayName() + "> " + ChatColor.GRAY + msg);
		    	}
		    }
		}
		return false;
	}

}
