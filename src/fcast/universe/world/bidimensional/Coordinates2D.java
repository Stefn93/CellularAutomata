package fcast.universe.world.bidimensional;

import fcast.universe.world.cell.Coordinates;

public class Coordinates2D implements Coordinates{

	private int x;
	private int y;
	
	public Coordinates2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int[] getCoordinates() {
		return new int[]{x, y};
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public String toString() {
		return x + " " + y;
	}
}

