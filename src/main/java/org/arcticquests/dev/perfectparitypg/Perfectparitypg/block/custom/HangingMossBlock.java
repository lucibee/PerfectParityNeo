package org.arcticquests.dev.perfectparitypg.Perfectparitypg.block.custom;


import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.block.ModBlocks;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.datagen.ModBlockTagProvider;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.sounds.ModSounds;

public class HangingMossBlock extends Block implements BonemealableBlock {
    public static final BooleanProperty TIP;
    public static final MapCodec<HangingMossBlock> CODEC = simpleCodec(HangingMossBlock::new);
    private static final int SIDE_PADDING = 1;
    private static final VoxelShape TIP_SHAPE = Block.box((double) 1.0F, (double) 2.0F, (double) 1.0F, (double) 15.0F, (double) 16.0F, (double) 15.0F);
    private static final VoxelShape BASE_SHAPE = Block.box((double) 1.0F, (double) 0.0F, (double) 1.0F, (double) 15.0F, (double) 16.0F, (double) 15.0F);

    static {
        TIP = BooleanProperty.create("tip");
    }

    public HangingMossBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState) ((BlockState) this.stateDefinition.any()).setValue(TIP, true));
    }

    public MapCodec<HangingMossBlock> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return (Boolean) blockState.getValue(TIP) ? TIP_SHAPE : BASE_SHAPE;
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if (randomSource.nextInt(500) == 0) {
            BlockState blockState2 = level.getBlockState(blockPos.above());
            if (blockState2.is(ModBlockTagProvider.PALE_OAK_LOGS) || blockState2.is(ModBlocks.PALE_OAK_LEAVES)) {
                level.playLocalSound((double) blockPos.getX(), (double) blockPos.getY(), (double) blockPos.getZ(), ModSounds.PALE_HANGING_MOSS_IDLE.get(), SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }
        }

    }

    @Override
    protected boolean propagatesSkylightDown(BlockState p_320652_, BlockGetter p_320953_, BlockPos p_320082_) {
        return true;
    }

    @Override
    protected boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return this.canStayAtPosition(levelReader, blockPos);
    }

    private boolean canStayAtPosition(BlockGetter blockGetter, BlockPos blockPos) {
        BlockPos blockPos2 = blockPos.relative(Direction.UP);
        BlockState blockState = blockGetter.getBlockState(blockPos2);
        return MultifaceBlock.canAttachTo(blockGetter, Direction.UP, blockPos2, blockState) || blockState.is(ModBlocks.PALE_HANGING_MOSS);
    }

    @Override
    protected BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if (!this.canStayAtPosition(levelAccessor, blockPos)) {
            levelAccessor.scheduleTick(blockPos, this, 1);
        }

        return (BlockState) blockState.setValue(TIP, !levelAccessor.getBlockState(blockPos.below()).is(this));
    }

    @Override
    protected void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (!this.canStayAtPosition(serverLevel, blockPos)) {
            serverLevel.destroyBlock(blockPos, true);
        }

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{TIP});
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return this.canGrowInto(levelReader.getBlockState(this.getTip(levelReader, blockPos).below()));
    }

    private boolean canGrowInto(BlockState blockState) {
        return blockState.isAir();
    }

    public BlockPos getTip(BlockGetter blockGetter, BlockPos blockPos) {
        BlockPos.MutableBlockPos mutableBlockPos = blockPos.mutable();

        BlockState blockState;
        do {
            mutableBlockPos.move(Direction.DOWN);
            blockState = blockGetter.getBlockState(mutableBlockPos);
        } while (blockState.is(this));

        return mutableBlockPos.relative(Direction.UP).immutable();
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        BlockPos blockPos2 = this.getTip(serverLevel, blockPos).below();
        if (this.canGrowInto(serverLevel.getBlockState(blockPos2))) {
            serverLevel.setBlockAndUpdate(blockPos2, (BlockState) blockState.setValue(TIP, true));
        }
    }
}