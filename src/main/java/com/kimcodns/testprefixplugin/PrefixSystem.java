package com.kimcodns.testprefixplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PrefixSystem implements Listener {

    public static ItemStack createBookItem(String title) {
        /*
        칭호를 보유하고 있을 경우 GUI에 Minecraft.Book 아이템으로 나타내어지는 메소드입니다.
         */
        final List<String> prefixLore = new ArrayList<>();
        prefixLore.add(" ");
        prefixLore.add(ChatColor.WHITE+"- 좌클릭시 칭호를 "+ChatColor.RED+"해제"+ChatColor.WHITE+"합니다.");
        prefixLore.add(ChatColor.WHITE+"- 우클릭시 칭호를 "+ChatColor.GREEN+"장착"+ChatColor.WHITE+"합니다.");

        ItemStack item = new ItemStack(Material.BOOK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE+"칭호 :: ["+title+"] 칭호");
        meta.setLore(prefixLore);
        item.setItemMeta(meta);
        return item;
    }
}
