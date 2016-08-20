package framework.worldmodel;

public interface World<T> {
 
    public void nextState();
    public Cell<T> getCell(Coordinates coordinates);
    public void randomize();
    public void reset();
    public void setResolution(int w, int h);
    public int getGeneration();
    public WorldDimension getDimensions();
	public void setGeneration(int i);
}