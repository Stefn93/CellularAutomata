package cellularTransport;

import fcast.universe.world.World;
import fcast.universe.world.bidimensional.Coordinates2D;
import fcast.universe.world.bidimensional.MooreNeighborhood;
import fcast.universe.world.bidimensional.World2D;
import fcast.universe.world.cell.Cell;
import fcast.universe.world.cell.Coordinates;
import fcast.universe.world.cell.SimpleCell;

public class CellularTransportRule extends MooreNeighborhood<CTCellType> {
     
	protected CellularTransportRule() {
		super(new SimpleCell<CTCellType>(stateList.get("Empty")));
	}

	private static CTStateList stateList = new CTStateList();
    private static CTCellType emptyCell = stateList.get("Empty");
    private CTCellType actualCell;
    private CTWorld ctWorld;
 
    @Override
    public CTCellType calculateNewValue(World<CTCellType> world, Coordinates coordinates) {
        Coordinates2D gridCoordinates = (Coordinates2D) coordinates;
        ctWorld = (CTWorld) world;
        actualCell = ctWorld.getCell(gridCoordinates).getValue();
        
        int status = (Integer) actualCell.getValue();
        if( status == 2 || status == 3 || status == 4) 
        	return cellMovement(gridCoordinates);
        else
        	return actualCell; 
    }
    
    private CTCellType cellMovement(Coordinates2D actualCoordinates){
    	
    	Double casualDirection = Math.random()*1000;
    	Cell<CTCellType> destinationCell = new SimpleCell<CTCellType>(actualCell);
    	Coordinates2D newCoordinates = actualCoordinates;
    	
    	if((casualDirection % 8) < 1){
    		destinationCell = getUpperLeftNeighbor(ctWorld, actualCoordinates);
    		newCoordinates = new Coordinates2D(actualCoordinates.getX()-1, actualCoordinates.getY()-1);
    	}
    	else if((casualDirection % 8) < 2){
    		destinationCell = getUpperNeighbor(ctWorld, actualCoordinates);
    		newCoordinates = new Coordinates2D(actualCoordinates.getX(), actualCoordinates.getY()-1);
    	}
    	else if((casualDirection % 8) < 3) {
    		destinationCell = getUpperRightNeighbor(ctWorld, actualCoordinates);
    		newCoordinates = new Coordinates2D(actualCoordinates.getX()+1, actualCoordinates.getY()-1);
    	}
    	else if((casualDirection % 8) < 4) {
    		destinationCell = getRightNeighbor(ctWorld, actualCoordinates);
    		newCoordinates = new Coordinates2D(actualCoordinates.getX()+1, actualCoordinates.getY());
    	}
    	else if((casualDirection % 8) < 5) {
    		destinationCell = getLowerRightNeighbor(ctWorld, actualCoordinates);
    		newCoordinates = new Coordinates2D(actualCoordinates.getX()+1, actualCoordinates.getY()+1);
    	}
    	else if((casualDirection % 8) < 6) {
    		destinationCell = getLowerNeighbor(ctWorld, actualCoordinates);
    		newCoordinates = new Coordinates2D(actualCoordinates.getX(), actualCoordinates.getY()+1);
    	}
    	else if((casualDirection % 8) < 7) {
    		destinationCell = getLowerLeftNeighbor(ctWorld, actualCoordinates);
    		newCoordinates = new Coordinates2D(actualCoordinates.getX()-1, actualCoordinates.getY()+1);
    	}
    	else if((casualDirection % 8) < 8) {
    		destinationCell = getLeftNeighbor(ctWorld, actualCoordinates);
    		newCoordinates = new Coordinates2D(actualCoordinates.getX()-1, actualCoordinates.getY());
    	}
    	
    	if (destinationCell.getValue().getValueName().equals("Empty") && checkDimensions(newCoordinates, ctWorld)){
    		ctWorld.nextStateCell(actualCell, newCoordinates);
    		ctWorld.nextStateCell(emptyCell, actualCoordinates);
    		ctWorld.incrementEvolutionRate();
    		return emptyCell;
    	}
    	else if ((Integer) actualCell.getValue() == 2 && (Integer) destinationCell.getValue().getValue() == 5 && gradientCompensationNeeded(actualCell, actualCoordinates, newCoordinates)) 
    	{
    		return carryOutTransport(actualCoordinates, newCoordinates, actualCell);
    	}
    	else if ((Integer) actualCell.getValue() == 3 && (Integer) destinationCell.getValue().getValue() == 1 && gradientCompensationNeeded(actualCell, actualCoordinates, newCoordinates)) 
    	{
    		return carryOutTransport(actualCoordinates, newCoordinates, actualCell);
    	}
    	else if ((Integer) actualCell.getValue() == 4 && (Integer) destinationCell.getValue().getValue() == 6 && gradientCompensationNeeded(actualCell, actualCoordinates, newCoordinates)) 
    	{
    		return carryOutTransport(actualCoordinates, newCoordinates, actualCell);
    	}
    	else if((Integer) actualCell.getValue() == 2 && (Integer) destinationCell.getValue().getValue() == 7 && ctWorld.getAtp() > 0 && !gradientCompensationNeeded(actualCell, actualCoordinates, newCoordinates)){
    		ctWorld.decrementATP();
    		return carryOutTransport(actualCoordinates, newCoordinates, actualCell);
    	}
    	else if((Integer) actualCell.getValue() == 4 && (Integer) destinationCell.getValue().getValue() == 8 && ctWorld.getAtp() > 0 && !gradientCompensationNeeded(actualCell, actualCoordinates, newCoordinates)){
    		ctWorld.decrementATP();
    		return carryOutTransport(actualCoordinates, newCoordinates, actualCell);
    	}
    	else return actualCell;
    		
    }
    
    private CTCellType carryOutTransport(Coordinates2D oldC, Coordinates2D newC, CTCellType actualCell){
    	if(detectMovementDirection(oldC, newC).equals("Out") && ctWorld.getCell(new Coordinates2D(newC.getX(), newC.getY()+2)).getValue().getValueName().equals("Empty")) 
		{
			ctWorld.nextStateCell(actualCell, new Coordinates2D(newC.getX(), newC.getY() + 2));
			ctWorld.nextStateCell(emptyCell, oldC);
		}
		else if (detectMovementDirection(oldC, newC).equals("In") && ctWorld.getCell(new Coordinates2D(newC.getX(), newC.getY()-2)).getValue().getValueName().equals("Empty")) 
		{
			ctWorld.nextStateCell(actualCell, new Coordinates2D(newC.getX(), newC.getY() - 2));
			ctWorld.nextStateCell(emptyCell, oldC);
		}
    	ctWorld.incrementEvolutionRate();
		return emptyCell;
    }
    
    private boolean gradientCompensationNeeded(CTCellType actualCell, Coordinates2D oldC, Coordinates2D newC){
    	int outGradient = 0;
    	int inGradient = 0;
    	
		for (int x = 0; x < ctWorld.getDimensions().getLength(); x++)
			for (int y = 0; y < 34; y++)
    			if (ctWorld.getCell(new Coordinates2D(x,y)).getValue().getValueName().equals(actualCell.getValueName()))
    				outGradient++;
		
		for (int x = 0; x < ctWorld.getDimensions().getLength(); x++)
			for (int y = 36; y < ctWorld.getDimensions().getHeight(); y++)
    			if (ctWorld.getCell(new Coordinates2D(x,y)).getValue().getValueName().equals(actualCell.getValueName()))
    				inGradient++;
    	
		if ((detectMovementDirection(oldC, newC).equals("Out") && outGradient > inGradient) || 
			(detectMovementDirection(oldC, newC).equals("In") && inGradient > outGradient))
			return true;
		else 
			return false;			
    }
    
    private String detectMovementDirection(Coordinates2D oldC, Coordinates2D newC){
    	if (oldC.getY() < newC.getY())
    		return "Out";
    	else
    		return "In";
    }
    
    private boolean checkDimensions(Coordinates2D coordinates, World2D<CTCellType> world){
    	if(coordinates.getX() > 0 && coordinates.getX() < world.getDimensions().getLength() && 
    	   coordinates.getY() > 0 && coordinates.getY() < world.getDimensions().getHeight())
    		return true;
    	else
    		return false;
    }
 
}