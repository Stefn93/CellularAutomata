package framework.universe.cell;

public abstract class CellType {
	private String valueName;
	private Object value;
	
	protected CellType(String valueName, Object value){
		this.valueName = valueName;
		this.value = value;
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
	
	public int hashCode() {
		return valueName.hashCode();
	}
}
