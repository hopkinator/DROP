package tk.halfarsedcentral.plugins.drop.main;




import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

public class DROPListeners implements Listener {
	
	
	
	@EventHandler
	public Event onPlayerJoin(PlayerJoinEvent evt) {
	    Player player = evt.getPlayer(); // The player who joined
	    evt.setJoinMessage(ChatColor.AQUA+player.getName()+ChatColor.GOLD+" Joined Drop!");
	        double x = 122;
			double y = 71;
			double z = 218;
			World world = Bukkit.getWorld("world");
			Location spawn = new Location( world , x, y, z);
	    player.teleport(spawn);
	    player.setCompassTarget(spawn);
	    Inventory inventory = player.getInventory();
	    inventory.clear();
	    ItemStack compass = new ItemStack(Material.COMPASS, 1);
	    ItemStack paper = new ItemStack(Material.PAPER, 1);
    	ItemMeta im = compass.getItemMeta();
    	ItemMeta pim = paper.getItemMeta();
    	pim.setDisplayName(ChatColor.GOLD+"1'UP Passes!");
    	im.setDisplayName(ChatColor.RED+"Help");
    	compass.setItemMeta(im);
    	paper.setItemMeta(pim);
	    if (!(inventory.contains(compass))) {
	        inventory.addItem(compass); // Adds a stack of diamonds to the player's inventory
	    }
	    if (!(inventory.contains(paper))) {
	        inventory.addItem(paper); // Adds a stack of diamonds to the player's inventory
	    }
	    
	    
		return null;
	    
	}
	@EventHandler
	public void All(PlayerInteractEvent event) {

		  Player player = event.getPlayer();
		  if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
		  if(player.getItemInHand().getType() == Material.COMPASS) {

				player.sendMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.BLUE + "----------------------------------------");
				player.sendMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.GOLD + "DROP is a custom GameType By");
				player.sendMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.GOLD + "mineman277 & Jlcftw!");
				player.sendMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.BLUE + "----------------------------------------");
				player.sendMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.GOLD + "The Objective of the game is to run ");
				player.sendMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.GOLD + "arround on the pad and not drop into the");
				player.sendMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.GOLD + "void!");
				player.sendMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.BLUE + "----------------------------------------");
				player.sendMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.GOLD + "Last person alive wins!");
				player.sendMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.GOLD + "The game works by having sand on top of tnt");
				player.sendMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.GOLD + "when the tnt drops, so does the sand!");
				player.sendMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.BLUE + "----------------------------------------");
				player.sendMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.GOLD + "Most Importantly, Have Fun!");
				player.sendMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.BLUE + "----------------------------------------");

		  }
		  if(player.getItemInHand().getType() == Material.PAPER) {
			  player.sendMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.GOLD + "Coming Soon!...");
		  }
		  
}
	}
	@EventHandler
	public void death(PlayerDeathEvent evt) {
		Player Player = evt.getEntity();
		evt.setDeathMessage(ChatColor.AQUA+Player.getName()+ChatColor.GOLD+" Has Fallen!");
		
	}
	@EventHandler
	public void respawn(PlayerRespawnEvent evt){
	    double x1 = -13;
		double y1 = 69;
		double z1 = 265;
		World world1 = Bukkit.getWorld("world");
		Location death = new Location( world1 , x1, y1, z1);
		evt.setRespawnLocation(death);
		Player Player = evt.getPlayer();
		Player.removePotionEffect(PotionEffectType.JUMP);
	}
}
