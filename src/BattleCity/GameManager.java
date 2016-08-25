package BattleCity;

import Engine.Managers.AudioManager;
import Engine.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 * Created by Gref on 29.05.2016.
 */
public class GameManager {


    public static final GameManager instance = new GameManager();
    public static final int WIDTH  = 900;
    public static final int HEIGHT = 700;
    public AudioManager audioManager = new AudioManager();

    private JFrame frame = new JFrame();
    private Graphics graphics;

    private Scene currentScene;



    private Timer timer = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameComponent.repaint();
        }
    });


    public void addKeyListener(KeyListener e) {
        gameComponent.addKeyListener(e);
    }

    GameComponent gameComponent = new GameComponent();
    public void run() {
        timer.start();
        frame.add(gameComponent);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setBackground(Color.BLACK);
    }

    private void update1(double dt) {
        currentScene.update(dt);
    }

    public Graphics getGraphics(){
        return graphics;
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public void setScene(Scene scene) {
        if (this.currentScene != null) {
            currentScene.getEntities().clear();
            currentScene.getSystems().clear();
            currentScene = null;
        }
        currentScene = scene;
    }




    private class GameComponent extends JComponent {

        public GameComponent() {
            setFocusable(true);
            requestFocus(true);
            setBackground(new Color(0,0,0));
        }

        @Override
        protected void paintComponent(Graphics g) {
            graphics = g;
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color(0,0,0));
            g2.fillRect(0, 0, GameManager.WIDTH, GameManager.HEIGHT);
            update1((timer.getDelay() / 1000.0));
        }

    }
}

