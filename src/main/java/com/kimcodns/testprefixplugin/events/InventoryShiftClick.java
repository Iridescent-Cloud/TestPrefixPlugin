package com.kimcodns.testprefixplugin.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.kimcodns.testprefixplugin.data.PlayerData;

public class InventoryShiftClick implements Listener {

    @EventHandler
    public void inventoryShiftClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        Inventory clickedInventory = event.getClickedInventory();

        if (clickedInventory != null && clickedInventory.getHolder() != null) {
            String inventoryTitle = event.getView().getTitle();
            Player targetPlayer = (Player) clickedInventory.getHolder();

            if (inventoryTitle.equals("칭호 관리")) {
                event.setCancelled(true);
                ItemStack clickedItem = event.getCurrentItem();

                if (clickedItem != null && clickedItem.getType() != Material.AIR) {
                    String title = clickedItem.getItemMeta().getDisplayName();
                    String[] titleSet = title.split("\\[");
                    String[] titleSet2 = titleSet[1].split("]");
                    String prefix = titleSet2[0];


                  if (event.getClick().equals(ClickType.SHIFT_RIGHT)) {
                        if (PlayerData.hasPlayerTitle(targetPlayer, prefix)) {
                            if (PlayerData.getAppliedTitle(targetPlayer).equals(prefix)) {
                                PlayerData.delAppliedTitle(targetPlayer);
                                PlayerData.delPlayerTitle(targetPlayer, prefix);
                                player.sendMessage(targetPlayer.getName() + " 님의 " + prefix + " 칭호를 삭제하였습니다.");
                            } else {
                                PlayerData.delPlayerTitle(targetPlayer, prefix);
                                player.sendMessage(targetPlayer.getName() + " 님의 " + prefix + " 칭호를 삭제하였습니다.");
                            }
                        } else {
                            player.sendMessage(targetPlayer.getName() + " 님은 " + prefix + " 칭호를 보유하고 있지 않습니다.");
                        }
                    }
                }
            }
        }
    }
}
