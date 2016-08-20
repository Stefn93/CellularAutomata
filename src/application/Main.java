package application;
	
import java.io.IOException;

import framework.gui.Drawer;
import framework.gui.GridGui;
import framework.gui.WorldGui;
import framework.simulation.SimulationThread;
import framework.universe.world.World;
import gameoflife.Boolean2DWorld;
import gameoflife.ConwaysGameOfLifeRule;
import gameoflife.GOLDrawer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	
	private GridPane root;
	private SimulationThread<Boolean> simulation;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			World<Boolean> world = new Boolean2DWorld(80, 80, new ConwaysGameOfLifeRule());
			WorldGui<Boolean> gui = new GridGui<Boolean>(80, new GOLDrawer());
			simulation = new SimulationThread<Boolean>(world, gui);
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("SimulationGrid.fxml"));
            root = (GridPane) loader.load();
            
            root.getChildren().add(0, (Pane) gui);
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
            primaryStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
            primaryStage.setResizable(false);
            primaryStage.show();
            simulation.start();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}


}
