package application;
	
import java.io.IOException;

import cellularTransport.CTBuilder;
import controllerGUI.SimulationController;
import framework.gui.WorldGui;
import framework.simulation.EvolutionRateChart;
import framework.simulation.PopulationChart;
import framework.simulation.SimulationThread;
import gameoflife.GOLBuilder;
import gameoflife.GOLCellType;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.Chart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	
	private GridPane root;
	private SimulationController controller;
	private static WorldGui gui;
	private static PopulationChart populationChart;
	private static EvolutionRateChart evolutionRateChart;
	
	//numero di caselle di un colore entro un raggio dalle altre caselle dello stesso colore 
	//wa-tor pip
	//gli automi cellulare riconsiderare - astrobiologica -
	// forma di vita come esemplari che competono o forma di vita come liquidi che riconoscono ciò che sono e non sono.
	//coacervato 
	// pag 241
	
	@Override
	public void start(Stage primaryStage) {
		try {

			//GridGui<Boolean> gui = 
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
            primaryStage.setWidth(1024);
            primaryStage.setHeight(800);
            primaryStage.setResizable(false);
            primaryStage.show();
            showChart(populationChart, "Population Chart");
            showChart(evolutionRateChart, "Evolution Rate");

            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private void showChart(LineChart chart, String name) {
			Stage stage = new Stage();
	        Scene scene = new Scene(new Group());
	        
			chart.setCreateSymbols(false);
			chart.setTitle(name);
	        stage.setTitle(name);
			chart.setAnimated(true);
			chart.autosize();
	        stage.setWidth(550);
	        stage.setHeight(550);
	        ((Group) scene.getRoot()).getChildren().add(chart);
	        stage.setScene(scene);
	        stage.show();
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
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        
        //GAME OF LIFE
        //Main.setSimulation(GOLBuilder.build());
		//Main.setGraph(GOLBuilder.buildPopulationChart(), new EvolutionRateChart(xAxis, yAxis));
        
        //CELLULAR MEMBRANE
        Main.setSimulation(CTBuilder.build());
        Main.setGraph(CTBuilder.buildPopulationChart(), new EvolutionRateChart(xAxis,yAxis)); 
        
		Main.launch(args);
	}

	private static void setGraph(PopulationChart buildPieChart, EvolutionRateChart evolutionRateChart2) {
		populationChart = buildPieChart;
		evolutionRateChart = evolutionRateChart2;
	}
	
}
