package me.captaincrazybro.crazyPlugin.Events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import net.md_5.bungee.api.ChatColor;

public class EventTwo implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Action action = event.getAction();
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
		
		if(action.equals(Action.LEFT_CLICK_BLOCK)){
			if(block.getType().equals(Material.EMERALD_BLOCK)){
				if(player.getHealth() != 20) {
					player.sendMessage(ChatColor.GREEN + "You have been healed for:" + ChatColor.RED + " +1 health");
					player.setHealth(player.getHealth() + 1);
				}
			}else {
				player.sendMessage(ChatColor.GOLD + "You clicked: " + ChatColor.RED + block.getType().toString().toUpperCase());
			}
		}	
	}
}
