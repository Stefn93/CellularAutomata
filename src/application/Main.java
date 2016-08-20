package application;
	
import java.io.IOException;

import framework.gui.GridGui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	
	private GridPane root;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("SimulationGrid.fxml"));
            root = (GridPane) loader.load();
            
            root.getChildren().add(0, new GridGui(80));
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
            primaryStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
