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
public class F implements Comparable<F> {
    
    private int a;
    private int b;
    private int c;

    public F(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    @Override
    public String toString() {
        return "F{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }

	@Override
	public int compareTo(F o) {
		int thisMax = Math.max(a, Math.max(b, c));
		int otherMax = Math.max(o.getA(), Math.max(o.getB(), o.getC()));
		if (thisMax > otherMax) return 1;
		if (thisMax == otherMax) return 0;
		else return -1;
	}
    
    
    
}
