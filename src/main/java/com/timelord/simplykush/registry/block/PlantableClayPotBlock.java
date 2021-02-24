package com.timelord.simplykush.registry.block;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;
import java.util.function.Consumer;

public class PlantableClayPotBlock extends FlowerPotBlock implements Fertilizable {

    public static final IntProperty AGE = Properties.AGE_3;

    public PlantableClayPotBlock(Block content, Settings settings) {
        super(content, settings);
        setDefaultState(getStateManager().getDefaultState().with(AGE, 0));
    }

    public BlockState withAge(int age) {
        return this.getDefaultState().with(AGE, age);
    }

    public int getMaxAge() {
        return 3;
    }

    protected int getAge(BlockState bs) {
        return bs.get(AGE);
    }

    public boolean isMature(BlockState bs) {
        return bs.get(AGE) >= this.getMaxAge();
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public ActionResult onUse(BlockState bs, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        if (this.getContent() == Blocks.AIR) {
            return super.onUse(bs, world, pos, player, hand, hit);
        } else if (!this.isMature(bs)) {
            if (player.getMainHandStack().getItem() == Items.BONE_MEAL) {
                BoneMealItem bmi = (BoneMealItem) player.getMainHandStack().getItem();
                bmi.useOnBlock(new ItemUsageContext(player, hand, hit));
            }
        } else if (this.isMature(bs)) {
            if (player.getMainHandStack().getItem() == Items.SHEARS) {
                if (!player.giveItemStack(new ItemStack(this.getContent()))) {
                    player.dropItem(new ItemStack(this.getContent()), false);
                }
                world.setBlockState(pos, this.withAge(0), 2);
                player.getMainHandStack()
                        .damage(1, player, (Consumer<LivingEntity>)
                                ((p) -> {
                                    p.sendToolBreakStatus(hand);
                                }));
            }
            return ActionResult.success(world.isClient);
        }
        return ActionResult.CONSUME;
    }

    @Override
    public void randomTick(BlockState bs, ServerWorld world, BlockPos pos, Random rand) {
        if (world.getBaseLightLevel(pos, 0) >= 9) {
            int currAge = this.getAge(bs);
            if (currAge < this.getMaxAge()) {

                if (rand.nextInt((int) (10.0F) + 1) == 0) {

                    world.setBlockState(pos, this.withAge(currAge + 1), 2);
                }
            }
        }
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState bs, boolean isClient) {
        return !this.isMature(bs);
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState bs) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState bs) {
        world.setBlockState(pos, this.withAge(this.getAge(bs) + 1), 2);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public boolean isTranslucent(BlockState bs, BlockView world, BlockPos pos) {
        return bs.getFluidState().isEmpty();
    }
}
