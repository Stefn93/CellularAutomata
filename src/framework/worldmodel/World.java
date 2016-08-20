package framework.worldmodel;

public interface World<T> {
 
    public void nextState();
    public Cell<T> getCell(Coordinates coordinates);
    public int getGeneration();
    public WorldDimension getDimensions();
}