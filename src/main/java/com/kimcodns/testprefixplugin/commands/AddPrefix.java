package com.kimcodns.testprefixplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.kimcodns.testprefixplugin.data.PlayerData;
import com.kimcodns.testprefixplugin.PrefixBook;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class AddPrefix implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("칭호북")) {
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage("플레이어만 이 명령어를 사용할 수 있습니다.");
                return true;
            }
            String targetUsername = commandSender.getName();
            Player targetPlayer = Bukkit.getPlayer(targetUsername);
            try {
                String titleName = strings[0];



                if(PlayerData.isManager(targetPlayer)) {
                    if (strings.length != 1) {
                        commandSender.sendMessage("사용법: /칭호북 <칭호이름>");
                        return true;
                    }

                    commandSender.sendMessage(targetUsername + "님에게 " + titleName +
                            " 칭호북을 지급했습니다.");
                    PrefixBook newBook = new PrefixBook(titleName);
                    newBook.getBook(targetPlayer);
                    return true;
                }
                else{
                    commandSender.sendMessage("이 명령어는 관리자만 사용할 수 있습니다.");
                }
            } catch(ArrayIndexOutOfBoundsException e) {
                targetPlayer.sendMessage("사용법: /칭호북 <칭호이름>");
            }
        }

        return false;
    }
}
