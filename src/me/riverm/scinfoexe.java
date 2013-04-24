package me.riverm;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class scinfoexe implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sdr, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("scinfo") && sdr.hasPermission("StaffChatX.info")) {
			sdr.sendMessage(ChatColor.BLUE + "StaffChatX: " + ChatColor.WHITE + "Version - Beta -- By Rmarmorstein." );
			
		}
		return false;
	}

}
