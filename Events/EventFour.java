package me.captaincrazybro.crazyPlugin.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import me.captaincrazybro.crazyPlugin.Items.CustomItems;


public class EventFour implements Listener {
	private CustomItems ci = new CustomItems();
	
	@EventHandler
	public void onPunch(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		ci.giveItems(player);
	}

}
