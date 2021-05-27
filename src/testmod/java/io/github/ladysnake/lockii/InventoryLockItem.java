package io.github.ladysnake.lockii;

import io.github.ladysnake.locki.InventoryLock;
import io.github.ladysnake.locki.InventoryNode;
import io.github.ladysnake.locki.Locki;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class InventoryLockItem extends Item {
    public static final InventoryLock LOCK = Locki.registerLock(Lockii.id("test_item"));
    private static final InventoryNode[] ALL_DEFAULT_NODES = Locki.streamNodeNames().map(Locki::getNode).toArray(InventoryNode[]::new);

    public InventoryLockItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack heldStack = user.getStackInHand(hand);

        if (!world.isClient) {
            NbtCompound data = heldStack.getOrCreateSubTag("lockii");
            int currentDebug = data.getInt("debug");

            if (user.isSneaking()) {
                int newDebug = (currentDebug + 1) % ALL_DEFAULT_NODES.length;
                data.putInt("debug", newDebug);
                user.sendMessage(new LiteralText("Now managing locking for " + ALL_DEFAULT_NODES[newDebug]), true);
            } else {
                LOCK.toggle(user, ALL_DEFAULT_NODES[currentDebug]);
            }
        }
        return TypedActionResult.success(heldStack);
    }
}
