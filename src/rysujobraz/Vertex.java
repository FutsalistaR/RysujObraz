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
public class Vertex {
    
    private float x;
    private float y;
    private float z;
    
	public Vertex(float x, float y, float z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getZ() {
		return z;
	}
	
	@Override
	public String toString() {
		return "Vertex [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
}
