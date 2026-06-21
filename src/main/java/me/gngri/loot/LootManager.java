package me.gngri.loot;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

public class LootManager {

    public static void savePage(int page, Inventory inventory) {

        File file = new File(
                GNGRILOOTTEST.getInstance().getDataFolder(),
                "loot_" + page + ".yml"
        );

        YamlConfiguration config = new YamlConfiguration();

        for (int i = 0; i < 45; i++) {
            ItemStack item = inventory.getItem(i);

            if (item != null) {
                config.set("items." + i, item);
            }
        }

        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadPage(int page, Inventory inventory) {

        File file = new File(
                GNGRILOOTTEST.getInstance().getDataFolder(),
                "loot_" + page + ".yml"
        );

        if (!file.exists()) {
            return;
        }

        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        for (int i = 0; i < 45; i++) {

            ItemStack item = config.getItemStack("items." + i);

            if (item != null) {
                inventory.setItem(i, item);
            }
        }
    }
}
