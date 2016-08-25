package BattleCity.Components;

import Engine.Component;
import Engine.MathVectors.Vector2i;

/**
 * Created by Gref on 29.05.2016.
 */
public class Position extends Component {

    public Vector2i value = new Vector2i();

    public Position(Vector2i value) {
        this.value.set(value);
    }

}
