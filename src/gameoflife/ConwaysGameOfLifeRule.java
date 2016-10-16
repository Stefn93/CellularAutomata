package gameoflife;

import framework.simulation.Behaviour;
import framework.universe.cell.Cell;
import framework.universe.cell.CellType;
import framework.universe.cell.Coordinates;
import framework.universe.cell.SimpleCell;
import framework.universe.world.World;
import framework.universe2d.Coordinates2D;
import framework.universe2d.World2D;

public class ConwaysGameOfLifeRule implements Behaviour<GOLCellType> {
    private static GOLStateList list = new GOLStateList();
    private static Cell<GOLCellType> EMPTY_CELL = new SimpleCell<GOLCellType>(list.get("Dead"));
 
    @Override
    public GOLCellType calculateNewValue(World<GOLCellType> world, Coordinates coordinates) {
        Coordinates2D gridCoordinates = (Coordinates2D)coordinates;
        World2D<GOLCellType> gridWorld = (GOLWorld) world;
        int sum = ((boolean) getUpperNeighbor(gridWorld, gridCoordinates).getValue().getValue() ? 1 : 0) + ((boolean) getLowerNeighbor(gridWorld, gridCoordinates).getValue().getValue() ? 1 : 0)
                + ((boolean) getLeftNeighbor(gridWorld, gridCoordinates).getValue().getValue() ? 1 : 0) + ((boolean) getRightNeighbor(gridWorld, gridCoordinates).getValue().getValue() ? 1 : 0)
                + ((boolean) getUpperLeftNeighbor(gridWorld, gridCoordinates).getValue().getValue() ? 1 : 0) + ((boolean) getUpperRightNeighbor(gridWorld, gridCoordinates).getValue().getValue() ? 1 : 0)
                + ((boolean) getLowerLeftNeigbhor(gridWorld, gridCoordinates).getValue().getValue() ? 1 : 0) + ((boolean) getLowerRightNeigbhor(gridWorld, gridCoordinates).getValue().getValue() ? 1 : 0);
        if ((boolean) world.getCell(coordinates).getValue().getValue()) {
        	boolean value = sum == 2 || sum == 3;
        	if (value) {
        		return list.get("Alive");
        		//return new GOLCellType("Alive", value);
        	} else {
        		return list.get("dead");
        		//return new GOLCellType("Dead", value);
        	}
        } else {
        	boolean value = sum == 3;
        	if (value) {
        		//return new GOLCellType("Alive", value);
        		return list.get("Alive");

        	} else {
        		//return new GOLCellType("Dead", value);
        		return list.get("dead");

        	}
        }
    }
     
    
    private Cell<GOLCellType> getUpperNeighbor(World2D<GOLCellType> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX();
        int neighborY = coordinates.getY() - 1;
        return (neighborY >= 0) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }
 
    private Cell<GOLCellType> getLowerNeighbor(World2D<GOLCellType> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX();
        int neighborY = coordinates.getY() + 1;
        return (neighborY < world.getDimensions().getHeight()) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }
 
    private Cell<GOLCellType> getLeftNeighbor(World2D<GOLCellType> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX() - 1;
        int neighborY = coordinates.getY();
        return (neighborX >= 0) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }
 
    private Cell<GOLCellType> getRightNeighbor(World2D<GOLCellType> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX() + 1;
        int neighborY = coordinates.getY();
        return (neighborX < world.getDimensions().getLength()) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }
 
    private Cell<GOLCellType> getUpperLeftNeighbor(World2D<GOLCellType> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX() - 1;
        int neighborY = coordinates.getY() - 1;
        return (neighborX >= 0 && neighborY >= 0) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }
 
    private Cell<GOLCellType> getUpperRightNeighbor(World2D<GOLCellType> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX() + 1;
        int neighborY = coordinates.getY() - 1;
        return (neighborX < world.getDimensions().getLength() && neighborY >= 0) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }
 
    private Cell<GOLCellType> getLowerLeftNeigbhor(World2D<GOLCellType> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX() - 1;
        int neighborY = coordinates.getY() + 1;
        return (neighborX >= 0 && neighborY < world.getDimensions().getHeight()) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }
 
    private Cell<GOLCellType> getLowerRightNeigbhor(World2D<GOLCellType> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX() + 1;
        int neighborY = coordinates.getY() + 1;
        return (neighborX < world.getDimensions().getLength() && neighborY < world.getDimensions().getHeight()) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }

	@Override
	public void calculateGrid(CellType value, World<GOLCellType> world, Coordinates coordinates) {
		// TODO Auto-generated method stub
		
	}



 
}