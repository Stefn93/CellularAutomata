package framework.gui;

import framework.worldmodel.World;

public interface WorldGui<T> {
    public void showWorld(World<T> world);
}