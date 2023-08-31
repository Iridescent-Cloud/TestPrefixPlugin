package com.kimcodns.testprefixplugin.events;

import com.kimcodns.testprefixplugin.data.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class chatPrefix implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String playerName = event.getPlayer().getName();
        String chatMessage = event.getMessage();
        String prefix = PlayerData.getAppliedTitle(Bukkit.getPlayer(playerName));

        if(!(prefix.equals(""))) {
            event.setFormat(ChatColor.LIGHT_PURPLE+"["+prefix+"] "+ChatColor.WHITE+playerName+" : "+chatMessage);
        }
    }
}
