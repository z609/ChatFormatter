package me.z609.chatformatter.permissions;

import org.anjocaido.groupmanager.GroupManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * This code is by Z609, and is copyright (C) 2016 Z609. Don't share this
 * code with the public! Thanks!
 */
public class PermSetGroupManager extends PermSet {
    private GroupManager groupManager;

    public PermSetGroupManager(){
        groupManager = (GroupManager)Bukkit.getPluginManager().getPlugin("GroupManager");
    }

    @Override
    public String getPrefix(Player player) {
        return groupManager.getWorldsHolder().getWorldPermissions(player).getUserPrefix(player.getName());
    }

    @Override
    public String getSuffix(Player player) {
        return groupManager.getWorldsHolder().getWorldPermissions(player).getUserSuffix(player.getName());
    }
}
