package me.riverm;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class scinfoexe implements CommandExecutor {
	private main plugin;

	@Override
	public boolean onCommand(CommandSender sdr, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("scinfo") && sdr.hasPermission("StaffChatX.info")) {
			if (args.length == 0) {
				sdr.sendMessage(ChatColor.BLUE + "StaffChatX: " + ChatColor.WHITE + "Version - 1.0 -- By Rmarmorstein." );
			} else if (args.length == 1) {
				if(args[1].equalsIgnoreCase("help")) {
					sdr.sendMessage(ChatColor.BLUE + "StaffChatX Help - /sc <message> Broadcast Staff-Chat Message");
				} else if(args[1].equalsIgnoreCase("git")) {
					sdr.sendMessage("GitHub - https://github.com/Rmarmorstein/StaffChatX");
				} else if(args[1].equalsIgnoreCase("version")) {
					sdr.sendMessage(ChatColor.BLUE + "StaffChatX Version - " + ChatColor.WHITE + plugin.pdfFile.getVersion());
				}
			} else {
				sdr.sendMessage(ChatColor.RED + "Error: " + ChatColor.WHITE + "Invalid Arguments. see /scinfo");
			}
			
		}
		return false;
	}

}
