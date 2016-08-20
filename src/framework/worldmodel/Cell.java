package framework.worldmodel;
public interface Cell<T> {
    public T getValue();
    public void setValue(T value);
    void confirmRevaluation();
    public boolean isRevaluated();
	void revaluateCell(T value);
}