package ironfurnaces.gui.furnaces.other;

import ironfurnaces.container.furnaces.other.BlockAllthemodiumFurnaceContainer;
import ironfurnaces.gui.furnaces.BlockIronFurnaceScreenBase;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;


public class BlockAllthemodiumFurnaceScreen extends BlockIronFurnaceScreenBase<BlockAllthemodiumFurnaceContainer> {


    public BlockAllthemodiumFurnaceScreen(BlockAllthemodiumFurnaceContainer container, Inventory inv, Component name) {
        super(container, inv, name);
        GUI = GUI_ATM;
    }

}
