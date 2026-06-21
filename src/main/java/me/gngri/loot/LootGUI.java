package me.gngri.loot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class LootGUI {

    public static void openLoot(Player player, int page) {

        String title = ChatColor.translateAlternateColorCodes('&',
                "&bLoot Page " + page
        );

        Inventory gui = Bukkit.createInventory(null, 54, title);

        // Load saved items
        LootManager.loadPage(page, gui);

        // Next button
        ItemStack next = new ItemStack(Material.ARROW);
        gui.setItem(53, next);

        // Previous button
        ItemStack prev = new ItemStack(Material.ARROW);
        gui.setItem(45, prev);

        player.openInventory(gui);
    }
}
