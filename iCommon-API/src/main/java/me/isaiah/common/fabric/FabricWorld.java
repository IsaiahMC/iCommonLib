package me.isaiah.common.fabric;

import me.isaiah.common.block.IBlockState;
import me.isaiah.common.cmixin.IMixinBlockState;
import me.isaiah.common.cmixin.IMixinWorld;
import me.isaiah.common.world.IWorld;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class FabricWorld implements IWorld {

	public World mc; // Backwards Compact
    public ServerWorld mc1;
    private String name;

    @Deprecated
    public FabricWorld(String name, World world) {
        this.mc = (ServerWorld) world;
        this.mc1 = (ServerWorld) world;
        this.name = name;
    }
    
    public FabricWorld(String name, ServerWorld world) {
        this.mc = world;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    private GameRules gr() {
        return mc1.getGameRules();
    }

    @Override
    public boolean doDaylightCycle() {
        return gr().get(GameRules.DO_DAYLIGHT_CYCLE).get();
    }

    @Override
    public boolean isDay() {
        return mc.isDay();
    }

    @Override
    public int getLoadedChunkCount() {
        return ((ServerWorld)mc).getChunkManager().getLoadedChunkCount();
    }

    @Override
    public IBlockState getBlockState(int x, int y, int z) {
        BlockPos pos = new BlockPos(x,y,z);
        return ((IMixinBlockState)mc.getBlockState(pos)).getAsICommon(this, pos);
    }

	@Override
	public boolean isTheEnd(ServerWorld world) {
		return ((IMixinWorld) mc1).icommon$is_the_end();
	}

	@Override
	public BlockPos getSpawnPoint() {
		return ((IMixinWorld) mc1).icommon$get_spawn_point();
	}

}