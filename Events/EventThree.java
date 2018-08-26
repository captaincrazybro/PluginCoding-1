package me.captaincrazybro.crazyPlugin.Events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;

import me.captaincrazybro.crazyPlugin.Main;
import net.md_5.bungee.api.ChatColor;

public class EventThree implements Listener {
	private Plugin plugin = Main.getPlugin(Main.class);
	private int count;

	@EventHandler
	public void onBreak(BlockBreakEvent event){
		Block block = event.getBlock();
		Player player = event.getPlayer();
		
		Location b_loc = block.getLocation();
		player.sendMessage(ChatColor.GOLD + "You broke: " + ChatColor.AQUA + block.getType().toString().toUpperCase());
		player.sendMessage(ChatColor.GOLD + "Location: ");
		player.sendMessage(ChatColor.BLUE + "World: " + ChatColor.WHITE + b_loc.getWorld().getName());
		player.sendMessage(ChatColor.BLUE + "X: " + ChatColor.WHITE + b_loc.getBlockX());
		player.sendMessage(ChatColor.BLUE + "Y: " + ChatColor.WHITE + b_loc.getBlockY());
		player.sendMessage(ChatColor.BLUE + "Z: " + ChatColor.WHITE + b_loc.getBlockZ());
	}

	@EventHandler
	public void onPlace(BlockPlaceEvent event){
		Block block = event.getBlock();
		Player player = event.getPlayer();
		
		Location b_loc = block.getLocation();
		player.sendMessage(ChatColor.GOLD + "You Placed: " + ChatColor.GREEN + block.getType().toString().toUpperCase());
		player.sendMessage(ChatColor.GOLD + "Location: ");
		player.sendMessage(ChatColor.BLUE + "World: " + ChatColor.WHITE + b_loc.getWorld().getName());
		player.sendMessage(ChatColor.BLUE + "X: " + ChatColor.WHITE + b_loc.getBlockX());
		player.sendMessage(ChatColor.BLUE + "Y: " + ChatColor.WHITE + b_loc.getBlockY());
		player.sendMessage(ChatColor.BLUE + "Z: " + ChatColor.WHITE + b_loc.getBlockZ());
		
		if(block.getType().equals(Material.TNT)) {
			plugin.getConfig().set("Users." + player.getUniqueId() + ".Block_" + count + ".World", b_loc.getWorld().getName());		
			plugin.getConfig().set("Users." + player.getUniqueId() + ".Block_" + count + ".X", b_loc.getBlockX());	
			plugin.getConfig().set("Users." + player.getUniqueId() + ".Block_" + count + ".Y", b_loc.getBlockY());	
			plugin.getConfig().set("Users." + player.getUniqueId() + ".Block_" + count + ".Z", b_loc.getBlockZ());	
			plugin.saveConfig();
			count++;
		}
				
	}
	
} 
