package BattleCity.Systems.Animation;

import BattleCity.Components.Animation.FadeOut;
import BattleCity.Components.Sprite;
import BattleCity.GameManager;
import Engine.Entity;
import Engine.Scene;
import Engine.System;

/**
 * Created by Gref on 30.05.2016.
 */
public class FadeOutSystem extends System {
    @Override
    public void update(double dt) {

        Scene gameScene = GameManager.instance.getCurrentScene();
        for (Entity e1 : gameScene.getEntities()) {

            FadeOut fadeOutcomponent = e1.getComponent(FadeOut.class);
            Sprite sprite           = e1.getComponent(Sprite.class);

            if (fadeOutcomponent == null ||
                    sprite       == null) continue;


            sprite.opacity = fadeOutcomponent.value;
            fadeOutcomponent.value -= dt / fadeOutcomponent.duration;

            if (fadeOutcomponent.value < 0)
                sprite.opacity = 0;
        }
    }
}
