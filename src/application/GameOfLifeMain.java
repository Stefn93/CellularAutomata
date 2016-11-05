package application;

import gameoflife.GOLBuilder;
import gameoflife.GOLStateList;

public class GameOfLifeMain extends SimulationApplication {
	public static void main(String[] args) throws Exception {

		// GAME OF LIFE
		setSimulation(new GOLBuilder(), new GOLStateList());
		launch(args);
	}
}
