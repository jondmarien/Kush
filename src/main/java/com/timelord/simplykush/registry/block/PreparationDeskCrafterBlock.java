package com.timelord.simplykush.registry.block;

import com.timelord.simplykush.registry.ModStats;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PreparationDeskCrafterBlock extends Block {
	private static final Text TITLE = new TranslatableText("block.simplykush.container.preparation_desk_crafting");
	
	public PreparationDeskCrafterBlock (Settings settings) {
		super(settings);
	}
	
	@Override
	public ActionResult onUse (BlockState bs, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (world.isClient) {
			return ActionResult.SUCCESS;
		} else {
			player.openHandledScreen(bs.createScreenHandlerFactory(world, pos));
			player.incrementStat(ModStats.INTERACT_WITH_PREPARATION_DESK);
			return ActionResult.CONSUME;
		}
	}
	
	public boolean activate (BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult result) {
		return true;
	}
    
/*    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState bs, World world, BlockPos pos){
        return new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity) -> {
            return new PrepDeskCraftingScreenHandler(i, playerInventory, ScreenHandlerContext.create(world, pos));
        }, TITLE);
    }*/
}
