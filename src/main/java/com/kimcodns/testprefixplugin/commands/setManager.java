package com.kimcodns.testprefixplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.kimcodns.testprefixplugin.data.PlayerData;
import org.bukkit.entity.Player;

public class setManager implements CommandExecutor {
    /*
    특정 유저의 권한을 관리자로 설정하는 코드입니다.
    사용법 /setManager <닉네임>
     */
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("setManager")) {
            if (strings.length != 1) {
                commandSender.sendMessage("사용법: /setManager <닉네임>");
                return true;
            }

            String targetUsername = strings[0];
            Player targetPlayer = Bukkit.getPlayer(targetUsername);

            if (targetPlayer == null) {
                commandSender.sendMessage(targetUsername + "라는 닉네임을 가진 플레이어를 찾을 수 없습니다.");
                return true;
            }

            if(!PlayerData.isManager(targetPlayer)) {
                PlayerData.setManager(targetPlayer);
                commandSender.sendMessage(targetUsername + "님이 Manager가 되었습니다.");
                return true;
            }
            else{
                commandSender.sendMessage(targetUsername + "님은 이미 Manager입니다.");
                return true;
            }
        }

        return false;
    }
}
