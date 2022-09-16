package me.isaiah.common.event.block;

import me.isaiah.common.event.Event;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class LeavesDecayEvent extends Event {

    public BlockState state;
    public ServerWorld world;
    public BlockPos pos;

    public LeavesDecayEvent(BlockState state, ServerWorld world, BlockPos pos) {
        this.state = state;
        this.world = world;
        this.pos = pos;
    }


}