package me.captaincrazybro.crazyPlugin.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class text implements Listener {


	@SuppressWarnings("deprecation")
	@EventHandler
	public void onMove (PlayerMoveEvent event){
		
		Player player = event.getPlayer();
		Inventory pInven = player.getInventory();
		ItemStack item = new ItemStack(Material.GOLDEN_APPLE, 1);
		
		if(!player.isOnGround()) {
			player.sendMessage(ChatColor.RED +  "You are moving");
			pInven.addItem(item);
		}
	}
}
