package me.bloodmc.playerlogger.listener;

import me.bloodmc.playerlogger.EventLogManager;
import me.bloodmc.playerlogger.PlayerLoggerPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerEventListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (PlayerLoggerPlugin.getGlobalConfig().getConfig().events.PLAYER_JOIN_EVENT) {
            EventLogManager.logEvent(event.getPlayer(), event, 
                    "Source: [" + event.getPlayer().getName() + "], "
                  + "Target: [" + event.getPlayer().getName() + "], "
                  + "Item: [" + event.getPlayer().getInventory().getItemInMainHand() + "], "
                  + "JoinMessage: [" + event.getJoinMessage() + "]");
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerQuit(PlayerQuitEvent event) {
        if (PlayerLoggerPlugin.getGlobalConfig().getConfig().events.PLAYER_QUIT_EVENT) {
            EventLogManager.logEvent(event.getPlayer(), event, 
                    "Source: [" + event.getPlayer().getName() + "], "
                  + "Target: [" + event.getPlayer().getName() + "], "
                  + "Item: [" + event.getPlayer().getInventory().getItemInMainHand() + "], "
                  + "QuitMessage: [" + event.getQuitMessage() + "]");
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerChangeHeldItem(PlayerItemHeldEvent event) {
        if (PlayerLoggerPlugin.getGlobalConfig().getConfig().events.PLAYER_ITEM_HELD_EVENT) {
            EventLogManager.logEvent(event.getPlayer(), event, 
                    "Source: [" + event.getPreviousSlot() + "(" + event.getPlayer().getInventory().getItem(event.getPreviousSlot()) + ")], "
                  + "Target: [" + event.getNewSlot() + "(" + event.getPlayer().getInventory().getItem(event.getNewSlot()) + ")], "
                  + "Item: [" + event.getPlayer().getInventory().getItemInMainHand() + "]");
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        if (PlayerLoggerPlugin.getGlobalConfig().getConfig().events.PLAYER_DROP_ITEM_EVENT) {
            EventLogManager.logEvent(event.getPlayer(), event, 
                    "Source: [" + event.getPlayer().getName() + "], "
                  + "Target: [" + event.getItemDrop() + "], "
                  + "Item: [" + event.getPlayer().getInventory().getItemInMainHand() + "]");
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerInteractInventoryOpen(InventoryOpenEvent event) {
        if (PlayerLoggerPlugin.getGlobalConfig().getConfig().events.PLAYER_INVENTORY_OPEN_EVENT) {
            EventLogManager.logEvent(event.getPlayer().getUniqueId(), event, 
                    "Source: [" + event.getPlayer().getName() + "], "
                  + "Target: [" + event.getInventory() + "], "
                  + "Item: [" + event.getPlayer().getInventory().getItemInMainHand() + "]");
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (PlayerLoggerPlugin.getGlobalConfig().getConfig().events.PLAYER_INTERACT_EVENT) {
            EventLogManager.logEvent(event.getPlayer(), event, 
                    "Source: [" + event.getPlayer().getName() + "], "
                  + "Target: [" + event.getClickedBlock() + "], "
                  + "Item: [" + event.getItem() + "], "
                  + "Action: [" + event.getAction() + "], "
                  + "BlockFace: [" + event.getBlockFace() + "]");
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        if (PlayerLoggerPlugin.getGlobalConfig().getConfig().events.PLAYER_TELEPORT_EVENT) {
            EventLogManager.logEvent(event.getPlayer(), event, 
                    "Source: [" + event.getFrom() + "], "
                  + "Target: [" + event.getTo()+ "], "
                  + "Item: [" + event.getPlayer().getInventory().getItemInMainHand() + "], "
                  + "Cause: [" + event.getCause() + "]");
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerMove(PlayerMoveEvent event) {
        if (PlayerLoggerPlugin.getGlobalConfig().getConfig().events.PLAYER_MOVE_EVENT) {
            EventLogManager.logEvent(event.getPlayer(), event, 
                    "Source: [" + event.getFrom() + "], "
                  + "Target: [" + event.getTo()+ "], "
                  + "Item: [" + event.getPlayer().getInventory().getItemInMainHand() + "]");
        }
    }
}
