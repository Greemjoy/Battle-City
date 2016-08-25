package BattleCity.Scenes;

import BattleCity.EntitiesFactory;
import BattleCity.GameManager;
import BattleCity.Systems.*;
import Engine.Entity;
import Engine.MathVectors.Vector2i;
import Engine.Scene;
import Engine.System;

/**
 * Created by Gref on 30.05.2016.
 */
public class GameScene extends Scene {

    System render          = new RenderSystem();
    System movementSystem  = new MovementSystem();
    System aisystem        = new AISystem();
    System inputSystem     = new InputSystem();
    System collisionSystem = new CollisionSystem();
    System gameLogicSystem = new GameLogicSystem();
    System cleanerSystem   = new CleanerSystem();


    public GameScene() {
//        addEnemies();
        this.addEntity(EntitiesFactory.createBackGround());

        char[][] map = new char[][]{
                "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * **".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                    *           *      *              *     *                         ".toCharArray(),
                "                    *          * *      *            *     * *                        ".toCharArray(),
                "                    *                    *          *                                 ".toCharArray(),
                "                    *        *     *      *        *     *     *                      ".toCharArray(),
                "                    *                      *      *                                   ".toCharArray(),
                "             *      *      * * * * * *      *    *     * * * * * *                    ".toCharArray(),
                "             *      *     *           *      *  *     *           *                   ".toCharArray(),
                "             * * * **    *             *      *      *             *                  ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "          * * * * * * * * *  * * * * * *  * *  * *  *  *  *  * *                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "                                                                                      ".toCharArray(),
                "* * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *  *".toCharArray()};

        java.lang.System.out.println(map[0].length);
       for (int i = 0; i < map.length; ++i) {
            for (int j = 0; j < map[i].length; ++j) {
                Entity wall;
                if (map[i][j] == '*') {
                    this.addEntity(EntitiesFactory.createTerrain(j, i));
                }
                if (map[i][j] == '~') {
                    this.addEntity(EntitiesFactory.createTerrain(j, i));
                }
                if (map[i][j] == '#') {continue;
                  /*  this.addEntity(EntitiesFactory.createTerrain(j, i));*/
                }
                if (map[i][j] == '@') {continue;
                    /*this.addEntity(EntitiesFactory.createTerrain(j, i));*/
                }
               /* if ((wall = EntitiesFactory.createTerrain(j, i, map[i][j])) == null) continue;
                this.addEntity(EntitiesFactory.createTerrain(j, i, map[i][j]));*/
            }
        }
        this.addEntity(EntitiesFactory.createHeroTank());


        this.addSystem(inputSystem);
        this.addSystem(aisystem);
        this.addSystem(movementSystem);
        this.addSystem(collisionSystem);
        this.addSystem(gameLogicSystem);
        this.addSystem(render);
        this.addSystem(cleanerSystem);

//        GameManager.instance.audioManager.play("audio/dubstep.wav");
        GameManager.instance.audioManager.play("Resources/Audio/main_theme.wav");
    }

    @Override
    public void update(Double dt) {
        super.update(dt);
    }

}