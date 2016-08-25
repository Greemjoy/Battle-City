package Engine.Managers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Gref on 29.05.2016.
 */
    public class ImageManager {
        private HashMap<String, java.awt.Image> images = new HashMap();
        public static ImageManager instance = new ImageManager();
        public java.awt.Image read(String path) {
            java.awt.Image image = this.images.get(path);
            if (image == null) {
                try {
                    image = ImageIO.read(new File(path));
                } catch (IOException ex) {}
                this.images.put(path, image);
            }
            return image;
        }
    }

