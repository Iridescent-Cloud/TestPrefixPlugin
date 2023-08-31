package com.kimcodns.testprefixplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import com.kimcodns.testprefixplugin.data.PlayerData;
import com.kimcodns.testprefixplugin.PrefixSystem;

import java.util.ArrayList;

public class GUI implements Listener {
    private final Player targetPlayer;

    public GUI(Player player) {
        targetPlayer = player;
    }

    public void open(Player player){
        Inventory gui;
        gui = Bukkit.createInventory(player, 27, "칭호 목록");
        if(PlayerData.isTherePlayerRecord(player)){
            ArrayList<String> e = PlayerData.getPlayerTitle(player);
            for(int i=0; i<e.size(); i++){
                gui.setItem(i+10, PrefixSystem.createBookItem(e.get(i)));
            }
        }
        player.openInventory(gui);
    }
    public void managementOpen(Player manager){
        Inventory gui;
        gui = Bukkit.createInventory(targetPlayer, 27, "칭호 관리");
        if(PlayerData.isTherePlayerRecord(targetPlayer)){
            ArrayList<String> e = PlayerData.getPlayerTitle(targetPlayer);
            for(int i=0; i<e.size(); i++){
                gui.setItem(i+10, PrefixSystem.createBookItem(e.get(i)));
            }
        }
        manager.openInventory(gui);
    }

}