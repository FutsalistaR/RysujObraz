package rysujobraz;

import java.awt.image.BufferedImage;

public class Triangle {
	
	private Point a;
	private Point b;
	private Point c;
	private Line ab;
	private Line bc;
	private Line ca;
	private Box box;
	
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
		ab = new Line(a, b);
		bc = new Line(b, c);
		ca = new Line(c, a);
		box = new Box(a, b, c);
	}

	public Point getA() {
		return a;
	}

	public Point getB() {
		return b;
	}

	public Point getC() {
		return c;
	}
	
	public BufferedImage draw(BufferedImage img) {
		img = ab.draw(img);
		img = bc.draw(img);
		img = ca.draw(img);
		return img;
	}
	
	public BufferedImage drawFilled(BufferedImage img) {
//		img = box.draw(img);
		img = fill(img);
		return img;
	}
	
	private BufferedImage fill(BufferedImage img) {
		for (int i = box.getA().getY(); i < box.getC().getY(); i++) {
			for (int j = box.getA().getX(); j < box.getB().getX(); j++) {
				double aplha = barycentricAplha(j, i)/(double)barycentricAplha(a.getX(), a.getY());
				double beta = barycentricBeta(j, i)/(double)barycentricBeta(a.getX(), a.getY());
				double gamma = barycentricGamma(j, i)/(double)barycentricGamma(a.getX(), a.getY());
				
				if (aplha > 0 && beta > 0 && gamma > 0)
					img.setRGB(j, i, 0xffffffff);
				else
					img.setRGB(j, i, 0x00ff00);
			}
		}
		return img;
	}
	
	private int barycentricAplha(int x, int y) {
		return (a.getY() - b.getY())*x + (b.getX() - a.getX())*y + a.getX()*b.getY() - b.getX()*a.getY();
	}
	
	private int barycentricBeta(int x, int y) {
		return (b.getY() - c.getY())*x + (c.getX() - b.getX())*y + b.getX()*c.getY() - c.getX()*b.getY();
	}
	
	private int barycentricGamma(int x, int y) {
		return (c.getY() - a.getY())*x + (a.getX() - c.getX())*y + c.getX()*a.getY() - a.getX()*c.getY();
	}

	@Override
	public String toString() {
		return "Triangle [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
}
