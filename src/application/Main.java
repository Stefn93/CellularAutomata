package application;

import java.io.IOException;

import cellularTransport.CTBuilder;
import controllerGUI.SimulationController;
import framework.gui.WorldGui;
import framework.simulation.EvolutionRateChart;
import framework.simulation.SimulationChart;
import framework.simulation.SimulationThread;
import gameoflife.GOLCellType;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

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
			loader.setLocation(Main.class.getResource("SimulationGrid.fxml"));
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

	public static void setSimulation(WorldGui gui) {
		Main.gui = gui;
	}

	public static void main(String[] args) throws Exception {

		// GAME OF LIFE
		// Main.setSimulation(GOLBuilder.build());
		// Main.setGraph(GOLBuilder.buildPopulationChart(), new
		// EvolutionRateChart(new NumberAxis(), new NumberAxis()));

		// CELLULAR MEMBRANE
		Main.setSimulation(CTBuilder.build());
		Main.setGraph(CTBuilder.buildPopulationChart(), new EvolutionRateChart(new NumberAxis(), new NumberAxis()));

		Main.launch(args);
	}

	private static void setGraph(SimulationChart buildPieChart, SimulationChart evolutionRateChart2) {
		populationChart = buildPieChart;
		evolutionRateChart = evolutionRateChart2;
	}

}
