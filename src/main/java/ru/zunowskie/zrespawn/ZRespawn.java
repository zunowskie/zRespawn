package ru.zunowskie.zrespawn;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ZRespawn extends JavaPlugin {


    public static ZRespawn getInstance(){
        return instance;
    }


    public static ZRespawn instance;

    @Override
    public void onEnable() {
        instance = this;
        this.saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new Heandler(), this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
