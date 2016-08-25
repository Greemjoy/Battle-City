package BattleCity.Systems;

import BattleCity.Components.Position;
import BattleCity.GameManager;
import Engine.Entity;
import Engine.System;

import java.util.ArrayList;

/**
 * Created by Gref on 30.05.2016.
 */
public class CleanerSystem extends System {

    @Override
    public void update(double dt) {
        for (Entity e : (ArrayList<Entity>)GameManager.instance.getCurrentScene().getEntities().clone()) {

            Position position = e.getComponent(Position.class);

            if (position  == null)
                continue;

            if (position.value.x > GameManager.WIDTH  * 2  ||
                    position.value.y > GameManager.HEIGHT * 2 ||
                    position.value.y < 0)
                GameManager.instance.getCurrentScene().getEntities().remove(e);





        }
    }
}
