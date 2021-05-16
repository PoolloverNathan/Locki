/*
 * Locki
 * Copyright (C) 2021 Ladysnake
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; If not, see <https://www.gnu.org/licenses>.
 */
package io.github.ladysnake.locki;

import net.minecraft.entity.player.PlayerInventory;

public final class DefaultInventoryNodes {
    /**
     * Controls access to the entirety of a player's inventory
     */
    public static final InventoryNode INVENTORY = Locki.registerNode(InventoryNode.ROOT, "inventory");
    /**
     * Controls access to {@link PlayerInventory#main}
     */
    public static final InventoryNode MAIN_INVENTORY = Locki.registerNode(INVENTORY, "main");

    public static final InventoryNode HANDS          = Locki.registerNode(INVENTORY, "hands");
    public static final InventoryNode MAIN_HAND      = Locki.registerNode(HANDS, "main_hand");
    public static final InventoryNode OFF_HAND       = Locki.registerNode(HANDS, "off_hand");

    public static final InventoryNode ARMOR          = Locki.registerNode(INVENTORY, "armor");

    public static final InventoryNode CRAFTING_GRID  = Locki.registerNode(INVENTORY, "crafting_grid");

    static void init() {
        // NO-OP
    }
}
