package cellularTransport;

import java.util.ArrayList;
import java.util.List;

import cellularTransport.patternsCT.Glucose;
import cellularTransport.patternsCT.Cl;
import cellularTransport.patternsCT.Oxygen;
import framework.gui.GridGui;
import framework.gui.WorldGui;
import framework.simulation.PopulationChart;
import framework.universe2d.GridPattern;
import javafx.scene.chart.NumberAxis;

public class CTBuilder {

	public static WorldGui<CTCellType> build() {
		List<GridPattern<CTCellType>> list = new ArrayList<GridPattern<CTCellType>>();
		list.add(new AllMoleculesPattern());
		list.add(new Cl());
		list.add(new Glucose());
		list.add(new Oxygen());

		GridGui<CTCellType> gui = new GridGui<CTCellType>(70, new CTWorld(70, 70, new CellularTransportRule()), list);
        gui.setMouseListener(new Cl());
		
		return gui;
	}

	public static PopulationChart<CTCellType> buildPopulationChart() {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setAutoRanging(true);
        xAxis.setLabel("Generation");
        yAxis.setLabel("Population");
        xAxis.setAnimated(true);
        yAxis.setAnimated(true);
        //creating the chart

        final PopulationChart<CTCellType> chart = new PopulationChart(xAxis, yAxis, new CTStateList());
        
		return chart;
	}

}

