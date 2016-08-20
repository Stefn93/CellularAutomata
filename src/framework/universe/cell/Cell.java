package framework.universe.cell;
public interface Cell<T> {
    public T getValue();
    public void setValue(T value);
    void confirmRevaluation();
	void revaluateCell(T value);
}