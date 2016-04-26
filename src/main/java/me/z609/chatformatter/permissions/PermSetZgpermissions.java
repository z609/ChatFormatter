package me.z609.chatformatter.permissions;

import me.zombieghostmc.perm.PermissionManager;
import org.bukkit.entity.Player;

/**
 * This code is by Z609, and is copyright (C) 2016 Z609. Don't share this
 * code with the public! Thanks!
 */
public class PermSetZgpermissions extends PermSet {
    @Override
    public String getPrefix(Player player) {
        try {
            return PermissionManager.getInstance().getPrefix(player.getName());
        } catch (Exception ignored) {
            return null;
        }
    }

    @Override
    public String getSuffix(Player player) {
        try {
            return PermissionManager.getInstance().getSuffix(player.getName());
        } catch (Exception ignored) {
            return null;
        }
    }
}
