package com.kimcodns.testprefixplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PrefixBook implements Listener {
    ItemStack book = new ItemStack(Material.BOOK, 1);

    public PrefixBook(String titleName){
        ItemMeta meta = book.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "칭호 :: [" + titleName + "]");

        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.LIGHT_PURPLE + "[!] :: " + ChatColor.WHITE + "우클릭시 칭호를 획득합니다.");
        meta.setLore(lore);
        book.setItemMeta(meta);
    }

    public void getBook(Player target){
        target.getInventory().addItem(book);
    }
}
