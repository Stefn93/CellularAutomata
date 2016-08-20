package framework.gui;

public interface CAGUI<T> {
	public CellCanvas<T> getRandomCanvas();
	public void updateStatus(int generation);
	public void endStepping();
}
