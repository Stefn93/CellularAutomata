package framework.gui;

import framework.universe.world.World;

public interface WorldGui<T> {
    public void showWorld(World<T> world);
    
}