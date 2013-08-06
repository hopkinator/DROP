package tk.halfarsedcentral.plugins.drop.main;



import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin {
public int Start = 0;
protected int countdown_id = -1;
protected int countdown_id2 = -1;
protected int countdown_id3 = -1;
public int game = 0;
public void onEnable() {
		
		Bukkit.broadcastMessage(ChatColor.GREEN + "DROP Enabled");
		Start = 0;
		game = 0;
		 Bukkit.getServer().getPluginManager()
		    .registerEvents(new DROPListeners(), this);
		 
		 countdown_id = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
                     if(Bukkit.getOnlinePlayers().length > 3){
         				Bukkit.broadcastMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.BLUE + "----------------------------------------");
         				Bukkit.broadcastMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.GOLD + "Players Online "+Bukkit.getOnlinePlayers().length+"/5");
         				Bukkit.broadcastMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.GOLD + "Get Ready The Game Is About To Start!");
         				Bukkit.broadcastMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.BLUE + "----------------------------------------");
         				Start = 1;
                     }
				
         				 if (Start == 1){
         					 for (int i = 0; i < Bukkit.getOnlinePlayers().length; i++) {
         						 Player[] onlinePlayers = Bukkit.getServer().getOnlinePlayers();
         					 
         							Player player = onlinePlayers[i];
         							player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 99999999, 2));
         							double x = 56;
         							double y = 90;
         							double z = 250;
         							World world = Bukkit.getWorld("world");
         							Location location = new Location( world , x, y, z);
         							player.teleport(location);
         							player.sendMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]"+ChatColor.GOLD+"Teleported To Arena Spawn!");
         							player.setGameMode(GameMode.ADVENTURE);
         							Inventory inventory = player.getInventory();
         							inventory.clear();
         	         				Bukkit.broadcastMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.GOLD + "Game Will Start In One Miniute!");
         	         				player.setNoDamageTicks(100);
         	         				game = 1;
         	         				Bukkit.getServer().getScheduler().cancelTask(countdown_id);
         	         				}
         					 
         						}
         				 
         				 
         				
                     if(Start == 0){
                     if(Bukkit.getOnlinePlayers().length < 4 &&(!(Bukkit.getOnlinePlayers().length == 0))){
          				Bukkit.broadcastMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.BLUE + "----------------------------------------");
          				Bukkit.broadcastMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.GOLD + "Players Online "+Bukkit.getOnlinePlayers().length+"/5");
          				Bukkit.broadcastMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.GOLD + "Minimum Amount of Players are 4");
          				Bukkit.broadcastMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.GOLD + "Restarting Countdown...");
          				Bukkit.broadcastMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.BLUE + "----------------------------------------");
                      }
                     }
             }
     }, 1, 1200);
		 
		 countdown_id2 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
				public void run() {
					if(game == 1){
						Bukkit.broadcastMessage("[" + ChatColor.AQUA + "DROP" + ChatColor.RESET + "]" + ChatColor.GOLD + "The Game Has Started!");
						for (int i = 0; i < Bukkit.getOnlinePlayers().length; i++) {
    						 Player[] onlinePlayers = Bukkit.getServer().getOnlinePlayers();
    					 
    							Player player = onlinePlayers[i];
						    double x = 56;
							double y = 85;
							double z = 250;
							World world = Bukkit.getWorld("world");
							Location start = new Location( world , x, y, z);
							player.teleport(start);
							Bukkit.getServer().getScheduler().cancelTask(countdown_id2);
					}
					}
				}
				}, 1, 200);
		 countdown_id3 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
				public void run() {
					if(game == 1 && Bukkit.getOnlinePlayers().length == 0){
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restartserver");
				}
				}
		 }, 1, 1200);
}
		 


	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		Player player = (Player) sender;
		
		if(commandLabel.equalsIgnoreCase("drop")) {
			if (args.length < 1) {
			player.sendMessage(ChatColor.RED + "Not Enough Arguments!");
			}
			if (args[0].equalsIgnoreCase("start")) {
				Start = 1;
			}
			if (args[0].equalsIgnoreCase("stop")) {
				player.removePotionEffect(PotionEffectType.JUMP);
				Bukkit.broadcastMessage("The Game Was Stopped By An Administrator.");
				Start = 0;
			}
			if (args.length > 1) {
				player.sendMessage(ChatColor.RED + "Too Many Arguments!");
				}
	}
		return false;
	}

	}
