package controllerGUI;

import java.net.URL;
import java.util.ResourceBundle;
import framework.simulation.SimulationThread;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

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
    private ChoiceBox<String> patternchoice; 

	private SimulationThread<Boolean> simulation;
	
	public void setSimulation(SimulationThread<Boolean> simulation){
		this.simulation = simulation;
		simulation.start();
	}

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
    	delayListener();
    	startListener();
    	restartListener();
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

}
