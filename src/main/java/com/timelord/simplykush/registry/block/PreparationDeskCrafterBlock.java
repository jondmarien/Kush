package com.timelord.simplykush.registry.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.*;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PreparationDeskCrafterBlock extends Block {
	private static final Text TITLE = new TranslatableText("container.preparation_desk_crafting");
	
	public PreparationDeskCrafterBlock (Settings settings) {
		super(settings);
	}
	
	@Override
	public ActionResult onUse (BlockState bs, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (world.isClient) {
			return ActionResult.SUCCESS;
		} else {
			player.openHandledScreen(bs.createScreenHandlerFactory(world, pos));
			player.incrementStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
			return ActionResult.CONSUME;
		}
	}
    
/*    public NamedScreenHandlerFactory creatreScreenHandlerFactory(BlockState bs, World world, BlockPos pos){
        return new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity) -> {
            return new PrepDeskCraftingScreenHandler(i, playerInventory, ScreenHandlerContext.create(world, pos));
        }, TITLE);
    }*/
}
