package framework.worldmodel;

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
    	revaluated = false;
        revaluatedValue = value;
    }
 
    @Override
    public void confirmRevaluation() {
    	if (!value.equals(revaluatedValue)) {
    		revaluated = true;
	        value = revaluatedValue;
	        revaluatedValue = null;
    	}
    }

	@Override
	public boolean isRevaluated() {
		return revaluated;
	}

	@Override
	public void setValue(T value) {
		this.value = value;
	}
 
}