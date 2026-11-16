package de.wintermagic;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

/** Client-only first functional milestone: recognizes named items in either hand. */
public final class WinterMagicClient implements ClientModInitializer {
    private static final Logger LOG = LoggerFactory.getLogger("wintermagic");
    private static final Map<String, String> DESIGNS = WinterMagicNames.all();
    private String lastName = "";

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(this::onTick);
        LOG.info("Winter Magic loaded with {} configured designs", DESIGNS.size());
    }

    private void onTick(Minecraft client) {
        if (client.player == null || client.level == null) {
            lastName = "";
            return;
        }
        ItemStack stack = client.player.getMainHandItem();
        if (stack.isEmpty()) stack = client.player.getOffhandItem();
        String name = stack.isEmpty() ? "" : stack.getHoverName().getString();
        String item = DESIGNS.get(name);
        String key = item == null ? "" : name;
        if (!key.equals(lastName)) {
            lastName = key;
            if (!key.isEmpty()) {
                client.player.displayClientMessage(Component.literal("Winter Magic: " + name + " erkannt"), true);
            }
        }
    }
}
