package gameoflife;

import fcast.simulation.GeneralBehaviour;
import fcast.universe.world.World;
import fcast.universe.world.cell.Coordinates;
import fcast.universe.world.cell.SimpleCell;
import fcast.universe2d.Coordinates2D;
import fcast.universe2d.World2D;

public class ConwaysGameOfLifeRule extends GeneralBehaviour<GOLCellType> {
	
	private static GOLStateList list = new GOLStateList();
	
    protected ConwaysGameOfLifeRule() {
    	super(new SimpleCell<GOLCellType>(list.get("dead")));
	}

 
    @Override
    public GOLCellType calculateNewValue(World<GOLCellType> world, Coordinates coordinates) {
        Coordinates2D gridCoordinates = (Coordinates2D)coordinates;
        World2D<GOLCellType> gridWorld = (GOLWorld) world;
        
        int sum = ((boolean) getUpperNeighbor(gridWorld, gridCoordinates).getValue().getValue() ? 1 : 0) + ((boolean) getLowerNeighbor(gridWorld, gridCoordinates).getValue().getValue() ? 1 : 0)
                + ((boolean) getLeftNeighbor(gridWorld, gridCoordinates).getValue().getValue() ? 1 : 0) + ((boolean) getRightNeighbor(gridWorld, gridCoordinates).getValue().getValue() ? 1 : 0)
                + ((boolean) getUpperLeftNeighbor(gridWorld, gridCoordinates).getValue().getValue() ? 1 : 0) + ((boolean) getUpperRightNeighbor(gridWorld, gridCoordinates).getValue().getValue() ? 1 : 0)
                + ((boolean) getLowerLeftNeighbor(gridWorld, gridCoordinates).getValue().getValue() ? 1 : 0) + ((boolean) getLowerRightNeighbor(gridWorld, gridCoordinates).getValue().getValue() ? 1 : 0);
        if ((boolean) world.getCell(coordinates).getValue().getValue()) {
        	boolean value = sum == 2 || sum == 3;
        	if (value) 
        		return list.get("alive");
    		else 
        		return list.get("dead");
        }
    	else {
        	boolean value = sum == 3;
        	if (value) 
        		return list.get("alive");
        	else 
        		return list.get("dead");
        }
    }
     
}