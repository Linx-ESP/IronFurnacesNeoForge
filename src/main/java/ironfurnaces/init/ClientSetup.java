package ironfurnaces.init;

import ironfurnaces.gui.BlockWirelessEnergyHeaterScreen;
import ironfurnaces.gui.furnaces.*;
import ironfurnaces.gui.furnaces.other.BlockAllthemodiumFurnaceScreen;
import ironfurnaces.gui.furnaces.other.BlockUnobtainiumFurnaceScreen;
import ironfurnaces.gui.furnaces.other.BlockVibraniumFurnaceScreen;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

public class ClientSetup {

    public static void init(final RegisterMenuScreensEvent event) {
            event.register(Registration.IRON_FURNACE_CONTAINER.get(), BlockIronFurnaceScreen::new);
            event.register(Registration.GOLD_FURNACE_CONTAINER.get(), BlockGoldFurnaceScreen::new);
            event.register(Registration.DIAMOND_FURNACE_CONTAINER.get(), BlockDiamondFurnaceScreen::new);
            event.register(Registration.EMERALD_FURNACE_CONTAINER.get(), BlockEmeraldFurnaceScreen::new);
            event.register(Registration.OBSIDIAN_FURNACE_CONTAINER.get(), BlockObsidianFurnaceScreen::new);
            event.register(Registration.CRYSTAL_FURNACE_CONTAINER.get(), BlockCrystalFurnaceScreen::new);
            event.register(Registration.NETHERITE_FURNACE_CONTAINER.get(), BlockNetheriteFurnaceScreen::new);
            event.register(Registration.COPPER_FURNACE_CONTAINER.get(), BlockCopperFurnaceScreen::new);
            event.register(Registration.SILVER_FURNACE_CONTAINER.get(), BlockSilverFurnaceScreen::new);
            event.register(Registration.MILLION_FURNACE_CONTAINER.get(), BlockMillionFurnaceScreen::new);
            event.register(Registration.HEATER_CONTAINER.get(), BlockWirelessEnergyHeaterScreen::new);


            event.register(Registration.ALLTHEMODIUM_FURNACE_CONTAINER.get(), BlockAllthemodiumFurnaceScreen::new);
            event.register(Registration.VIBRANIUM_FURNACE_CONTAINER.get(), BlockVibraniumFurnaceScreen::new);
            event.register(Registration.UNOBTAINIUM_FURNACE_CONTAINER.get(), BlockUnobtainiumFurnaceScreen::new);




    }

}