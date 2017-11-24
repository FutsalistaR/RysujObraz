/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rysujobraz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author student
 */
public class ObjScanner {
    
    public List<Vertex> readVertex(String path) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        List<Vertex> vertex = new ArrayList<>();
        try {
            String line = br.readLine();
            while (line != null) {
                if (line.startsWith("v") && line.charAt(1) == ' ') {
                    vertex.add(getVertex(line));
                }
                
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        return vertex;
    }
    
    public List<F> readF(String path) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        List<F> f = new ArrayList<>();
        try {
            String line = br.readLine();
            while (line != null) {
                if (line.startsWith("f")) {
                    f.add(getF(line));
                }
                
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        return f;
    }
    
    private Vertex getVertex(String line) {
        String[] tab = line.split(" ");
        return new Vertex(Double.parseDouble(tab[1]), Double.parseDouble(tab[2]), Double.parseDouble(tab[3]));
    }

    private F getF(String line) {
        String[] slashTab = line.split(" ");
        String[] tab = new String[3];
        for (int i = 1; i < slashTab.length; i++) {
            tab[i-1] = slashTab[i].split("/")[0];
        }
        return new F(Integer.parseInt(tab[0]), Integer.parseInt(tab[1]), Integer.parseInt(tab[2]));
    }
    
}
