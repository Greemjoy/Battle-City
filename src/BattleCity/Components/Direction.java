package BattleCity.Components;

import Engine.Component;
import Engine.MathVectors.Vector2i;

/**
 * Created by Gref on 29.05.2016.
 */
public class Direction extends Component {
    public Vector2i value;

    Vector2i current = Direction.DOWN;
    public static final Vector2i STOP  = new Vector2i( 0,  0);
    public static final Vector2i UP    = new Vector2i( 0, -1);
    public static final Vector2i DOWN  = new Vector2i( 0,  1);
    public static final Vector2i LEFT  = new Vector2i(-1,  0);
    public static final Vector2i RIGHT = new Vector2i( 1,  0);


    public Direction(Vector2i direction) {
        this.value = direction;
    }

    public void setDirection(Vector2i value) {
        this.value = value;
    }

    public void setCurrent(Vector2i direction){
        current = direction;
    }

    public Vector2i getCurrentDirection(){
        return current;
    }



}
