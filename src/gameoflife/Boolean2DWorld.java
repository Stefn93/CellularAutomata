package gameoflife;

import framework.simulation.Behaviour;
import framework.worldmodel.Cell;
import framework.worldmodel.SimpleCell;
import framework.worldmodel.World2D;

public class Boolean2DWorld extends World2D<Boolean> {
    public Boolean2DWorld(int height, int length, Behaviour<Boolean> rule) {
        super(height, length, rule);
    }
 
    @Override
    protected Cell<Boolean> createNewCell() {
        return new SimpleCell<Boolean>(false);
    }

}