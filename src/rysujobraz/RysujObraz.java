/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rysujobraz;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author student
 */
public class RysujObraz {

    public static void main(String[] args) {
        ImageCreator imageCreator = new ImageCreator(3000, 3000);
        ObjScanner scanner = new ObjScanner();
        List<Vertex> vertexList = new ArrayList<>();
		try {
			vertexList = scanner.readVertex("C:\\Users\\Wojtek\\Desktop\\deer.obj");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<F> fList = new ArrayList<>();
		try {
			fList = scanner.readF("C:\\Users\\Wojtek\\Desktop\\deer.obj");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		Point a = new Point (10, 10);
//		Point b = new Point(80, 20);
//		Point c = new Point(60, 70);
//		Triangle triangle = new Triangle(a, b, c);
//		imageCreator.drawTriangle(triangle);
		
        //imageCreator.drawDeerPoints(vertexList);
		imageCreator.drawDeerTriangles(vertexList, fList);
    }
}
