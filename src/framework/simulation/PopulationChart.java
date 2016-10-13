package framework.simulation;

import java.util.Iterator;

import framework.universe.cell.CellType;
import framework.universe.cell.StateList;
import gameoflife.GOLCellType;
import javafx.collections.ObservableList;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import java.util.*;

public class PopulationChart<T extends CellType> extends LineChart<Integer, Integer>{

	private StateList<T> states;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PopulationChart(Axis xAxis, Axis yAxis, StateList<T> states) {


		super(xAxis, yAxis);
		getStyleClass().add("thick-chart");
		this.states = states;
		for (CellType state:states) {
			if (!state.getValueName().equals(StateList.DEAD)) {
		        XYChart.Series series = new XYChart.Series();
		        series.setName(state.getValueName());
		        getData().add(series);
			}
		}

	}
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void updateInfo(int generation, Map<T, Integer> worldStatus) {
        //defining a series
        //populating the series with data

		Iterator<javafx.scene.chart.XYChart.Series<Integer, Integer>> it = this.getDisplayedSeriesIterator();
        while (it.hasNext()) {
        	Series actual = it.next();
        	for (CellType value:states) {
        		if(actual.getName().equals(value.getValueName()))
        			actual.getData().add(new XYChart.Data(generation, worldStatus.get(value)));
        	}
        }
        
	}

	@SuppressWarnings("unchecked")
	public void reset() {
		Iterator<javafx.scene.chart.XYChart.Series<Integer, Integer>> it = this.getDisplayedSeriesIterator();
        while (it.hasNext()) {
        	Series actual = it.next();
        	actual.getData().clear();
        }
	}
}
