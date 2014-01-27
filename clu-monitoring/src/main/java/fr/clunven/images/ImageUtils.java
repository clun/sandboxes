package fr.clunven.images;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;


public class ImageUtils {

    private  URL url = null;

    public  BufferedImage resize() {
        try {
                url = getClass().getResource("/images/image.jpeg");
                BufferedImage originalImage = ImageIO.read(url);
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

                int screenWidth = (int) dim.getWidth();
                int screenHeight = (int) dim.getHeight();

                int w = originalImage.getWidth();
                int h = originalImage.getHeight();
                BufferedImage dimg = dimg = new BufferedImage(screenWidth, screenHeight, originalImage.getType());
                Graphics2D g = dimg.createGraphics();
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g.drawImage(originalImage, 0, 0, screenWidth, screenHeight, 0, 0, w, h, null);
                g.dispose();

                return dimg;
        }catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
