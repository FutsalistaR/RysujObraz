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

    private void setPoint(Point point) {
        this.points.add(point);
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }
    
    public BufferedImage draw(BufferedImage img) {
        int diffX = start.getX() - end.getX();
        int diffY = start.getY() - end.getY();
        
        if (diffX >= 0) {
        	if (diffY >= 0) {
        		if (Math.abs(diffX) > Math.abs(diffY))
        			drawLeftDownX(img);
        		else
        			drawLeftDownY(img);
        	} else {
        		if (Math.abs(diffX) > Math.abs(diffY))
        			drawLeftUpX(img);
        		else
        			drawLeftUpY(img);
        	}
        } else {
        	if (diffY >= 0) {
        		if (Math.abs(diffX) > Math.abs(diffY))
        			drawRightDownX(img);
        		else
        			drawRightDownY(img);
        	} else {
        		if (Math.abs(diffX) > Math.abs(diffY))
        			drawRightUpX(img);
        		else
        			drawRightUpY(img);
        	}
        }
        
        return img;
    }
    
    public BufferedImage drawRightUpX(BufferedImage img) {
    	int y = start.getY();
    	int diffX = end.getX() - start.getX();
    	int diffY = end.getY() - start.getY();
    	double sumErr = 0.0;
    	double err = diffY/(double)diffX;
    	for (int x = start.getX(); x <= end.getX(); x++) {
    		sumErr += err;
    		if (sumErr > 0.5) {
    			sumErr -= 1.0;
    			y++;
    		}
    		img.setRGB(x, y, 0xffffffff);
    		setPoint(new Point(x, y));
    	}
    	return img;
    }
    
    public BufferedImage drawRightUpY(BufferedImage img) {
    	int x = start.getX();
    	int diffX = end.getX() - start.getX();
    	int diffY = end.getY() - start.getY();
    	double sumErr = 0.0;
    	double err = diffX/(double)diffY;
    	for (int y = start.getY(); y <= end.getY(); y++) {
    		sumErr += err;
    		if (sumErr > 0.5) {
    			sumErr -= 1.0;
    			x++;
    		}
    		img.setRGB(x, y, 0xffffffff);
    		setPoint(new Point(x, y));
    	}
    	return img;
    }
    
    public BufferedImage drawRightDownX(BufferedImage img) {
    	int y = start.getY();
    	int diffX = end.getX() - start.getX();
    	int diffY = end.getY() - start.getY();
    	double sumErr = 0.0;
    	double err = diffY/(double)diffX;
    	for (int x = start.getX(); x <= end.getX(); x++) {
    		sumErr += err;
    		if (sumErr < 0.5) {
    			sumErr += 1.0;
    			y--;
    		}
    		img.setRGB(x, y, 0xffffffff);
    		setPoint(new Point(x, y));
    	}
    	return img;
    }
    
    public BufferedImage drawRightDownY(BufferedImage img) {
    	int x = start.getX();
    	int diffX = end.getX() - start.getX();
    	int diffY = end.getY() - start.getY();
    	double sumErr = 0.0;
    	double err = diffX/(double)diffY;
    	for (int y = start.getY(); y >= end.getY(); y--) {
    		sumErr += err;
    		if (sumErr < 0.5) {
    			sumErr += 1.0;
    			x++;
    		}
    		img.setRGB(x, y, 0xffffffff);
    		setPoint(new Point(x, y));
    	}
    	return img;
    }
    
    public BufferedImage drawLeftDownY(BufferedImage img) {
    	int x = start.getX();
    	int diffX = end.getX() - start.getX();
    	int diffY = end.getY() - start.getY();
    	double sumErr = 0.0;
    	double err = diffX/(double)diffY;
    	for (int y = start.getY(); y >= end.getY(); y--) {
    		sumErr += err;
    		if (sumErr > 0.5) {
    			sumErr -= 1.0;
    			x--;
    		}
    		img.setRGB(x, y, 0xffffffff);
    		setPoint(new Point(x, y));
    	}
    	return img;
    }
    
    public BufferedImage drawLeftDownX(BufferedImage img) {
    	int y = start.getY();
    	int diffX = end.getX() - start.getX();
    	int diffY = end.getY() - start.getY();
    	double sumErr = 0.0;
    	double err = diffY/(double)diffX;
    	for (int x = start.getX(); x >= end.getX(); x--) {
    		sumErr += err;
    		if (sumErr > 0.5) {
    			sumErr -= 1.0;
    			y--;
    		}
    		img.setRGB(x, y, 0xffffffff);
    		setPoint(new Point(x, y));
    	}
    	return img;
    }
    
    public BufferedImage drawLeftUpX(BufferedImage img) {
    	int y = start.getY();
    	int diffX = end.getX() - start.getX();
    	int diffY = end.getY() - start.getY();
    	double sumErr = 0.0;
    	double err = diffY/(double)diffX;
    	for (int x = start.getX(); x >= end.getX(); x--) {
    		sumErr += err;
    		if (sumErr < 0.5) {
    			sumErr += 1.0;
    			y++;
    		}
    		img.setRGB(x, y, 0xffffffff);
    		setPoint(new Point(x, y));
    	}
    	return img;
    }
    
    public BufferedImage drawLeftUpY(BufferedImage img) {
    	int x = start.getX();
    	int diffX = end.getX() - start.getX();
    	int diffY = end.getY() - start.getY();
    	double sumErr = 0.0;
    	double err = diffX/(double)diffY;
    	for (int y = start.getY(); y <= end.getY(); y++) {
    		sumErr += err;
    		if (sumErr < 0.5) {
    			sumErr += 1.0;
    			x--;
    		}
    		if (x < 0) x = 0;
    		//System.out.println(x + " " + y);
    		img.setRGB(x, y, 0xffffffff);
    		setPoint(new Point(x, y));
    	}
    	return img;
    }

	@Override
	public String toString() {
		return "Line [start=" + start + ", end=" + end + ", points=" + points + "]";
	}
    
    
}
