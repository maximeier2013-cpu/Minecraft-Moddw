
package de.wintermagic;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public final class WinterMagicClient implements ClientModInitializer {
    private static final Logger LOG =
            LoggerFactory.getLogger("wintermagic");

    private static final Map<String, String> DESIGNS =
            WinterMagicNames.all();

    private String lastHandName = "";
    private String lastArmorName = "";

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(this::onTick);
        LOG.info("Winter Magic loaded with {} designs",
                DESIGNS.size());
    }

    private void onTick(Minecraft client) {
        if (client.player == null || client.level == null) {
            lastHandName = "";
            lastArmorName = "";
            return;
        }

        ItemStack hand = client.player.getMainHandItem();
        if (hand.isEmpty()) {
            hand = client.player.getOffhandItem();
        }

        String handName = recognizedName(hand);

        if (!handName.equals(lastHandName)) {
            lastHandName = handName;

            if (!handName.isEmpty()) {
                show(client, handName + " erkannt");
            }
        }

        ItemStack helmet = client.player.getItemBySlot(
                EquipmentSlot.HEAD);

        ItemStack chestplate = client.player.getItemBySlot(
                EquipmentSlot.CHEST);

        ItemStack leggings = client.player.getItemBySlot(
                EquipmentSlot.LEGS);

        ItemStack boots = client.player.getItemBySlot(
                EquipmentSlot.FEET);

        String armorName = "";

        if (helmet.is(Items.NETHERITE_HELMET)) {
            armorName = recognizedName(helmet);
        }

        if (armorName.isEmpty()
                && chestplate.is(Items.NETHERITE_CHESTPLATE)) {
            armorName = recognizedName(chestplate);
        }

        if (armorName.isEmpty()
                && leggings.is(Items.NETHERITE_LEGGINGS)) {
            armorName = recognizedName(leggings);
        }

        if (armorName.isEmpty()
                && boots.is(Items.NETHERITE_BOOTS)) {
            armorName = recognizedName(boots);
        }

        if (!armorName.equals(lastArmorName)) {
            lastArmorName = armorName;

            if (!armorName.isEmpty()) {
                show(client, armorName + " ausgerüstet");
            }
        }
    }

    private String recognizedName(ItemStack stack) {
        if (stack.isEmpty()) {
            return "";
        }

        String name = stack.getHoverName().getString();

        return DESIGNS.containsKey(name) ? name : "";
    }

    private void show(Minecraft client, String message) {
        client.player.displayClientMessage(
                Component.literal("Winter Magic: " + message),
                true
        );
    }
}
