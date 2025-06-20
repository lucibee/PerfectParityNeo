package org.arcticquests.dev.util;


import net.minecraft.world.level.block.state.properties.BlockSetType;

public enum BlockSetTypeVariant {
    PALE_OAK("pale_oak");

    private final String name;
    private final BlockSetType blockSetType;

    BlockSetTypeVariant(String name) {
        this.name = name;
        this.blockSetType = BlockSetType.register(new BlockSetType(name));
    }

    public String getName() {
        return name;
    }

    public BlockSetType getBlockSetType() {
        return blockSetType;
    }
}