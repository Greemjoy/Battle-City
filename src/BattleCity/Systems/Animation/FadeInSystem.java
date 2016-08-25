package BattleCity.Systems.Animation;

import BattleCity.Components.Animation.FadeIn;
import BattleCity.Components.Sprite;
import BattleCity.GameManager;
import Engine.Entity;
import Engine.Scene;
import Engine.System;

/**
 * Created by Gref on 30.05.2016.
 */
public class FadeInSystem extends System {
    @Override
    public void update(double dt) {
        Scene gameScene = GameManager.instance.getCurrentScene();
        for (Entity e1 : gameScene.getEntities()) {

            FadeIn fadeIncomponent = e1.getComponent(FadeIn.class);
            Sprite sprite            = e1.getComponent(Sprite.class);

            if (fadeIncomponent == null ||
                    sprite       == null) continue;


            sprite.opacity = fadeIncomponent.value;
            fadeIncomponent.value += dt / fadeIncomponent.duration;

            if (fadeIncomponent.value > 1)
                sprite.opacity = 1;
        }
    }
}
