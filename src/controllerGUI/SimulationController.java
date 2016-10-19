package controllerGUI;

import java.net.URL;
import java.util.ResourceBundle;
import framework.simulation.SimulationThread;
import framework.universe.cell.Pattern;
import gameoflife.GOLCellType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class SimulationController implements Initializable{
	
    @FXML 
    private Button restart;
    @FXML 
    private Button start;
    @FXML
    private Slider delay;
    @FXML
    private Label generationLabel;
    @FXML
    private ChoiceBox<? extends Pattern> patternChoice; 
    @FXML
    private TextField infoTextField;
    @FXML
    private VBox graphVBox;


	private SimulationThread<GOLCellType> simulation;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setSimulation(SimulationThread<GOLCellType> simulation){
		this.simulation = simulation;
		this.simulation.setGuiController(this);
		ObservableList list = FXCollections.observableArrayList(simulation.getPatterns());
		patternChoice.setItems(list);	
		if(patternChoice.getItems().size() > 0){
    		patternChoice.getSelectionModel().selectFirst();
    		simulation.getGui().setMouseListener(patternChoice.getSelectionModel().getSelectedItem());
    	}
		this.simulation.start();
	}

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
    	delayListener();
    	startListener();
    	restartListener();
    	choiceListener();
    }
    
    private void restartListener(){
    	restart.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
    		@Override
    		public void handle(MouseEvent e){
    			simulation.reset();
    		}
    	});
    }
    
    private void startListener(){
    	start.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
    		@Override
    		public void handle(MouseEvent e){
    			simulation.setPaused(!simulation.isPaused());
    		}
    	});
    }
    
    private void delayListener(){
	    delay.valueProperty().addListener(new ChangeListener<Number>() {
	    	public void changed(ObservableValue<? extends Number> ov,
	    			Number old_val, Number new_val) {
	    		simulation.setDelay(new_val.intValue());
	    	}
	    });
    }

    private void choiceListener() {
    	patternChoice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pattern>() {
    		@Override
    		public void changed(ObservableValue<? extends Pattern> ol, Pattern oldVal, Pattern newVal) {
    			simulation.getGui().setMouseListener(patternChoice.getSelectionModel().getSelectedItem());    			
    		}
    	});
    }

	public Label getGenerationLabel() {
		return generationLabel;
	}
	
	public void setSimulationInfo(String s){
		infoTextField.setText(s + "\n");
	}
    
	public VBox getGraphVBox() {
		return graphVBox;
	}
	
}
