package BattleCity.Systems;

import BattleCity.Components.Direction;
import BattleCity.Components.Position;
import BattleCity.Components.Speed;
import BattleCity.GameManager;
import Engine.Entity;
import Engine.MathVectors.Vector2i;
import Engine.System;

/**
 * Created by Gref on 30.05.2016.
 */
public class MovementSystem extends System {

    @Override
    public void update(double dt) {

        for (Entity e : GameManager.instance.getCurrentScene().getEntities()) {

            Position position = e.getComponent(Position.class);
            Speed speed = e.getComponent(Speed.class);
            Direction direction = e.getComponent(Direction.class);

            if (position == null ||
                    speed == null ||
                    direction == null) continue;
            Vector2i offset = new Vector2i(direction.value);
            offset.mul(speed.value);

            position.value.add(offset);
        }
    }
}

