package framework.universe.world;

import framework.simulation.Behaviour;
import framework.universe.world.cell.CellType;
import framework.universe.world.cell.Coordinates;
import framework.universe.world.cell.StateList;

public abstract class SimpleWorld<T extends CellType> implements World<T>{
	protected Behaviour<T> behaviour;
	protected int generation;
	protected WorldDimension dimensions = new WorldDimension();
	protected int evolutionRate;
	protected StateList<T> list;

	
	public int getEvolutionRate(){
		return evolutionRate;
	}
	
	public void incrementEvolutionRate(){
		evolutionRate++;
	}
	
	public SimpleWorld(Behaviour<T> behaviour) {
		this.behaviour = behaviour;
	}
	
	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}
	
	public boolean isDead(Coordinates coord) {
		return (getCell(coord).getValue().equals(list.getDead()) || getCell(coord) == null);
	}
	
	@Override
	public WorldDimension getDimensions() {
		return dimensions;
	}
	
	@Override
	public String getInfo(){
		return null;
	}

}

