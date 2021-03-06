package application;

import cellularTransport.CTBuilder;
import cellularTransport.CTStateList;
import fcast.application.SimulationApplication;

public class CellularTransportMain extends SimulationApplication {
	
	public static void main(String[] args) {
		setSimulation(new CTBuilder(), new CTStateList());
		launch(args);
	}
}
