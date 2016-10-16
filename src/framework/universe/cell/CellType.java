package framework.universe.cell;

import javafx.scene.paint.Color;

public abstract class CellType {
	
	public static final Color DEAD = Color.BLACK;
	
	private String valueName;
	
	private Object value;

	private Color color;
	
	protected CellType(String valueName, Object value, Color color){
		this.valueName = valueName;
		this.value = value;
		this.color = color;
	}
	public String getValueName() {
		return valueName;
	}
	
	public Object getValue() {
		return value;
	}
	
	public boolean equals(Object e) {
		CellType cell = (CellType) e;
		return (valueName.equals(cell.getValueName()) && value.equals(cell.getValue())); 
	}
	
	public String toString() {
		return valueName + " " + value;
	}
	
	public Color getColor() {
		return color;
	}
	public int hashCode() {
		return valueName.hashCode();
	}
}

