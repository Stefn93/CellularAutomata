package application;
	
import java.io.IOException;

import controllerGUI.SimulationController;
import framework.gui.GridGui;
import framework.gui.WorldGui;
import framework.simulation.SimulationThread;
import framework.universe.cell.Pattern;
import framework.universe2d.Coordinates2D;
import gameoflife.GOLWorld;
import gameoflife.SingleCellPattern;
import gameoflife.ConwaysGameOfLifeRule;
import gameoflife.GOLBuilder;
import gameoflife.GOLDrawer;
import gameoflife.ToadPattern;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	
	private GridPane root;
	private SimulationController controller;
	private static WorldGui gui;
	
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
            controller.setSimulation(new SimulationThread<Boolean>(gui));
            // Listeners
            addCloseListener(primaryStage);
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setWidth(1024);
            primaryStage.setHeight(800);
            primaryStage.setResizable(false);
            primaryStage.show();

            
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
	
	public static void setSimulation(WorldGui gui) {
		Main.gui = gui;
	}


	public static void main(String[] args) throws Exception {
		Main.setSimulation(GOLBuilder.build());
		Main.launch(args);
	}
	
}
