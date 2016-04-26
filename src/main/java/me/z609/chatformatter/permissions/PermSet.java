package me.z609.chatformatter.permissions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

/**
 * This code is by Z609, and is copyright (C) 2016 Z609. Don't share this
 * code with the public! Thanks!
 */
public abstract class PermSet {

    public abstract String getPrefix(Player player);

    public abstract String getSuffix(Player player);

    public static PermSet determinePermSet(){
        PluginManager pluginManager = Bukkit.getServer().getPluginManager();
        if(pluginManager.isPluginEnabled("PermissionsEx")){
            return new PermSetPermissionsEx();
        }
        else if(pluginManager.isPluginEnabled("zPermissions")){
            return new PermSetZpermissions();
        }
        else if(pluginManager.isPluginEnabled("GroupManager")){
            return new PermSetGroupManager();
        }
        else if(pluginManager.isPluginEnabled("ZGPermissions")){
            return new PermSetZpermissions();
        }
        return null;
    }

}
