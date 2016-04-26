package me.z609.chatformatter;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This code is by Z609, and is copyright (C) 2016 Z609. Don't share this
 * code with the public! Thanks!
 */
public class ChatFormatter extends JavaPlugin {

    @Override
    public void onEnable(){
        getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
        PluginManager pluginManager = getServer().getPluginManager();
        if(pluginManager.isPluginEnabled("EssentialsChat")){
            printWarning("EssentialsChat was found, any chat formatting you've made will be overriden.");
        }
        if(pluginManager.isPluginEnabled("HeroChat")){
            printWarning("HeroChat was found, there may be incompatibilities.");
        }
        pluginManager.registerEvents(new ChatFormatListener(this), this);
        printInfo("ChatFormatter was turned on!");
    }

    public void printWarning(String warning){
        Logger.getLogger("Minecraft").log(Level.WARNING, warning);
    }

    public void printInfo(String info){
        Logger.getLogger("Minecraft").log(Level.INFO, info);
    }

    public String getFormat(){
        return ChatColor.translateAlternateColorCodes('&', getConfig().getString("format"));
    }

}
