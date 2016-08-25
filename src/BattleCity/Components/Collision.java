package BattleCity.Components;

import Engine.Component;

import java.awt.*;

/**
 * Created by Gref on 29.05.2016.
 */
public class Collision extends Component {
    public Rectangle rectangle = new Rectangle();


    public Collision(int width, int height) {
        rectangle.width = width;
        rectangle.height = height;
    }
}
