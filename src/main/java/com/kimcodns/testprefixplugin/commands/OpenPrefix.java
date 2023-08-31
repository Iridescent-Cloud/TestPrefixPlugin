package com.kimcodns.testprefixplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.kimcodns.testprefixplugin.GUI;

public class OpenPrefix implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            GUI gui = new GUI(player);
            gui.open(player);
        }
        return false;
    }
}
