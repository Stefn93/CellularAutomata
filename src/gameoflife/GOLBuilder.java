package gameoflife;

import java.util.ArrayList;
import java.util.List;

import framework.gui.GridGui;
import framework.gui.WorldGui;
import framework.simulation.PopulationChart;
import framework.universe2d.GridPattern;
import gameoflife.patternsGOL.Beacon;
import gameoflife.patternsGOL.Beehive;
import gameoflife.patternsGOL.Blinker;
import gameoflife.patternsGOL.Block;
import gameoflife.patternsGOL.Boat;
import gameoflife.patternsGOL.GosperGliderGun;
import gameoflife.patternsGOL.Loaf;
import gameoflife.patternsGOL.Pulsar;
import gameoflife.patternsGOL.Single;
import gameoflife.patternsGOL.Toad;
import gameoflife.patternsGOL.Glider;
import javafx.scene.chart.NumberAxis;

public class GOLBuilder {

	public static WorldGui<GOLCellType> build() {
		List<GridPattern<GOLCellType>> list = new ArrayList<GridPattern<GOLCellType>>();
		list.add(new Single());
		list.add(new Beacon());
		list.add(new Beehive());
		list.add(new Block());
		list.add(new Loaf());
		list.add(new Boat());
		list.add(new Toad());
		list.add(new Pulsar());
		list.add(new Blinker());
		list.add(new GosperGliderGun());
		list.add(new Glider());

		GridGui<GOLCellType> gui = new GridGui<GOLCellType>(70, new GOLWorld(70, 70, new ConwaysGameOfLifeRule()), list);
        gui.setMouseListener(new Single());
		
		return gui;
	}

	public static PopulationChart<GOLCellType> buildPopulationChart() {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setAutoRanging(true);
        xAxis.setLabel("Generation");
        yAxis.setLabel("Population");
        xAxis.setAnimated(false);
        yAxis.setAnimated(false);
        
        //creating the chart
        final PopulationChart<GOLCellType> chart = new PopulationChart(xAxis, yAxis, new GOLStateList());
        
		return chart;
	}

}

