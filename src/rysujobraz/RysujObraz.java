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
        String path = "C:\\Users\\student\\Desktop\\";
        BufferedImage img = new BufferedImage(100, 100, TYPE_INT_RGB);

        img = line_v2(100, 100, 35, 15, img);
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

    public static BufferedImage line_v1(int x0, int y0, int x1, int y1, BufferedImage img) {
        int x, y;
        for (double t = 0; t <= 1; t += 0.01) {
            x = (int) Math.round(x0 + (x1 - x0) * t);
            y = (int) Math.round(y0 + (y1 - y0) * t);
            img.setRGB(x, y, 0xffffffff);
        }
        return img;
    }

    public static BufferedImage line_v2(int x0, int y0, int x1, int y1, BufferedImage img) {
        int diffX = x0 - x1;
        int diffY = y0 - y1;
        if (diffY > diffX) {
            for (int x = x0; x <= x1; x++) {
                double t = (x - x0) / (double) (x1 - x0);
                int y = (int) Math.round((y0 + (y1 - y0) * t));
                img.setRGB(x, y, 0xffffffff);
            }
        } else {
            for (int y = y0; y <= y1; y++) {
                double t = (y - y0) / (double) (y1 - y0);
                int x = (int) Math.round((x0 + (x1 - x0) * t));
                img.setRGB(x, y, 0xffffffff);
            }
        }
        return img;
    }

//    public static BufferedImage line_v3(int x0, int y0, int x1, int y1, BufferedImage img) {
//        double err = 0.0;
//        double derr = Math.tan(err);
//        for (int x = x0; x <= x1; x++) {
//            err += derr;
//            if (err > 0.5) {
//                y += 1;
//                err -= 1;
//            }
//        }
//        return img;
//    }
}
