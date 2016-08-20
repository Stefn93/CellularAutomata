package gameoflife;

import framework.simulation.Behaviour;
import framework.universe.cell.Cell;
import framework.universe.cell.Coordinates;
import framework.universe.cell.SimpleCell;
import framework.universe.world.World;
import framework.world2d.Coordinates2D;
import framework.world2d.World2D;

public class ConwaysGameOfLifeRule implements Behaviour<Boolean> {
     
    private static Cell<Boolean> EMPTY_CELL = new SimpleCell<Boolean>(false);
 
    @Override
    public Boolean calculateNewValue(World<Boolean> world, Coordinates coordinates) {
        Coordinates2D gridCoordinates = (Coordinates2D)coordinates;
        World2D<Boolean> gridWorld = (Boolean2DWorld) world;
        int sum = (getUpperNeighbor(gridWorld, gridCoordinates).getValue() ? 1 : 0) + (getLowerNeighbor(gridWorld, gridCoordinates).getValue() ? 1 : 0)
                + (getLeftNeighbor(gridWorld, gridCoordinates).getValue() ? 1 : 0) + (getRightNeighbor(gridWorld, gridCoordinates).getValue() ? 1 : 0)
                + (getUpperLeftNeighbor(gridWorld, gridCoordinates).getValue() ? 1 : 0) + (getUpperRightNeighbor(gridWorld, gridCoordinates).getValue() ? 1 : 0)
                + (getLowerLeftNeigbhor(gridWorld, gridCoordinates).getValue() ? 1 : 0) + (getLowerRightNeigbhor(gridWorld, gridCoordinates).getValue() ? 1 : 0);
        return world.getCell(coordinates).getValue() ? sum == 2 || sum == 3 : sum == 3;
    }
     
    private Cell<Boolean> getUpperNeighbor(World2D<Boolean> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX();
        int neighborY = coordinates.getY() - 1;
        return (neighborY >= 0) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }
 
    private Cell<Boolean> getLowerNeighbor(World2D<Boolean> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX();
        int neighborY = coordinates.getY() + 1;
        return (neighborY < world.getDimensions().getHeight()) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }
 
    private Cell<Boolean> getLeftNeighbor(World2D<Boolean> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX() - 1;
        int neighborY = coordinates.getY();
        return (neighborX >= 0) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }
 
    private Cell<Boolean> getRightNeighbor(World2D<Boolean> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX() + 1;
        int neighborY = coordinates.getY();
        return (neighborX < world.getDimensions().getLength()) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }
 
    private Cell<Boolean> getUpperLeftNeighbor(World2D<Boolean> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX() - 1;
        int neighborY = coordinates.getY() - 1;
        return (neighborX >= 0 && neighborY >= 0) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }
 
    private Cell<Boolean> getUpperRightNeighbor(World2D<Boolean> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX() + 1;
        int neighborY = coordinates.getY() - 1;
        return (neighborX < world.getDimensions().getLength() && neighborY >= 0) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }
 
    private Cell<Boolean> getLowerLeftNeigbhor(World2D<Boolean> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX() - 1;
        int neighborY = coordinates.getY() + 1;
        return (neighborX >= 0 && neighborY < world.getDimensions().getHeight()) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }
 
    private Cell<Boolean> getLowerRightNeigbhor(World2D<Boolean> world, Coordinates2D coordinates) {
        int neighborX = coordinates.getX() + 1;
        int neighborY = coordinates.getY() + 1;
        return (neighborX < world.getDimensions().getLength() && neighborY < world.getDimensions().getHeight()) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
    }


	@Override
	public void calculateGrid(Boolean value, World<Boolean> world, Coordinates coordinates) {
		// TODO Auto-generated method stub
		
	}
 
}