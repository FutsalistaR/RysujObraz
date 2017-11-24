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
        ImageCreator imageCreator = new ImageCreator(300, 300);
        Triangle triangle = new Triangle(new Point(10, 90), new Point(10, 30), new Point(95, 95));
        //imageCreator.drawTriangle(triangle);
        //imageCreator.drawTriangleFilled(triangle);
        ObjScanner scanner = new ObjScanner();
        List<Vertex> vertexList = new ArrayList<>();
		try {
			vertexList = scanner.readVertex("C:\\Users\\Wojtek\\Desktop\\deer.obj");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        imageCreator.drawDeerPoints(vertexList);
    }
}
