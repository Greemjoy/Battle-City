package BattleCity;

import BattleCity.Components.Flags.*;
import Engine.Component;
import Engine.Entity;
import BattleCity.Components.*;
import Engine.MathVectors.Vector2i;

import java.util.HashMap;

/**
 * Created by Gref on 29.05.2016.
 */
public class EntitiesFactory {
/*   private static final HashMap<String, Entity> terrainHashMapMap = new HashMap<>();*/
    public static Entity createEnemy(Vector2i p) {
        Entity enemy         = new Entity();

        Component sprite     = new Sprite("src/Resources/Images/HtankD.gif");
        Component position   = new Position(p);
        Component speed      = new Speed(2);
        Component direction  = new Direction(Direction.DOWN);
        Component ai         = new AI();
        Component collision  = new Collision(50,50);
        Component health = new Health(1);
        Component cenemy = new Enemy();

        enemy.addComponent(sprite);
        enemy.addComponent(position);
        enemy.addComponent(speed);
        enemy.addComponent(direction);
        enemy.addComponent(ai);
        enemy.addComponent(collision);
        enemy.addComponent(health);
        enemy.addComponent(cenemy);

        return enemy;
    }

/*    public static Entity getTerrain(String type){
        Entity terrain =  terrainHashMapMap.get(type);
        if(terrain == null){
            terrain = new Terrain(type);
            terrainHashMapMap.put(type,terrain);
        }
        return terrain;
    }*/

    public static Entity createTerrain(int x, int y){

/*            Entity terrain =  terrainHashMapMap.get(type);
            if(terrain == null){
                terrain = new Terrain(type);
                terrainHashMapMap.put(type,terrain);
            }*/

        Entity landscape      = new Entity();

        Component sprite          = new Sprite("src/Resources/Images/commonWall.gif");
        Component position        = new Position(new Vector2i( x*10, y*10));
        Component collision       = new Collision(50,50);
        Component terrain         = new Terrain();

        landscape.addComponent(sprite);
        landscape.addComponent(position);
        landscape.addComponent(collision);
        landscape.addComponent(terrain);

        return landscape;
    }

    public static Entity createHeroTank() {
        Entity spaceShip     = new Entity();

        Component sprite     = new Sprite("src/Resources/Images/HtankU2.gif");
        Component position   = new Position(new Vector2i(GameManager.WIDTH / 2, GameManager.HEIGHT / 2 + 200));
        Component speed      = new Speed(2);
        Component direction  = new Direction(Direction.STOP);
       // Component kdirection = new Direction(Direction.STOP);
        Component hero       = new Hero();
        Component collision  = new Collision(50, 50);
        Health helth = new Health(3);

        spaceShip.addComponent(sprite);
        spaceShip.addComponent(position);
        spaceShip.addComponent(speed);
        spaceShip.addComponent(direction);
        spaceShip.addComponent(hero);
        spaceShip.addComponent(collision);
        spaceShip.addComponent(helth);

        return spaceShip;
    }

    public static Entity createBackGround() {
        Entity backGround = new Entity();

        Component sprite   = new Sprite("ssrc/Resources/Images/background.png");
        Component position = new Position(new Vector2i(0,0));

        backGround.addComponent(sprite);
        backGround.addComponent(position);

        return backGround;
    }

    public static Entity createHeroBullet(Vector2i p, Direction d) {
        Entity HeroBullet = new Entity();
        Component sprite = new Sprite("src/Resources/Images/bulletD.gif");;

        if(d.getCurrentDirection() == Direction.DOWN) sprite = new Sprite("src/Resources/Images/beam.png");
        if(d.getCurrentDirection() == Direction.UP) sprite = new Sprite("src/Resources/Images/beam.png");
        if(d.getCurrentDirection() == Direction.LEFT) sprite = new Sprite("src/Resources/Images/beamL.png");
        if(d.getCurrentDirection() == Direction.RIGHT) sprite = new Sprite("src/Resources/Images/beamL.png");

        Vector2i pos = new Vector2i(p);
        pos.add(-1, -1);
        Component position  = new Position(pos);
        Component speed     = new Speed(5);
        Component direction = new Direction(d.getCurrentDirection());
        Component bullet    = new Bullet();
        Component colision  = new Collision(1, 1);

        HeroBullet.addComponent(sprite);
        HeroBullet.addComponent(position);
        HeroBullet.addComponent(speed);
        HeroBullet.addComponent(direction);
        HeroBullet.addComponent(bullet);
        HeroBullet.addComponent(colision);

        return HeroBullet;
    }

    public static Entity createEnemyBullet(Vector2i p, Direction d) {
        Entity enemyBullet = new Entity();

        Component sprite    = new Sprite("src/Resources/Images/enemyBeam.png");
        Component position  = new Position(p);
        Component speed     = new Speed(5);
        Component direction = new Direction(d.getCurrentDirection());
        Component bullet    = new Bullet();
        Component colision  = new Collision(10, 10);
        Component enemy     = new Enemy();

        enemyBullet.addComponent(sprite);
        enemyBullet.addComponent(position);
        enemyBullet.addComponent(speed);
        enemyBullet.addComponent(direction);
        enemyBullet.addComponent(bullet);
        enemyBullet.addComponent(colision);
        enemyBullet.addComponent(enemy);

        return enemyBullet;
    }



}