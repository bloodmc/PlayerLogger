package me.bloodmc.playerlogger.listener;

import me.bloodmc.playerlogger.EventLogManager;
import me.bloodmc.playerlogger.PlayerLoggerPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockEventListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockIgnite(BlockIgniteEvent event) {
        if (PlayerLoggerPlugin.getGlobalConfig().getConfig().events.BLOCK_IGNITE_EVENT) {
            EventLogManager.logEvent(event.getPlayer(), event, 
                    "Source: [" + event.getIgnitingBlock() != null ? event.getIgnitingBlock().toString() : event.getIgnitingEntity().getName() + "], "
                  + "Target: [" + event.getBlock() + "], "
                  + "Item: [" + event.getPlayer().getInventory().getItemInMainHand() + "]");
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event) {
        if (PlayerLoggerPlugin.getGlobalConfig().getConfig().events.BLOCK_BREAK_EVENT) {
            EventLogManager.logEvent(event.getPlayer(), event, 
                    "Source: [" + event.getPlayer().getName() + "], "
                  + "Target: [" + event.getBlock() + "], "
                  + "Item: [" + event.getPlayer().getInventory().getItemInMainHand() + "], "
                  + "ExpToDrop: [" + event.getExpToDrop() + "]");
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockPlace(BlockPlaceEvent event) {
        if (PlayerLoggerPlugin.getGlobalConfig().getConfig().events.BLOCK_PLACE_EVENT) {
            EventLogManager.logEvent(event.getPlayer(), event, 
                    "Source: [" + event.getPlayer().getName() + "], "
                  + "Target: [" + event.getBlock() + "], "
                  + "Item: [" + event.getPlayer().getInventory().getItemInMainHand() + "], "
                  + "PlacedAgainst: [" + event.getBlockAgainst() + "]");
        }
    }
}
