package BattleCity.Components;

import Engine.Managers.ImageManager;

import java.awt.*;

/**
 * Created by Gref on 29.05.2016.
 */
public class Sprite extends Engine.Component{

    public Image image;
    public float opacity;

    public Sprite (String fileName) {
        image = ImageManager.instance.read(fileName);
        opacity = 1;
    }

    public Sprite (String fileName, float opacity) {
        this(fileName);
        this.opacity = opacity;
    }

    public void setImage(String fileName){
        image = ImageManager.instance.read(fileName);
    }

}
