package de.wintermagic;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/** Exact anvil names and their expected base item IDs. */
public final class WinterMagicNames {
    private WinterMagicNames() {}
    public static Map<String, String> all() {
        Map<String, String> result = new LinkedHashMap<>();
        result.put("Christmas Tree", "minecraft:dead_bush");
        result.put("Mini Christmas Tree", "minecraft:dead_bush");
        result.put("Christmas Present", "minecraft:pumpkin");
        result.put("Red Present", "minecraft:red_dye");
        result.put("Blue Present", "minecraft:blue_dye");
        result.put("Green Present", "minecraft:green_dye");
        result.put("Snow Globe", "minecraft:glass_bottle");
        result.put("Christmas Wreath", "minecraft:vine");
        result.put("Gingerbread House", "minecraft:brick");
        result.put("Nutcracker", "minecraft:stick");
        result.put("Snowflake", "minecraft:feather");
        result.put("Hot Chocolate", "minecraft:bowl");
        result.put("Candy Cane", "minecraft:kelp");
        result.put("Christmas Bauble", "minecraft:spider_eye");
        result.put("Christmas Candle", "minecraft:red_candle");
        result.put("Christmas Star", "minecraft:pumpkin_seeds");
        result.put("Fireplace", "minecraft:brick");
        result.put("Santa Stocking", "minecraft:rabbit_hide");
        result.put("Snowman", "minecraft:carved_pumpkin");
        result.put("North Pole Compass", "minecraft:compass");
        result.put("Christmas Clock", "minecraft:clock");
        result.put("Letter to Santa", "minecraft:paper");
        result.put("Christmas Lantern", "minecraft:lantern");
        result.put("Penguin", "minecraft:nautilus_shell");
        result.put("Santa's Hat", "minecraft:netherite_helmet");
        result.put("Reindeer Antlers", "minecraft:netherite_helmet");
        result.put("Ice Crown", "minecraft:netherite_helmet");
        result.put("Snowman Head", "minecraft:netherite_helmet");
        result.put("Aurora Crown", "minecraft:netherite_helmet");
        result.put("Santa Beard", "minecraft:netherite_helmet");
        result.put("Christmas Tree Hat", "minecraft:netherite_helmet");
        result.put("Winter Scarf", "minecraft:netherite_chestplate");
        result.put("Santa's Bag", "minecraft:netherite_chestplate");
        result.put("Gingerbread", "minecraft:netherite_chestplate");
        result.put("Present", "minecraft:netherite_chestplate");
        result.put("Frost Wings", "minecraft:netherite_chestplate");
        result.put("Elf Pants", "minecraft:netherite_leggings");
        result.put("Candy Cane Pants", "minecraft:netherite_leggings");
        result.put("Santa Pants", "minecraft:netherite_leggings");
        result.put("Elf Boots", "minecraft:netherite_boots");
        result.put("Ice Skates", "minecraft:netherite_boots");
        result.put("Snow Boots", "minecraft:netherite_boots");
        result.put("Penguin Feet", "minecraft:netherite_boots");
        return Collections.unmodifiableMap(result);
    }
}
