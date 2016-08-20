package framework.universe.cell;

public class SimpleCell<T> implements Cell<T> {
 
    private T value;
    private T revaluatedValue;
    private boolean revaluated = false;
 
    public SimpleCell(T value) {
        super();
        this.value = value;
    }
 
    @Override
    public T getValue() {
        return value;
    }
 
    @Override
    public void revaluateCell(T value) {
    	setRevaluated(false);
        revaluatedValue = value;
    }
 
    @Override
    public void confirmRevaluation() {
    	if (!value.equals(revaluatedValue)) {
    		setRevaluated(true);
	        value = revaluatedValue;
	        revaluatedValue = null;
    	}
    }


	@Override
	public void setValue(T value) {
		this.value = value;
	}

	public boolean isRevaluated() {
		return revaluated;
	}

	public void setRevaluated(boolean revaluated) {
		this.revaluated = revaluated;
	}
 
}