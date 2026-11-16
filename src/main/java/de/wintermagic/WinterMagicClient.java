package de.wintermagic;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/** Client-side item-model selection for the 43 existing Winter Magic models. */
public final class WinterMagicClient implements ClientModInitializer {
    private static final Logger LOG = LoggerFactory.getLogger("wintermagic");
    private static final Map<String, String> DESIGNS = WinterMagicNames.all();

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(this::onTick);
        LOG.info("Winter Magic: {} name-to-model mappings loaded", DESIGNS.size());
    }

    private void onTick(Minecraft client) {
        if (client.player == null || client.level == null) return;
        // All player inventory slots, including equipped armor and offhand.
        for (int slot = 0; slot < client.player.getInventory().getContainerSize(); slot++) {
            updateModel(client.player.getInventory().getItem(slot));
        }
    }

    private void updateModel(ItemStack stack) {
        if (stack.isEmpty()) return;
        Identifier vanillaId = BuiltInRegistries.ITEM.getKey(stack.getItem());
        Identifier current = stack.get(DataComponents.ITEM_MODEL);
        String name = stack.getHoverName().getString();
        String expectedBase = DESIGNS.get(name);
        Identifier desired = null;
        if (expectedBase != null && expectedBase.equals(vanillaId.toString())) {
            desired = Identifier.fromNamespaceAndPath("wintermagic", modelId(name));
        }
        if (desired != null) {
            if (!desired.equals(current)) stack.set(DataComponents.ITEM_MODEL, desired);
        } else if (current != null && "wintermagic".equals(current.getNamespace())) {
            // A previously named item was renamed back: restore its vanilla model.
            stack.set(DataComponents.ITEM_MODEL, vanillaId);
        }
    }

    private static String modelId(String name) {
        return switch (name) {
            case "Christmas Tree" -> "christmas_tree";
            case "Christmas Tree Hat" -> "christmas_tree_hat";
            case "Mini Christmas Tree" -> "mini_christmas_tree";
            case "Christmas Present" -> "christmas_present";
            case "Red Present" -> "red_present";
            case "Blue Present" -> "blue_present";
            case "Green Present" -> "green_present";
            case "Snow Globe" -> "snow_globe";
            case "Christmas Wreath" -> "christmas_wreath";
            case "Gingerbread House" -> "gingerbread_house";
            case "Nutcracker" -> "nutcracker";
            case "Snowflake" -> "snowflake";
            case "Hot Chocolate" -> "hot_chocolate";
            case "Candy Cane" -> "candy_cane";
            case "Christmas Bauble" -> "christmas_bauble";
            case "Christmas Candle" -> "christmas_candle";
            case "Christmas Star" -> "christmas_star";
            case "Fireplace" -> "fireplace";
            case "Santa Stocking" -> "santa_stocking";
            case "Snowman" -> "snowman";
            case "North Pole Compass" -> "north_pole_compass";
            case "Christmas Clock" -> "christmas_clock";
            case "Letter to Santa" -> "letter_to_santa";
            case "Christmas Lantern" -> "christmas_lantern";
            case "Penguin" -> "penguin";
            case "Santa's Hat" -> "santa_hat";
            case "Reindeer Antlers" -> "reindeer_antlers";
            case "Ice Crown" -> "ice_crown";
            case "Snowman Head" -> "snowman_head";
            case "Aurora Crown" -> "aurora_crown";
            case "Santa Beard" -> "santa_beard";
            case "Winter Scarf" -> "winter_scarf";
            case "Santa's Bag" -> "santas_bag";
            case "Gingerbread" -> "gingerbread";
            case "Present" -> "present_armor";
            case "Frost Wings" -> "frost_wings";
            case "Elf Pants" -> "elf_pants";
            case "Candy Cane Pants" -> "candy_cane_pants";
            case "Santa Pants" -> "santa_pants";
            case "Elf Boots" -> "elf_boots";
            case "Ice Skates" -> "ice_skates";
            case "Snow Boots" -> "snow_boots";
            case "Penguin Feet" -> "penguin_feet";
            default -> "";
        };
    }
}
