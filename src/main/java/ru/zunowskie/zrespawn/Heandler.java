package ru.zunowskie.zrespawn;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Heandler implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        final Player player = event.getEntity();

        event.setKeepLevel(true);

        new BukkitRunnable() {
            @Override
            public void run() {
                
                player.setGameMode(org.bukkit.GameMode.SURVIVAL);

                player.spigot().respawn();
                player.sendTitle(ZRespawn.getInstance().getConfig().getString("title")
                                .replace("&", "§"),
                        null,
                        10,
                        70,
                        20);
            }
        }.runTaskLater(ZRespawn.getInstance(), 1L); // 1 тик (20 миллисекунд) задержки
    }
}
