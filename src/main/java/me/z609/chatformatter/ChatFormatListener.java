package me.z609.chatformatter;

import me.z609.chatformatter.permissions.PermSet;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * This code is by Z609, and is copyright (C) 2016 Z609. Don't share this
 * code with the public! Thanks!
 */
public class ChatFormatListener implements Listener {

    private ChatFormatter parent;

    public ChatFormatListener(ChatFormatter parent) {
        this.parent = parent;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onChat(AsyncPlayerChatEvent event){
        if(event.isCancelled()){
            return;
        }
        event.setCancelled(true);
        Player player = event.getPlayer();
        String message = event.getMessage();
        ChatEvent chat = new ChatEvent(player, message, parent.getFormat());
        chat.format("Name", player.getName());
        chat.format("DisplayName", player.getDisplayName());
        chat.format("Message", message);
        PermSet permSet = PermSet.determinePermSet();
        if(permSet != null){
            String prefix = ChatColor.translateAlternateColorCodes('&', permSet.getPrefix(player));
            if(prefix != null){
                chat.format("Prefix", prefix);
            }
            String suffix = ChatColor.translateAlternateColorCodes('&', permSet.getSuffix(player));
            if(suffix != null){
                chat.format("Suffix", suffix);
            }
        }
        else{
            chat.format("Prefix", "");
            chat.format("Suffix", "");
        }
        Bukkit.getPluginManager().callEvent(chat);
        if(chat.isCancelled()){
            return;
        }
        String format = chat.getFormat();
        Bukkit.getConsoleSender().sendMessage(format);
        for(Player recipient : chat.getRecipients()){
            recipient.sendMessage(format);
        }
    }

}
