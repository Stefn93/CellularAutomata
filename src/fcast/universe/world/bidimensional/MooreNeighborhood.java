package fcast.universe.world.bidimensional;

import fcast.universe.world.Behaviour;
import fcast.universe.world.World;
import fcast.universe.world.cell.Cell;
import fcast.universe.world.cell.CellType;
import fcast.universe.world.cell.Coordinates;

/**
 * Classe per la definizione di comportamenti basati sul vicinato di Moore
 * 
 *
 * @param <x>
 *            tipo di cella presente nella simulazione
 */
public abstract class MooreNeighborhood<x extends CellType> implements Behaviour<x> {

	/**
	 * Cella vuota
	 */
	protected Cell<x> EMPTY_CELL;

	protected MooreNeighborhood(Cell<x> cell) {
		EMPTY_CELL = cell;
	}

	protected Cell<x> getUpperNeighbor(World2D<x> world, Coordinates2D coordinates) {
		int neighborX = coordinates.getX();
		int neighborY = coordinates.getY() - 1;
		return (neighborY >= 0) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
	}

	protected Cell<x> getLowerNeighbor(World2D<x> world, Coordinates2D coordinates) {
		int neighborX = coordinates.getX();
		int neighborY = coordinates.getY() + 1;
		return (neighborY < world.getDimensions().getHeight()) ? world.getCell(new Coordinates2D(neighborX, neighborY))
				: EMPTY_CELL;
	}

	protected Cell<x> getLeftNeighbor(World2D<x> world, Coordinates2D coordinates) {
		int neighborX = coordinates.getX() - 1;
		int neighborY = coordinates.getY();
		return (neighborX >= 0) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
	}

	protected Cell<x> getRightNeighbor(World2D<x> world, Coordinates2D coordinates) {
		int neighborX = coordinates.getX() + 1;
		int neighborY = coordinates.getY();
		return (neighborX < world.getDimensions().getLength()) ? world.getCell(new Coordinates2D(neighborX, neighborY))
				: EMPTY_CELL;
	}

	protected Cell<x> getUpperLeftNeighbor(World2D<x> world, Coordinates2D coordinates) {
		int neighborX = coordinates.getX() - 1;
		int neighborY = coordinates.getY() - 1;
		return (neighborX >= 0 && neighborY >= 0) ? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
	}

	protected Cell<x> getUpperRightNeighbor(World2D<x> world, Coordinates2D coordinates) {
		int neighborX = coordinates.getX() + 1;
		int neighborY = coordinates.getY() - 1;
		return (neighborX < world.getDimensions().getLength() && neighborY >= 0)
				? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
	}

	protected Cell<x> getLowerLeftNeighbor(World2D<x> world, Coordinates2D coordinates) {
		int neighborX = coordinates.getX() - 1;
		int neighborY = coordinates.getY() + 1;
		return (neighborX >= 0 && neighborY < world.getDimensions().getHeight())
				? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
	}

	protected Cell<x> getLowerRightNeighbor(World2D<x> world, Coordinates2D coordinates) {
		int neighborX = coordinates.getX() + 1;
		int neighborY = coordinates.getY() + 1;
		return (neighborX < world.getDimensions().getLength() && neighborY < world.getDimensions().getHeight())
				? world.getCell(new Coordinates2D(neighborX, neighborY)) : EMPTY_CELL;
	}

	@Override
	public void calculateGrid(CellType value, World<x> world, Coordinates coordinates) {
	}

}
