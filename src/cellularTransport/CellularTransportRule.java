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
     
	private static CTStateList stateList = new CTStateList();
    private static Cell<CTCellType> EMPTY_CELL = new SimpleCell<CTCellType>(stateList.get("Empty"));
    private static CTCellType emptyCell = stateList.get("Empty");
    private CTCellType actualCell;
 
    @Override
    public CTCellType calculateNewValue(World<CTCellType> world, Coordinates coordinates) {
        Coordinates2D gridCoordinates = (Coordinates2D) coordinates;
        World2D<CTCellType> gridWorld = (CTWorld) world;
        actualCell = gridWorld.getCell(gridCoordinates).getValue();
        
        int status = (Integer) actualCell.getValue();
        if( status == 3 || status == 4 || status == 5) 
        	return cellMovement(gridCoordinates,gridWorld);
        else
        	return actualCell; 
    }
    
    private CTCellType cellMovement(Coordinates2D gridCoordinates, World2D<CTCellType> gridWorld){
    	
    	Double casualDirection = Math.random()*1000;
    	Cell<CTCellType> destinationCell = new SimpleCell<CTCellType>(actualCell);
    	Coordinates2D newCoordinates = gridCoordinates;
    	
    	if((casualDirection % 8) < 1){
    		destinationCell = getUpperLeftNeighbor(gridWorld, gridCoordinates);
    		newCoordinates = new Coordinates2D(gridCoordinates.getX()-1, gridCoordinates.getY()-1);
    	}
    	else if((casualDirection % 8) < 2){
    		destinationCell = getUpperNeighbor(gridWorld, gridCoordinates);
    		newCoordinates = new Coordinates2D(gridCoordinates.getX(), gridCoordinates.getY()-1);
    	}
    	else if((casualDirection % 8) < 3) {
    		destinationCell = getUpperRightNeighbor(gridWorld, gridCoordinates);
    		newCoordinates = new Coordinates2D(gridCoordinates.getX()+1, gridCoordinates.getY()-1);
    	}
    	else if((casualDirection % 8) < 4) {
    		destinationCell = getRightNeighbor(gridWorld, gridCoordinates);
    		newCoordinates = new Coordinates2D(gridCoordinates.getX()+1, gridCoordinates.getY());
    	}
    	else if((casualDirection % 8) < 5) {
    		destinationCell = getLowerRightNeighbor(gridWorld, gridCoordinates);
    		newCoordinates = new Coordinates2D(gridCoordinates.getX()+1, gridCoordinates.getY()+1);
    	}
    	else if((casualDirection % 8) < 6) {
    		destinationCell = getLowerNeighbor(gridWorld, gridCoordinates);
    		newCoordinates = new Coordinates2D(gridCoordinates.getX(), gridCoordinates.getY()+1);
    	}
    	else if((casualDirection % 8) < 7) {
    		destinationCell = getLowerLeftNeighbor(gridWorld, gridCoordinates);
    		newCoordinates = new Coordinates2D(gridCoordinates.getX()-1, gridCoordinates.getY()+1);
    	}
    	else if((casualDirection % 8) < 8) {
    		destinationCell = getLeftNeighbor(gridWorld, gridCoordinates);
    		newCoordinates = new Coordinates2D(gridCoordinates.getX()-1, gridCoordinates.getY());
    	}
    	
    	if(destinationCell.getValue().getValueName().equals("Empty") && checkDimensions(newCoordinates, gridWorld)){
    		//destinationCell.setValue(actualCell);
    		gridWorld.nextStateCell(actualCell, newCoordinates);
    		gridWorld.nextStateCell(emptyCell, gridCoordinates);
    		return emptyCell;
    	}
    	else return actualCell;
    		
    	
    }
    
    private boolean checkDimensions(Coordinates2D coordinates, World2D<CTCellType> world){
    	if(coordinates.getX() > 0 && coordinates.getX() < world.getDimensions().getLength() && 
    	   coordinates.getY() > 0 && coordinates.getY() < world.getDimensions().getHeight())
    		return true;
    	else
    		return false;
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