/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rysujobraz;

/**
 *
 * @author student
 */
public class Point {
    
    private int x;
    private int y;
    private int z;
    
	public Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}	
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getZ() {
		return z;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

    
    
}
