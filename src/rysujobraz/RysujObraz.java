/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rysujobraz;

import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author student
 */
public class RysujObraz {

    public static void main(String[] args) {
        //String path = "C:\\Users\\student\\Desktop\\";
    	 String path = "C:\\Users\\Wojtek\\Desktop\\";
        BufferedImage img = new BufferedImage(100, 100, TYPE_INT_RGB);
        
        Triangle triangle = new Triangle(new Point(10, 90), new Point(10, 30), new Point(95, 95));
        img = triangle.draw(img);
        //img = triangle.fill(img);
//        Line line = new Line(new Point(50, 50), new Point(50, 80));
//        line.draw(img);
        img = flip_v(img);

        File outputFile = new File(path + "image.jpg");
        try {
            ImageIO.write(img, "jpg", outputFile);
        } catch (IOException ex) {
            Logger.getLogger(RysujObraz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static BufferedImage flip_v(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage newImg = new BufferedImage(width, height, TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            int k = height - 1;
            for (int y = 0; y < height; y++, k--) {
                int rgb = img.getRGB(x, y);
                newImg.setRGB(x, k, rgb);
            }
        }
        return newImg;
    }
}
