package application;
	
import java.io.IOException;

import controllerGUI.SimulationGridController;
import framework.gui.GridGui;
import framework.simulation.SimulationThread;
import framework.universe2d.Coordinates2D;
import gameoflife.Boolean2DWorld;
import gameoflife.ConwaysGameOfLifeRule;
import gameoflife.GOLDrawer;
import gameoflife.ToadPattern;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	
	private GridPane root;
	private SimulationThread<Boolean> simulation;
	private SimulationGridController controller;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Boolean2DWorld world = new Boolean2DWorld(70, 70, new ConwaysGameOfLifeRule());
			GridGui<Boolean> gui = new GridGui<Boolean>(70, new GOLDrawer());
			simulation = new SimulationThread<Boolean>(world, gui);
            world.addPattern(new ToadPattern(), new Coordinates2D(30, 30));
            
            controller = new SimulationGridController();
			// Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("SimulationGrid.fxml"));
            root = (GridPane) loader.load();
            root.add((Pane) gui, 0, 0);            
            
            controller.setSimulation(simulation);
            // Listeners
            addCloseListener(primaryStage);
            setMouseListener(gui, world);
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setWidth(1024);
            primaryStage.setHeight(800);
            primaryStage.setResizable(false);
            primaryStage.show();

            simulation.start();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
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
	
	private void setMouseListener(GridGui<Boolean> gui, Boolean2DWorld world) {
	    gui.setOnMouseDragged(new EventHandler<MouseEvent>() {
	    	public void handle(MouseEvent m) {
	    		double x = m.getX();
	    		double y = m.getY();
	    		
	    		int colX = (int) (x/gui.getScreenHeight());
	    		int colY = (int) (y/gui.getScreenHeight());
	    		world.addPattern(new ToadPattern(), new Coordinates2D(colX, colY));
	    	}
	    });
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
