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

public class InventoryClick implements Listener {

    @EventHandler
    public void inventoryClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        Inventory clickedInventory = event.getClickedInventory();

        if (clickedInventory != null && clickedInventory.getHolder() != null) {
            String inventoryTitle = event.getView().getTitle();

            if (inventoryTitle.equals("칭호 목록")) {
                event.setCancelled(true);
                ItemStack clickedItem = event.getCurrentItem();

                if (clickedItem != null && clickedItem.getType() != Material.AIR) {
                    String title = clickedItem.getItemMeta().getDisplayName();
                    String[] titleSet = title.split("\\[");
                    String[] titleSet2 = titleSet[1].split("]");
                    String prefix = titleSet2[0];

                    if(event.getClick().equals(ClickType.RIGHT)) {
                        if (PlayerData.hasPlayerTitle(player, prefix)) {
                            if (PlayerData.getAppliedTitle(player).equals(prefix)) {
                                player.sendMessage("이미 그 칭호를 장착하고 있습니다.");
                            } else if (PlayerData.getAppliedTitle(player).equals("")) {
                                PlayerData.applyTitle(player, prefix);
                                player.sendMessage(prefix + " 칭호를 장착하였습니다.");
                            } else {
                                PlayerData.delAppliedTitle(player);
                                PlayerData.applyTitle(player, prefix);
                                player.sendMessage(prefix + " 칭호를 장착하였습니다.");
                            }
                        } else {
                                player.sendMessage(prefix + " 칭호를 보유하고 있지 않습니다.");
                        }
                    } else if (event.getClick().equals(ClickType.LEFT)) {
                        if (PlayerData.hasPlayerTitle(player, prefix)) {
                            if (PlayerData.getAppliedTitle(player).equals(prefix)) {
                                PlayerData.delAppliedTitle(player);
                                player.sendMessage(prefix + " 칭호를 해제하였습니다.");
                            } else {
                                player.sendMessage("해당 칭호를 장착하고 있지 않습니다.");
                            }
                        } else {
                            player.sendMessage(prefix + " 칭호를 보유하고 있지 않습니다.");
                        }
                    }
                    player.closeInventory();
                }
            }
        }
    }
}
