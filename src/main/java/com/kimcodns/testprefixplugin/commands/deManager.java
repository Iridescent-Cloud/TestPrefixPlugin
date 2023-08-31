package com.kimcodns.testprefixplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.kimcodns.testprefixplugin.data.PlayerData;

public class deManager implements CommandExecutor {
    /*
    특정 유저의 관리자 권한을 박탈하는 명령어입니다.
    사용법: /deManager <username>
     */
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("deManager")) {
            if (strings.length != 1) {
                commandSender.sendMessage("사용법: /deManager <닉네임>");
                return true;
            }

            String targetUsername = strings[0];
            Player targetPlayer = Bukkit.getPlayer(targetUsername);

            if (targetPlayer == null) {
                commandSender.sendMessage(targetUsername + "라는 닉네임을 가진 플레이어를 찾을 수 없습니다.");
                return true;
            }

            if(PlayerData.isManager(targetPlayer)) {
                PlayerData.deManager(targetPlayer);
                commandSender.sendMessage(targetUsername + "님의 Manager 권한을 박탈했습니다.");
                return true;
            }
            else{
                commandSender.sendMessage(targetUsername + "님은 manager가 아닙니다.");
            }
        }

        return false;
    }
}
