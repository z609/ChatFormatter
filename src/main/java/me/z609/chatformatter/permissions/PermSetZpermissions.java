package me.z609.chatformatter.permissions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.tyrannyofheaven.bukkit.zPermissions.ZPermissionsService;

/**
 * This code is by Z609, and is copyright (C) 2016 Z609. Don't share this
 * code with the public! Thanks!
 */
public class PermSetZpermissions extends PermSet {
    private ZPermissionsService zPermissions = null;

    public PermSetZpermissions(){
        zPermissions = Bukkit.getServicesManager().load(ZPermissionsService.class);
    }

    @Override
    public String getPrefix(Player player){
        return zPermissions.getPlayerPrefix(player.getUniqueId());
    }

    @Override
    public String getSuffix(Player player) {
        return zPermissions.getPlayerSuffix(player.getUniqueId());
    }
}
