package me.gngri.loot;

import org.bukkit.plugin.java.JavaPlugin;

public final class GNGRILOOTTEST extends JavaPlugin {

    private static GNGRILOOTTEST instance;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        getLogger().info("GNGRILOOTTEST Enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("GNGRILOOTTEST Disabled!");
    }

    public static GNGRILOOTTEST getInstance() {
        return instance;
    }
}
