package me.riverm;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class sc implements CommandExecutor {
	StaffChatX scx = new StaffChatX();

	@Override
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
		    		p.sendMessage(ChatColor.BLUE + scx.getConfig().getString("prefix") + ChatColor.WHITE + play.getDisplayName() + "> " + msg);
		    		}
		    	}
		    }
	    }
		return false;	
	}

}
