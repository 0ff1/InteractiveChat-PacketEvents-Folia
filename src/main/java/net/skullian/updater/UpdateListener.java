package net.skullian.updater;

import net.skullian.InteractiveChatPacketEvents;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerLoadEvent;

import static net.skullian.updater.Updater.checkUpdate;

public class UpdateListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!event.getPlayer().hasPermission("interactivechatpacketevents.checkupdate"))
            return;

        event.getPlayer().getScheduler().runDelayed(InteractiveChatPacketEvents.instance, task -> {
            checkUpdate(event.getPlayer());
        }, null, 100);
    }

    @EventHandler
    public void onStart(ServerLoadEvent event) {
        checkUpdate(Bukkit.getConsoleSender());
    }
}
