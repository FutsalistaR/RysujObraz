package rysujobraz;

import java.awt.image.BufferedImage;

public class Box {
	
	private Point a;
	private Point b;
	private Point c;
	private Point d;
	
	public Box(Point a, Point b, Point c) {
		int maxX = Math.max(a.getX(), Math.max(b.getX(), c.getX()));
		int minX = Math.min(a.getX(), Math.min(b.getX(), c.getX()));
		int maxY = Math.max(a.getY(), Math.max(b.getY(), c.getY()));
		int minY = Math.min(a.getY(), Math.min(b.getY(), c.getY()));
		
		this.a = new Point(minX, minY);
		this.b = new Point(maxX, minY);
		this.c = new Point(maxX, maxY);
		this.d = new Point(minX, maxY);
	}
	
	public BufferedImage draw(BufferedImage img) {
		//enlargeBox(img);
		Line ab = new Line(a, b);
		Line bc = new Line(b, c);
		Line cd = new Line(c, d);
		Line da = new Line(d, a);
		
		img = ab.draw(img);
		img = bc.draw(img);
		img = cd.draw(img);
		img = da.draw(img);
		
		return img;
	}
	
	private void enlargeBox(BufferedImage img) {
		if (a.getX() > 0  && img.getWidth() - b.getX() > 2) {
			if (a.getY() > 0 && img.getHeight() - c.getY() > 2) {
				this.a = new Point(a.getX() - 2, a.getY() - 2);
				this.b = new Point(b.getX() + 2, b.getY() - 2);
				this.c = new Point(c.getX() + 2, c.getY() + 2);
				this.d = new Point(d.getX() - 2, d.getY() + 2);
			}
		}
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

	public Point getD() {
		return d;
	}

	@Override
	public String toString() {
		return "Box [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + "]";
	}

}
