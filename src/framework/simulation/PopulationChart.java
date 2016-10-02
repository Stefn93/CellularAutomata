package framework.simulation;

import java.util.Iterator;

import framework.universe.cell.CellType;
import framework.universe.cell.StateList;
import gameoflife.GOLCellType;
import javafx.collections.ObservableList;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import java.util.*;

public class PopulationChart<T extends CellType> extends LineChart{

	public int boh;
	private StateList<T> states;
	
	public PopulationChart(Axis xAxis, Axis yAxis, StateList<T> states) {
		super(xAxis, yAxis);
		this.states = states;
		for (CellType state:states) {
	        XYChart.Series series = new XYChart.Series();
	        series.setName(state.getValueName());
	        getData().add(series);
		}
		this.setAnimated(false);
	}

	public void updateInfo(Map<T, Integer> worldStatus) {
        //defining a series
        //populating the series with data

		Iterator it = this.getDisplayedSeriesIterator();
        while (it.hasNext()) {
        	Series actual = (Series)it.next();
        	for (CellType value:states) {
        		if(actual.getName().equals(value.getValueName()))
        			actual.getData().add(new XYChart.Data(boh, worldStatus.get(value)));
        	}
        	boh++;
        }
        
	}
}
