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
		
        //imageCreator.drawDeerPoints(vertexList);
		imageCreator.drawDeerTriangles(vertexList, fList);
    }
}
