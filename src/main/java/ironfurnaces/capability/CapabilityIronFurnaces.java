package ironfurnaces.capability;

import ironfurnaces.init.Registration;
import ironfurnaces.tileentity.furnaces.BlockIronFurnaceTileBase;
import net.minecraft.world.Container;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;

import java.util.Iterator;
import java.util.List;

public class CapabilityIronFurnaces {

    //public static final EntityCapability<IPlayerFurnacesList, Void> FURNACES_LIST = EntityCapability.createVoid(ResourceLocation.fromNamespaceAndPath(IronFurnaces.MOD_ID, "furnace_list"), IPlayerFurnacesList.class);


    public static void register(RegisterCapabilitiesEvent event)
    {

        List furnaces = List.of(
                Registration.COPPER_FURNACE.get(),
                Registration.CRYSTAL_FURNACE.get(),
                Registration.DIAMOND_FURNACE.get(),
                Registration.EMERALD_FURNACE.get(),
                Registration.GOLD_FURNACE.get(),
                Registration.IRON_FURNACE.get(),
                Registration.MILLION_FURNACE.get(),
                Registration.NETHERITE_FURNACE.get(),
                Registration.OBSIDIAN_FURNACE.get(),
                Registration.SILVER_FURNACE.get(),
                Registration.ALLTHEMODIUM_FURNACE.get(),
                Registration.VIBRANIUM_FURNACE.get(),
                Registration.UNOBTAINIUM_FURNACE.get()
        );


        event.registerBlock(Capabilities.ItemHandler.BLOCK,
                (level, pos, state, be, side) -> (side == null ? new InvWrapper((Container) be) : new SidedInvWrapper((WorldlyContainer)be, side)),
                // blocks to register for
                Registration.HEATER.get());

        event.registerBlock(Capabilities.EnergyStorage.BLOCK,
                (level, pos, state, be, side) -> ((BlockIronFurnaceTileBase) be).energyStorage,
                // blocks to register for
                Registration.HEATER.get());



        Iterator var3 = furnaces.iterator();

        while(var3.hasNext()) {
            event.registerBlock(Capabilities.ItemHandler.BLOCK,
                    (level, pos, state, be, side) -> (side == null ? new InvWrapper((Container) be) : new SidedInvWrapper((WorldlyContainer)be, side)),
                    // blocks to register for
                    (Block) var3.next()
            );
            event.registerBlock(Capabilities.EnergyStorage.BLOCK,
                    (level, pos, state, be, side) -> ((BlockIronFurnaceTileBase) be).energyStorage,
                    // blocks to register for
                    (Block) var3.next()
            );
        }

    }

}
