package tk.halfarsedcentral.plugins.drop.main;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
 
public class game extends BukkitRunnable {
 
    private final JavaPlugin plugin;
 
    public game(JavaPlugin plugin) {
        this.plugin = plugin;
    }
 
    public void run() {
        // What you want to schedule goes here
        plugin.getServer().broadcastMessage("Welcome to Bukkit! Remember to read the documentation!");
    }
 
}