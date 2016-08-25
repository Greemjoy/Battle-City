package BattleCity.Systems;

import BattleCity.GameManager;
import Engine.Entity;
import Engine.System;
import BattleCity.Components.Position;
import BattleCity.Components.Sprite;

import java.awt.*;

/**
 * Created by Gref on 30.05.2016.
 */
public class RenderSystem extends System {

    @Override
    public void update(double dt) {

        for (Entity e : GameManager.instance.getCurrentScene().getEntities()) {

            Sprite   g = e.getComponent(Sprite.class);
            Position p = e.getComponent(Position.class);

            if (g == null || p == null) continue;


            Graphics2D g2 = (Graphics2D) GameManager.instance.getGraphics();
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, g.opacity));
            g2.drawImage(g.image, p.value.x, p.value.y, null);
        }
    }
}
