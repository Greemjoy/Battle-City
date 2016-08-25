package BattleCity.Systems;

import BattleCity.Components.Flags.Hero;
import BattleCity.Components.Health;
import BattleCity.EntitiesFactory;
import BattleCity.GameManager;
import BattleCity.GameProgress;
import BattleCity.Scenes.GameOverScene;
import Engine.Entity;
import Engine.MathVectors.Vector2i;
import Engine.Scene;
import Engine.System;
import java.util.ArrayList;

/**
 * Created by Gref on 30.05.2016.
 */
public class GameLogicSystem extends System {
    @Override
    public void update(double dt) {
        Scene gameScene = GameManager.instance.getCurrentScene();
        for (Entity entity : (ArrayList<Entity>)GameManager.instance.getCurrentScene().getEntities().clone()) {
            if (GameProgress.instance.isNoMoreEnemies()) {
                for (int i = 0; i < GameProgress.instance.numOfEnemies; i++ ) {
                    gameScene.addEntity(EntitiesFactory.createEnemy(new Vector2i(50 + i * GameProgress.OFFSET, 50)));
                }
                GameProgress.instance.numOfEnemies++;
            }
            Health health = entity.getComponent(Health.class);
            Hero   hero   = entity.getComponent(Hero.class);

            if (health == null) continue;

            if (health.value <= 0) {
                gameScene.getEntities().remove(entity);
            }

            if (health.value <= 0 && hero != null) {
                java.lang.System.out.println("GG WP");
                GameManager.instance.audioManager.play("Resources/audio/pscov.wav");
                GameManager.instance.audioManager.stop("Resources/Audio/main_theme.wav");
             //   GameManager.instance.audioManager.stop("/audio/dubstep.wav");
                GameManager.instance.setScene(new GameOverScene());
                break;
            }
        }
    }
}
