package com.kimcodns.testprefixplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.kimcodns.testprefixplugin.GUI;
import com.kimcodns.testprefixplugin.data.PlayerData;

public class ManagePrefix implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("칭호관리")){
            if(commandSender instanceof Player) {
                Player player = (Player) commandSender;


                if (PlayerData.isManager(player)) {

                    if (strings.length != 1) {
                        commandSender.sendMessage("사용법: /칭호관리 <닉네임>");
                        return true;
                    }

                    String targetUsername = strings[0];
                    Player targetPlayer = Bukkit.getPlayer(targetUsername);

                    GUI gui = new GUI(targetPlayer);
                    gui.managementOpen(player);
                    return true;
                } else {
                    player.sendMessage("관리자만 이 명령어를 사용할 수 있습니다.");
                }
            } else {
                commandSender.sendMessage("플레이어만 이 명령어를 사용할 수 있습니다.");
            }
        }
        return false;
    }
}
