package BattleCity.Systems;

import BattleCity.Components.Collision;
import BattleCity.Components.Flags.AI;
import BattleCity.Components.Direction;
import BattleCity.Components.Flags.Bullet;
import BattleCity.Components.Flags.Enemy;
import BattleCity.Components.Flags.Hero;
import BattleCity.Components.Position;
import BattleCity.Components.Sprite;
import BattleCity.EntitiesFactory;
import BattleCity.GameManager;
import Engine.Entity;
import Engine.MathVectors.Vector2i;
import Engine.Scene;
import Engine.System;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Gref on 30.05.2016.
 */
public class AISystem extends System {

    private Random random = new Random();
    private Vector2i eggPosition = new Vector2i();
    private int offsetFromEnemy = 50;
   // int x = 120;


    int rate = 1;
    Random r = new Random();
    int step = r.nextInt(100) + 100;



    @Override
    public void update(double dt) {
        Scene gameScene = GameManager.instance.getCurrentScene();
        for (Entity e : (CopyOnWriteArrayList<Entity>)GameManager.instance.getCurrentScene().getEntities().clone()) {

            if(!(e.hasComponent(Enemy.class)))continue;
            if(e.hasComponent(Bullet.class))continue;
            Position position   = e.getComponent(Position.class);
            AI ai               = e.getComponent(AI.class);
            Direction direction = e.getComponent(Direction.class);
            Sprite sprite       = e.getComponent(Sprite.class);

            if(e.hasComponent(Hero.class))continue;

            if (position  == null ||
                    direction == null) continue;

            for (Entity e2 : gameScene.getEntities()) {
                if (e == e2)
                    continue;
                Position heroPosition = e2.getComponent(Position.class);
                Collision heroCollision = e2.getComponent(Collision.class);

                if (e2.hasComponent(Hero.class)) {
                    if (step == 0) {
                        step = r.nextInt(12) + 3;
                        int mod = r.nextInt(9);
                        if (playerTankAround(position, heroCollision)) {
                            if (position.value.x == heroPosition.value.x) {
                                if (position.value.y > heroPosition.value.y) {
                                    direction.setDirection(Direction.UP);
                                    direction.setCurrent(Direction.UP);
                                    sprite.setImage("src/Resources/Images/HtankU.gif");

                                } else if (position.value.y < heroPosition.value.y) {
                                    direction.setDirection(Direction.DOWN);
                                    direction.setCurrent(Direction.DOWN);
                                    sprite.setImage("src/Resources/Images/HtankD.gif");
                                }
                            } else if (position.value.y == heroPosition.value.y) {
                                if (position.value.x > heroPosition.value.x) {
                                    direction.setDirection(Direction.LEFT);
                                    direction.setCurrent(Direction.LEFT);
                                    sprite.setImage("src/Resources/Images/HtankL.gif");
                                } else if (position.value.x < heroPosition.value.x) {
                                    direction.setCurrent(Direction.RIGHT);
                                    direction.setDirection(Direction.RIGHT);
                                    sprite.setImage("src/Resources/Images/HtankR.gif");
                                }
                            } else {
                                int rn = r.nextInt(4);
                        //        direction = directons[rn];
                                if(rn == 0){
                                    direction.setCurrent(Direction.LEFT);
                                    direction.setDirection(Direction.LEFT);
                                    sprite.setImage("src/Resources/Images/HtankL.gif");
                                }
                                if(rn == 1){
                                    direction.setCurrent(Direction.UP);
                                    direction.setDirection(Direction.UP);
                                    sprite.setImage("src/Resources/Images/HtankU.gif");
                                }
                                if(rn == 2){
                                    direction.setCurrent(Direction.RIGHT);
                                    direction.setDirection(Direction.RIGHT);
                                    sprite.setImage("src/Resources/Images/HtankR.gif");
                                }
                                if(rn == 3){
                                    direction.setCurrent(Direction.DOWN);
                                    direction.setDirection(Direction.DOWN);
                                    sprite.setImage("src/Resources/Images/HtankU.gif");
                                }
                                if(rn == 4){
                                    direction.setCurrent(Direction.STOP);
                                    direction.setDirection(Direction.STOP);
                                }
                            }
                            rate = 2;
                        } else if (mod == 1) {
                            rate = 1;
                        } else if (1 < mod && mod <= 3) {
                            rate = 1;
                        } else {
                            int rn = r.nextInt(4);
                            //        direction = directons[rn];
                            if(rn == 0){
                                direction.setCurrent(Direction.LEFT);
                                direction.setDirection(Direction.LEFT);
                                sprite.setImage("src/Resources/Images/HtankL.gif");
                            }
                            if(rn == 1){
                                direction.setCurrent(Direction.UP);
                                direction.setDirection(Direction.UP);
                                sprite.setImage("src/Resources/Images/HtankU.gif");
                            }
                            if(rn == 2){
                                direction.setCurrent(Direction.RIGHT);
                                direction.setDirection(Direction.RIGHT);
                                sprite.setImage("src/Resources/Images/HtankR.gif");
                            }
                            if(rn == 3){
                                direction.setCurrent(Direction.DOWN);
                                direction.setDirection(Direction.DOWN);
                                sprite.setImage("src/Resources/Images/HtankD.gif");
                            }
                            if(rn == 4){
                                direction.setCurrent(Direction.STOP);
                                direction.setDirection(Direction.STOP);
                            }
                            rate = 1;
                        }
                    }
                    step--;
                    if (rate == 2) {
                        if (r.nextInt(40) > 35)
                            gameScene.addEntity(EntitiesFactory.createEnemyBullet(position.value, direction));
                    } else if (r.nextInt(40) > 38)
                        gameScene.addEntity(EntitiesFactory.createEnemyBullet(position.value, direction));
                }
            }
        }
    }
    public  boolean playerTankAround(Position position, Collision heroCollision){
        int rx=position.value.x-15,ry=position.value.y-15;
        if((rx=position.value.x-15)<0) rx=0;
        if((ry=position.value.y-15)<0)ry=0;
        Rectangle a=new Rectangle(rx, ry,60,60);
        if (a.intersects(heroCollision.rectangle)) {
            return true;
        }
        return false;
    }
}

