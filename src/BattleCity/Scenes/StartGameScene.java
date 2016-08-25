package BattleCity.Scenes;

import BattleCity.Components.Animation.FadeOut;
import BattleCity.Components.Position;
import BattleCity.Components.Sprite;
import BattleCity.GameManager;
import BattleCity.Systems.Animation.FadeOutSystem;
import BattleCity.Systems.RenderSystem;
import Engine.Component;
import Engine.Entity;
import Engine.MathVectors.Vector2i;
import Engine.Scene;
import Engine.System;

/**
 * Created by Gref on 30.05.2016.
 */
public class StartGameScene extends Scene {

    Entity startBackGround = new Entity();

    Component sprite   = new Sprite("src/Resources/Images/start.png");
    Component position = new Position(new Vector2i(0,0));
    Component fadeOut  = new FadeOut(2);

    System renderSystem = new RenderSystem();
    System fadeOutSystem = new FadeOutSystem();

    double initianalTime = 0;


    public StartGameScene() {
        startBackGround.addComponent(sprite);
        startBackGround.addComponent(position);
        startBackGround.addComponent(fadeOut);
        GameManager.instance.audioManager.play("Resources/Audio/cena.wav");
        try {
            Thread.sleep(0000);
            this.addEntity(startBackGround);
            this.addSystem(renderSystem);
            this.addSystem(fadeOutSystem);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Double dt) {
        super.update(dt);
        initianalTime += dt;
        if (initianalTime > 2) {
            GameManager.instance.setScene(new GameScene());
            GameManager.instance.audioManager.stop("Resources/Audio/cena.wav");
        }
    }
}

