package fcast.universe.world.cell;

import java.util.HashSet;

@SuppressWarnings("serial")
public class StateList<T extends CellType> extends HashSet<T>{
	public static String DEAD;
	
	public StateList(String dead) {
		DEAD = dead;
	}
	
	public T get(String s) {
		//s = s.toLowerCase();
		for (T t:this) {
			if(t.getValueName().equals(s)){
				return t;
			}
		}
		return null;
	}

	public T getDead() {
		return get(DEAD);
	}
}

