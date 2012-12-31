/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package me.daneuz23;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
/**
 *
 * @author Aaron Neuzil
 */
public class ServerStatusSender extends JavaPlugin {
        
	public void onEnable(){
		getLogger().info("onEnable has been invoked!");
	}
 
	public void onDisable(){
		getLogger().info("onDisable has been invoked!");
	}
        
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
             if (cmd.getName().equalsIgnoreCase("basic2")) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("This command can only be run by a player.");
		} else {
			Player player = (Player) sender;
			// do something
		}
		return true;
	}
            return false;

        }
}