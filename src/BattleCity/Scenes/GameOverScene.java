package BattleCity.Scenes;

import BattleCity.Components.Animation.FadeIn;
import BattleCity.Components.Position;
import BattleCity.Components.Sprite;
import BattleCity.GameManager;
import BattleCity.GameProgress;
import BattleCity.Systems.Animation.FadeInSystem;
import BattleCity.Systems.RenderSystem;
import Engine.Component;
import Engine.Entity;
import Engine.MathVectors.Vector2i;
import Engine.Scene;
import Engine.System;

/**
 * Created by Gref on 30.05.2016.
 */
public class GameOverScene extends Scene {

    Entity gameOverBackGround1 = new Entity();
    Entity gameOverBackGround2 = new Entity();

    Component sprite   = new Sprite("src/Resources/Images/gg.png", 0);
    Component position = new Position(new Vector2i(0,0));
    Component fadeIn   = new FadeIn(5);

    Component sprite2   = new Sprite("src/Resources/Images/doge wow.png", 0);
    Component position2 = new Position(new Vector2i(0,0));
    Component fadeIn2   = new FadeIn(25);

    System renderSystem  = new RenderSystem();
    System fadeInSystem  = new FadeInSystem();

    double initianalTime = 0;


    public GameOverScene() {
        gameOverBackGround1.addComponent(sprite);
        gameOverBackGround1.addComponent(position);
        gameOverBackGround1.addComponent(fadeIn);

        gameOverBackGround2.addComponent(sprite2);
        gameOverBackGround2.addComponent(position2);
        gameOverBackGround2.addComponent(fadeIn2);

        this.addEntity(gameOverBackGround1);
        this.addEntity(gameOverBackGround2);
        this.addSystem(renderSystem);
        this.addSystem(fadeInSystem);
//        GameManager.instance.audioManager.play("audio/sandstorm.wav");
    }

    @Override
    public void update(Double dt) {
        super.update(dt);
        initianalTime += dt;
        if (initianalTime > 10) {
            GameManager.instance.audioManager.stop("Resources/audio/pscov.wav");
            GameScene gameScene = new GameScene();
            GameProgress.instance.resetValues();
            GameManager.instance.setScene(gameScene);
        }
    }
}

