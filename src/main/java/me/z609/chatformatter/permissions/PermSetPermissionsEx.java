package me.z609.chatformatter.permissions;

import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

/**
 * This code is by Z609, and is copyright (C) 2016 Z609. Don't share this
 * code with the public! Thanks!
 */
public class PermSetPermissionsEx extends PermSet {
    @Override
    public String getPrefix(Player player) {
        return PermissionsEx.getUser(player).getPrefix();
    }

    @Override
    public String getSuffix(Player player) {
        return PermissionsEx.getUser(player).getSuffix();
    }
}
