package framework.simulation;

import java.io.IOException;

public interface CellularAutomatonChart {
	public void save(String dataName, String imgName) throws IOException;

	public void reset();

	public void updateInfo(int generation, Object o);
}
