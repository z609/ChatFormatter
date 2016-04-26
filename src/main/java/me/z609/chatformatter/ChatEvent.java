package me.z609.chatformatter;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.Collection;
import java.util.List;

/**
 * This code is by Z609, and is copyright (C) 2016 Z609. Don't share this
 * code with the public! Thanks!
 */
public class ChatEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();

    private Player player;
    private String message;
    private String format;
    private Collection<? extends Player> recipients;
    private boolean cancelled = false;

    public ChatEvent(Player player, String message, String format) {
        this.player = player;
        this.message = message;
        this.format = format;
        this.recipients = Bukkit.getOnlinePlayers();
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Collection<? extends Player> getRecipients(){
        return recipients;
    }

    public void setRecipients(Collection<? extends Player> recipients) {
        this.recipients = recipients;
    }

    public void setRecipients(List<? extends Player> recipients){
        this.recipients = recipients;
    }

    public Player getPlayer() {
        return player;
    }

    public String getMessage() {
        return message;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void format(String lookFor, String replaceWith){
        lookFor = "{" + lookFor + "}";
        this.format = format.replace(lookFor, replaceWith);
    }

    public static HandlerList getHandlerList(){
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
