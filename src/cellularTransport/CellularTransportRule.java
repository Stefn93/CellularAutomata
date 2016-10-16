package cellularTransport;

import framework.simulation.Behaviour;
import framework.universe.cell.Cell;
import framework.universe.cell.CellType;
import framework.universe.cell.Coordinates;
import framework.universe.cell.SimpleCell;
import framework.universe.world.World;
import framework.universe2d.Coordinates2D;
import framework.universe2d.World2D;

public class CellularTransportRule implements Behaviour<CTCellType> {
     
    private static Cell<CTCellType> EMPTY_CELL = new SimpleCell<CTCellType>(new CTCellType("Dead", 1));
 
    @Override
    public CTCellType calculateNewValue(World<CTCellType> world, Coordinates coordinates) {
        Coordinates2D gridCoordinates = (Coordinates2D) coordinates;
        World2D<CTCellType> gridWorld = (CTWorld) world;
        
        int status = ((Integer) world.getCell(gridCoordinates).getValue().getValue());
        if( status >= 3 || status <= 5) 
    		return cellMovement(gridCoordinates,gridWorld);
        else 
        	return gridWorld.getCell(gridCoordinates).getValue(); 
    }
    
    private CTCellType cellMovement(Coordinates2D gridCoordinates, World2D<CTCellType> gridWorld){
    	Double casualDirection = Math.random();
    	if((casualDirection % 8) < 1 && ((Integer) getUpperLeftNeighbor(gridWorld, gridCoordinates).getValue().getValue() == 0)){
    		getUpperLeftNeighbor(gridWorld, gridCoordinates).setValue(gridWorld.getCell(gridCoordinates).getValue());
    		return new CTCellType("Empty", 0);
    	}
    	else if((casualDirection % 8) < 2 && ((Integer) getUpperNeighbor(gridWorld, gridCoordinates).getValue().getValue() == 0)){
    		getUpperNeighbor(gridWorld, gridCoordinates).setValue(gridWorld.getCell(gridCoordinates).getValue());
    		return new CTCellType("Empty", 0);
    	}
    	else if((casualDirection % 8) < 3 && ((Integer) getUpperRightNeighbor(gridWorld, gridCoordinates).getValue().getValue() == 0)){
    		getUpperRightNeighbor(gridWorld, gridCoordinates).setValue(gridWorld.getCell(gridCoordinates).getValue());
    		return new CTCellType("Empty", 0);
    	}
    	else if((casualDirection % 8) < 4 && ((Integer) getRightNeighbor(gridWorld, gridCoordinates).getValue().getValue() == 0)){
    		getRightNeighbor(gridWorld, gridCoordinates).setValue(gridWorld.getCell(gridCoordinates).getValue());
    		return new CTCellType("Empty", 0);
    	}
    	else if((casualDirection % 8) < 5 && ((Integer) getLowerRightNeighbor(gridWorld, gridCoordinates).getValue().getValue() == 0)){
    		getLowerRightNeighbor(gridWorld, gridCoordinates).setValue(gridWorld.getCell(gridCoordinates).getValue());
    		return new CTCellType("Empty", 0);
    	}
    	else if((casualDirection % 8) < 6 && ((Integer) getLowerNeighbor(gridWorld, gridCoordinates).getValue().getValue() == 0)){
    		getLowerNeighbor(gridWorld, gridCoordinates).setValue(gridWorld.getCell(gridCoordinates).getValue());
    		return new CTCellType("Empty", 0);
    	}
    	else if((casualDirection % 8) < 7 && ((Integer) getLowerLeftNeighbor(gridWorld, gridCoordinates).getValue().getValue() == 0)){
    		getLowerLeftNeighbor(gridWorld, gridCoordinates).setValue(gridWorld.getCell(gridCoordinates).getValue());
    		return new CTCellType("Empty", 0);
    	}
    	else if((casualDirection % 8) < 8 && ((Integer) getLeftNeighbor(gridWorld, gridCoordinates).getValue().getValue() == 0)){
    		getLeftNeighbor(gridWorld, gridCoordinates).setValue(gridWorld.getCell(gridCoordinates).getValue());
    		return new CTCellType("Empty", 0);
    	}
    	else return gridWorld.getCell(gridCoordinates).getValue(); 
    }
    
    private Cell<CTCellType> getUpperNeighbor(World2D<CTCellType> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX();
        int neighborY = coordinates.getY() - 1;
        return (neighborY >= 0) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }
 
    private Cell<CTCellType> getLowerNeighbor(World2D<CTCellType> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX();
        int neighborY = coordinates.getY() + 1;
        return (neighborY < world.getDimensions().getHeight()) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }
 
    private Cell<CTCellType> getLeftNeighbor(World2D<CTCellType> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX() - 1;
        int neighborY = coordinates.getY();
        return (neighborX >= 0) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }
 
    private Cell<CTCellType> getRightNeighbor(World2D<CTCellType> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX() + 1;
        int neighborY = coordinates.getY();
        return (neighborX < world.getDimensions().getLength()) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }
 
    private Cell<CTCellType> getUpperLeftNeighbor(World2D<CTCellType> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX() - 1;
        int neighborY = coordinates.getY() - 1;
        return (neighborX >= 0 && neighborY >= 0) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }
 
    private Cell<CTCellType> getUpperRightNeighbor(World2D<CTCellType> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX() + 1;
        int neighborY = coordinates.getY() - 1;
        return (neighborX < world.getDimensions().getLength() && neighborY >= 0) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }
 
    private Cell<CTCellType> getLowerLeftNeighbor(World2D<CTCellType> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX() - 1;
        int neighborY = coordinates.getY() + 1;
        return (neighborX >= 0 && neighborY < world.getDimensions().getHeight()) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }
 
    private Cell<CTCellType> getLowerRightNeighbor(World2D<CTCellType> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX() + 1;
        int neighborY = coordinates.getY() + 1;
        return (neighborX < world.getDimensions().getLength() && neighborY < world.getDimensions().getHeight()) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }

	@Override
	public void calculateGrid(CellType value, World<CTCellType> world, Coordinates coordinates) {
		
	}



 
}