package framework.universe.cell;

import java.util.ArrayList;
import java.util.HashSet;

import gameoflife.GOLCellType;

@SuppressWarnings("serial")
public class StateList<T extends CellType> extends HashSet<T>{
	public static final String DEAD = "dead";
	
	public T get(String s) {
		s = s.toLowerCase();
		for (T t:this) {
			if(t.getValueName().equals(s)){
				return t;
			}
		}
		return null;
	}
}

