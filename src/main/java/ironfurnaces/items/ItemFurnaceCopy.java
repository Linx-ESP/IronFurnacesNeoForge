package ironfurnaces.items;

import ironfurnaces.init.Registration;
import ironfurnaces.tileentity.furnaces.BlockIronFurnaceTileBase;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

public class ItemFurnaceCopy extends Item {


    public ItemFurnaceCopy(Properties properties) {
        super(properties);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext pContext, List<Component> tooltip, TooltipFlag pTooltipFlag) {

        CustomData customData = stack.get(Registration.FURNACE_SETTINGS.get());
        if (customData != null)
        {
            CompoundTag tag = customData.copyTag();
            if (!tag.isEmpty())
            {
                int[] settings = tag.getIntArray("settings");
                tooltip.add(Component.literal("Down: " + settings[0]).setStyle(Style.EMPTY.applyFormat((ChatFormatting.GRAY))));
                tooltip.add(Component.literal("Up: " + settings[1]).setStyle(Style.EMPTY.applyFormat((ChatFormatting.GRAY))));
                tooltip.add(Component.literal("North: " + settings[2]).setStyle(Style.EMPTY.applyFormat((ChatFormatting.GRAY))));
                tooltip.add(Component.literal("South: " + settings[3]).setStyle(Style.EMPTY.applyFormat((ChatFormatting.GRAY))));
                tooltip.add(Component.literal("West: " + settings[4]).setStyle(Style.EMPTY.applyFormat((ChatFormatting.GRAY))));
                tooltip.add(Component.literal("East: " + settings[5]).setStyle(Style.EMPTY.applyFormat((ChatFormatting.GRAY))));
                tooltip.add(Component.literal("Auto Input: " + settings[6]).setStyle(Style.EMPTY.applyFormat((ChatFormatting.GRAY))));
                tooltip.add(Component.literal("Auto Output: " + settings[7]).setStyle(Style.EMPTY.applyFormat((ChatFormatting.GRAY))));
                tooltip.add(Component.literal("Redstone Mode: " + settings[8]).setStyle(Style.EMPTY.applyFormat((ChatFormatting.GRAY))));
                tooltip.add(Component.literal("Redstone Value: " + settings[9]).setStyle(Style.EMPTY.applyFormat((ChatFormatting.GRAY))));
            }
        }

        tooltip.add(Component.literal("Right-click to copy settings").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.literal("Sneak & right-click to apply settings").withStyle(ChatFormatting.GRAY));
    }


    @Override
    public InteractionResult useOn(UseOnContext ctx) {

        Level world = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        if (!ctx.getPlayer().isCrouching())
        {
            return super.useOn(ctx);
        }
        if (!world.isClientSide) {
            BlockEntity te = world.getBlockEntity(pos);

            if (!(te instanceof BlockIronFurnaceTileBase)) {
                return super.useOn(ctx);
            }

            ItemStack stack = ctx.getItemInHand();
            CustomData customData = stack.get(Registration.FURNACE_SETTINGS.get());
            if (customData != null) {
                CompoundTag tag = customData.copyTag();
                if (!tag.isEmpty()) {
                    int[] settings = tag.getIntArray("settings");
                    for (int i = 0; i < settings.length; i++) {
                        ((BlockIronFurnaceTileBase) te).furnaceSettings.set(i, settings[i]);
                    }

                }
            }
            world.markAndNotifyBlock(pos, world.getChunkAt(pos), world.getBlockState(pos).getBlock().defaultBlockState(), world.getBlockState(pos), 3, 3);
            ctx.getPlayer().sendSystemMessage(Component.literal("Settings applied"));
        }

        return super.useOn(ctx);
    }
}
