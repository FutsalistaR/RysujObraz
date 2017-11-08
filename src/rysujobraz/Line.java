/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rysujobraz;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author student
 */
public class Line {
    
    private Point start;
    private Point end;
    private List<Point> points = new ArrayList<>();

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoint(Point point) {
        this.points.add(point);
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }
    
    public BufferedImage draw(BufferedImage img) {
        int diffX = start.getX() - end.getX();
        int diffY = start.getY() - end.getY();
        if (diffY > diffX) {
            for (int x = start.getX(); x <= end.getX(); x++) {
                double t = (x - start.getX()) / (double) (end.getX() - start.getX());
                int y = (int) Math.round((start.getY() + (end.getY() - start.getY()) * t));
                img.setRGB(x, y, 0xffffffff);
                setPoint(new Point(x, y));
            }
        } else {
            for (int y = start.getY(); y <= end.getY(); y++) {
                double t = (y - start.getY()) / (double) (end.getY() - start.getY());
                int x = (int) Math.round((start.getX() + (end.getY() - start.getX()) * t));
                img.setRGB(x, y, 0xffffffff);
                setPoint(new Point(x, y));
            }
        }
        return img;
    }
    
}
