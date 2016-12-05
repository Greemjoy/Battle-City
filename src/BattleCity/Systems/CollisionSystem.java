package BattleCity.Systems;

import BattleCity.Components.Collision;
import BattleCity.Components.Direction;
import BattleCity.Components.Flags.Bullet;
import BattleCity.Components.Flags.Enemy;
import BattleCity.Components.Flags.Hero;
import BattleCity.Components.Flags.Terrain;
import BattleCity.Components.Health;
import BattleCity.Components.Position;
import BattleCity.GameManager;
import Engine.Entity;
import Engine.Scene;
import Engine.System;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Gref on 30.05.2016.
 */
public class CollisionSystem extends System {

    public static final int WIDTH = 900;
    public static final int HEIGHT = 700;
  //  private ArrayList<Entity> entities = GameManager.instance.getCurrentScene().getEntities();
    @Override
    public void update(double dt) {
        Scene gameScene = GameManager.instance.getCurrentScene();

        for (Entity e1 : (CopyOnWriteArrayList<Entity>) GameManager.instance.getCurrentScene().getEntities().clone()) {

            Collision collision = e1.getComponent(Collision.class);
            Position position1 = e1.getComponent(Position.class);
            Direction direction = e1.getComponent(Direction.class);
            if (collision == null ||

                    position1 == null) continue;

            collision.rectangle.x = position1.value.x;
            collision.rectangle.y = position1.value.y;


            if (!(e1.hasComponent(Bullet.class))) {
                if (position1.value.x + 50 > WIDTH)
                    position1.value.x = WIDTH - 50;
                if (position1.value.y + 50 > HEIGHT)
                    position1.value.y = HEIGHT - 50;

                if (position1.value.x - 10 < 0)
                    position1.value.x = 0 + 10;
                if (position1.value.y - 10 < 0)
                    position1.value.y = 0 + 10;
            }


            for (Entity e2 : gameScene.getEntities()) {
                if (e1 == e2)
                    continue;


                if (e1.hasComponent(Enemy.class) &&
                        e2.hasComponent(Enemy.class))
                    continue;

                Collision collision2 = e2.getComponent(Collision.class);
                Position position2 = e2.getComponent(Position.class);
                Health health = e2.getComponent(Health.class);
                Direction direction2 = e2.getComponent(Direction.class);

                if (e1.hasComponent(Bullet.class) && e2.hasComponent(Terrain.class)) {
                    if (collision.rectangle.intersects(collision2.rectangle)) {
                        gameScene.getEntities().remove(e1);
                        gameScene.getEntities().remove(e2);
                        GameManager.instance.audioManager.play("Resources/Audio/miss1.wav");
                    }
                }

                if (e1.hasComponent(Bullet.class) && e2.hasComponent(Enemy.class)) {
                    if (collision.rectangle.intersects(collision2.rectangle)) {
                        gameScene.getEntities().remove(e1);
                        gameScene.getEntities().remove(e2);
                        GameManager.instance.audioManager.play("Resources/Audio/miss1.wav");
                    }
                }

                if (collision2 == null ||
                        position2 == null ||
                        health == null) continue;

                collision2.rectangle.x = position2.value.x;
                collision2.rectangle.y = position2.value.y;

                if (!(e1.hasComponent(Bullet.class) || (e2.hasComponent(Bullet.class)))) {

                    if (e1.hasComponent(Enemy.class) && e1.hasComponent(Enemy.class)) continue;

                    if (collision.rectangle.intersects((collision2.rectangle))) {
                        if (position2.value.y < position1.value.y) {
                            if (position2.value.y + 30 > position1.value.y)
                                position2.value.y = position1.value.y - 32;
                        }
                        if (position2.value.y > position1.value.y) {
                            if (position2.value.y - 30 < position1.value.y)
                                position2.value.y = position1.value.y + 30;
                        }
                    }
                }
                if ((e1.hasComponent(Bullet.class))) {
                    if (collision.rectangle.intersects(collision2.rectangle)) {
                        if (e1.hasComponent(Enemy.class)) {
                            gameScene.getEntities().remove(e1);
                            GameManager.instance.audioManager.play("Resources/Audio/bExplo.wav");
                        }
                        GameManager.instance.audioManager.play("Resources/Audio/explo.wav");
                        health.value -= 1;
                        break;
                    }
                }

            }
        }
    }
}
