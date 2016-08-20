package gameoflife;

import framework.world2d.GridPattern;

public class ToadPattern extends GridPattern<Boolean> {
    @Override
    public Boolean[][] get() {
        return new Boolean[][] {{false, true, true, true}, {true, true, true, false}};
    }
}