package com.vbswap;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.SlotActionType;

public class VBSwapMod implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        // Register chat message listener
        ClientSendMessageEvents.ALLOW_CHAT.register((message) -> {
            if (message.equals(".vb-swap")) {
                swapMainhandOffhand();
                return false; // Prevent the message from being sent to server
            }
            return true; // Allow other messages
        });
    }
    
    private void swapMainhandOffhand() {
        MinecraftClient client = MinecraftClient.getInstance();
        
        if (client.player == null || client.interactionManager == null) {
            return;
        }
        
        PlayerInventory inventory = client.player.getInventory();
        int selectedSlot = inventory.selectedSlot;
        
        // Get the items
        ItemStack mainhandItem = inventory.getStack(selectedSlot);
        ItemStack offhandItem = inventory.offHand.get(0);
        
        // Swap them
        inventory.setStack(selectedSlot, offhandItem.copy());
        inventory.offHand.set(0, mainhandItem.copy());
        
        // Notify server of the swap using click slot packet
        // This ensures the server knows about the swap
        if (client.player.currentScreenHandler != null) {
            int syncId = client.player.currentScreenHandler.syncId;
            
            // Swap with offhand (button 40, action SWAP)
            client.interactionManager.clickSlot(
                syncId,
                selectedSlot,
                40,
                SlotActionType.SWAP,
                client.player
            );
        } else {
            // If no screen is open, use the player's inventory
            client.interactionManager.clickSlot(
                client.player.playerScreenHandler.syncId,
                36 + selectedSlot, // Convert hotbar slot to full inventory slot
                40,
                SlotActionType.SWAP,
                client.player
            );
        }
    }
}
