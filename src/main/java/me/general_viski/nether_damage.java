package me.general_viski;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class nether_damage extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new NetherDamageListener(this), this);
        getCommand("netherdamage_reload").setExecutor(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    class NetherDamageListener implements Listener {
        private final nether_damage plugin;
        private final int maxY;
        private final double damage;

        public NetherDamageListener(nether_damage plugin) {
            this.plugin = plugin;
            FileConfiguration config = plugin.getConfig();
            this.maxY = config.getInt("maxY", 127);
            this.damage = config.getDouble("damage", 2.0);
        }

        @EventHandler
        public void onPlayerMove(PlayerMoveEvent event) {
            Player player = event.getPlayer();
            World world = player.getWorld();
            if (world.getEnvironment() == World.Environment.NETHER && player.getLocation().getY() > maxY) {
                if (player.hasPermission("netherdamage.bypass")) return;
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (player.getWorld().getEnvironment() == World.Environment.NETHER && player.getLocation().getY() > maxY) {
                            if (player.hasPermission("netherdamage.bypass")) return;
                            player.damage(damage); // наносит урон из конфига
                        }
                    }
                }.runTaskLater(plugin, 1L);
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("netherdamage_reload")) {
            if (!sender.hasPermission("netherdamage.reload")) {
                sender.sendMessage("§cУ вас нет прав для этой команды.");
                return true;
            }
            reloadConfig();
            sender.sendMessage("§aКонфиг Nether_Damage успешно перезагружен!");
            return true;
        }
        return false;
    }
}
