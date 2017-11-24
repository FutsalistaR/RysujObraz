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
import java.util.List;
import javax.imageio.ImageIO;

public class ImageCreator {
    
    private BufferedImage img;
    private final String DEER_FILE_NAME = "deer.jpg";
    private final String TRIANGLE_FILE_NAME = "triangle.jpg";
    private final String PATH = "C:\\Users\\Wojtek\\Desktop\\";
    //private final String PATH = "C:\\Users\\student\\Desktop\\";

    public ImageCreator(int width, int height) {
        this.img = new BufferedImage(width, height, TYPE_INT_RGB);
    }
    
    public void drawDeerPoints(List<Vertex> vertexList) {
        createDeerPoints(vertexList);
        flip_v();
        save(PATH, DEER_FILE_NAME);
    }
    
    public void drawTriangle(Triangle triangle) {
    	triangle.draw(img);
    	flip_v();
    	save(PATH, TRIANGLE_FILE_NAME);
    }
    
    public void drawTriangleFilled(Triangle triangle) {
    	triangle.drawFilled(img);
    	flip_v();
    	save(PATH, TRIANGLE_FILE_NAME);
    }
    
    private void createDeerPoints(List<Vertex> vertexList) {
    	for (int i = 0; i < vertexList.size(); i++) {
            int x = (int)Math.round(vertexList.get(i).getX()*100.0) + 100;
            int y = (int)Math.round(vertexList.get(i).getY()*100.0) + 100;
            img.setRGB(x, y, 0x00ff00);
        }
    }
    
    private void save(String path, String fileName) {
        File outputFile = new File(path + fileName);
        try {
            ImageIO.write(img, "jpg", outputFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void flip_v() {
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
        img = newImg;
    }
    
    
    
}
