package BattleCity.Systems;
import BattleCity.Components.Direction;
import BattleCity.Components.Flags.Hero;
import BattleCity.Components.Position;
import BattleCity.Components.Speed;
import BattleCity.Components.Sprite;
import BattleCity.EntitiesFactory;
import BattleCity.GameManager;
import Engine.Entity;
import Engine.System;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/**
 * Created by Gref on 30.05.2016.
 */
public class InputSystem extends System implements KeyListener {

    public InputSystem() {
        GameManager.instance.addKeyListener(this);
    }

    private Queue<Integer> queue = new ConcurrentLinkedQueue<>();

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        queue.add(e.getExtendedKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        queue.add(KeyEvent.VK_STOP);
    }


    @Override
    public void update(double dt) {
        if (queue.isEmpty())
            return;

     //   if(queue.peek() == KeyEvent.VK_ESCAPE) java.lang.System.exit(0);

        for (Entity e : (ArrayList<Entity>)GameManager.instance.getCurrentScene().getEntities().clone()) {
            Speed     speed     = e.getComponent(Speed.class);
            Direction direction = e.getComponent(Direction.class);
            Position position   = e.getComponent(Position.class);
            Hero hero           = e.getComponent(Hero.class);
            Sprite sprite       = e.getComponent(Sprite.class);


            if (direction == null ||
                    hero == null ||
                    position == null) continue;

            switch (queue.peek()) {
                case KeyEvent.VK_W: {
                    direction.setDirection(Direction.UP);
                    sprite.setImage("src/Resources/Images/HTankU2.gif");
                    speed.setSpeed(2);
                    direction.setCurrent(Direction.UP);
                    break;
                }

                case KeyEvent.VK_D: {
                    direction.setDirection(Direction.RIGHT);
                    sprite.setImage("src/Resources/Images/HTankR2.gif");
                    speed.setSpeed(2);
                    direction.setCurrent(Direction.RIGHT);
                    break;
                }

                case KeyEvent.VK_A: {
                    direction.setDirection(Direction.LEFT);
                    sprite.setImage("src/Resources/Images/HTankL2.gif");
                    speed.setSpeed(2);
                    direction.setCurrent(Direction.LEFT);
                    break;
                }

                case KeyEvent.VK_S: {
                    direction.setDirection(Direction.DOWN);
                    sprite.setImage("src/Resources/Images/HTankD2.gif");
                    speed.setSpeed(2);
                    direction.setCurrent(Direction.DOWN);
                    break;
                }

                case KeyEvent.VK_STOP: {
                    direction.setDirection(Direction.STOP);
                    speed.setSpeed(0);
                    break;
                }
                case KeyEvent.VK_ENTER: {
                    GameManager.instance.getCurrentScene().addEntity(EntitiesFactory.createHeroBullet(position.value, direction));
                    GameManager.instance.audioManager.play("Resources/Audio/shot0.wav");
                    break;
                }
            }
        }
        queue.poll();
    }
}

