package com.kimcodns.testprefixplugin.events;

import com.kimcodns.testprefixplugin.PrefixBook;
import com.kimcodns.testprefixplugin.data.PlayerData;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class bookRightClick implements Listener {

    @EventHandler
    public static void bookRightClick(PlayerInteractEvent e){
        Player player = e.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if(item.getType() == Material.BOOK){
            ItemMeta meta = item.getItemMeta();
            String title = meta.getDisplayName();
            String[] titleSet = title.split("\\[");
            String[] titleSet2 = titleSet[1].split("]");
            String prefix = titleSet2[0];
            ItemStack itemInHand = player.getInventory().getItemInMainHand();

            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (titleSet[0].equals(ChatColor.LIGHT_PURPLE + "칭호 :: ")) {
                    if (!PlayerData.hasPlayerTitle(player, prefix)) {
                        PlayerData.addPlayerTitle(player, prefix);
                        player.sendMessage(prefix + " 칭호를 획득했습니다.");
                    } else {
                        player.sendMessage(player.getName() + "님은 이미 " + prefix + " 칭호를 가지고 있습니다.");
                    }
                }
            }
        }
    }
}
