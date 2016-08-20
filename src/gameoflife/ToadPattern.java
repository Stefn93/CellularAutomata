package gameoflife;

import framework.universe2d.GridPattern;

public class ToadPattern extends GridPattern<Boolean> {
    @Override
    public Boolean[][] get() {
        return new Boolean[][] {{false, true, true, true}, {true, true, true, false}};
    }
}