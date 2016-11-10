package application;

import fcast.application.SimulationApplication;
import gameoflife.GOLBuilder;
import gameoflife.GOLStateList;

public class GameOfLifeMain extends SimulationApplication {
	
	public static void main(String[] args) throws Exception {
		setSimulation(new GOLBuilder(), new GOLStateList());
		launch(args);
	}
}
