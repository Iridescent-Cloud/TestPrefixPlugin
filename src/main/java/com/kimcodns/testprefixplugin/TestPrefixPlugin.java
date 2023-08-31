package com.kimcodns.testprefixplugin;

import com.kimcodns.testprefixplugin.events.InventoryShiftClick;
import com.kimcodns.testprefixplugin.events.chatPrefix;
import org.bukkit.plugin.java.JavaPlugin;
import com.kimcodns.testprefixplugin.commands.OpenPrefix;
import com.kimcodns.testprefixplugin.commands.setManager;
import com.kimcodns.testprefixplugin.commands.deManager;
import com.kimcodns.testprefixplugin.commands.AddPrefix;
import com.kimcodns.testprefixplugin.events.InventoryClick;
import com.kimcodns.testprefixplugin.events.bookRightClick;
import com.kimcodns.testprefixplugin.commands.ManagePrefix;

public final class TestPrefixPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginCommand("칭호").setExecutor(new OpenPrefix());
        getServer().getPluginCommand("setManager").setExecutor(new setManager());
        getServer().getPluginCommand("deManager").setExecutor(new deManager());
        getServer().getPluginCommand("칭호북").setExecutor(new AddPrefix());
        getServer().getPluginCommand("칭호관리").setExecutor(new ManagePrefix());
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);
        getServer().getPluginManager().registerEvents(new bookRightClick(), this);
        getServer().getPluginManager().registerEvents(new InventoryShiftClick(), this);
        getServer().getPluginManager().registerEvents(new chatPrefix(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
