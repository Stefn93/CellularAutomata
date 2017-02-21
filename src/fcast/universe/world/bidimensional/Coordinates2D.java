package fcast.universe.world.bidimensional;

import fcast.universe.world.cell.Coordinates;

/**
 * Classe per la definizione di coordinate valide in un mondo bidimensionale
 *
 */
public class Coordinates2D implements Coordinates {

	private int x;
	private int y;

	public Coordinates2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int[] getCoordinates() {
		return new int[] { x, y };
	}

	/**
	 * Getter per la coordinata X
	 * 
	 * @return coordinata X
	 */
	public int getX() {
		return x;
	}

	/**
	 * Getter per la coordinata Y
	 * 
	 * @return coordinata Y
	 */
	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return x + " " + y;
	}
}
