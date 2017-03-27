package fcast.application;

import java.io.IOException;

import fcast.gui.WorldGui;
import fcast.gui.controller.SimulationController;
import fcast.simulation.CellularAutomataBuilder;
import fcast.simulation.SimulationChart;
import fcast.simulation.SimulationThread;
import fcast.universe.world.cell.StateList;
import gameoflife.GOLCellType;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class SimulationApplication extends Application {

	private GridPane root;
	private SimulationController controller;
	private static WorldGui gui;
	private static SimulationChart populationChart;
	private static SimulationChart evolutionRateChart;

	@Override
	public void start(Stage primaryStage) {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(SimulationApplication.class.getResource("SimulationGrid.fxml"));
			root = (GridPane) loader.load();
			root.add(gui.getNode(), 0, 0);
			GridPane.setMargin(gui.getNode(), new Insets(40, 0, 0, 40));
			controller = loader.getController();
			controller.setSimulation(new SimulationThread<GOLCellType>(gui, populationChart, evolutionRateChart));
			// Listeners
			addCloseListener(primaryStage);

			// Show the scene containing the root layout.
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setWidth(1280);
			primaryStage.setHeight(900);
			primaryStage.setResizable(false);
			primaryStage.show();
			showChart(populationChart, "Population Chart");
			showChart(evolutionRateChart, "Evolution Rate Chart");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void showChart(LineChart chart, String name) {

		chart.setCreateSymbols(false);
		chart.setTitle(name);
		chart.setAnimated(false);
		chart.autosize();
		controller.getGraphVBox().getChildren().add(chart);
	}

	private void addCloseListener(Stage primaryStage) {
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent t) {
				Platform.exit();
				System.exit(0);
			}
		});
	}

	public static void setSimulation(CellularAutomataBuilder sim, StateList list) {
		SimulationApplication.gui = sim.build();
		setGraph(sim.buildPopulationChart(list), sim.buildEvolutionRateChart());
	}

	private static void setGraph(SimulationChart buildPieChart, SimulationChart evolutionRateChart2) {
		populationChart = buildPieChart;
		evolutionRateChart = evolutionRateChart2;
	}

}
