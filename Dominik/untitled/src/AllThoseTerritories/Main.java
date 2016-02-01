package AllThoseTerritories;


import java.awt.*;
import java.io.BufferedReader;
import java.util.*;
import java.util.List;
import java.io.IOException;
import java.io.FileReader;


public class Main {


    public static ContinentPatch createPoly(String s) {
        Polygon p = null;
        int[] x;
        int[] y;
        String[] temp = new String[]{};
        String nameOfPatch = "";
        String coordinatesOfPatch = "";



        temp = s.split(" ");   //immer wenn ein abstand ist wird in einen neuen index gespeichert
        for (int k = 0; k < temp.length; k++) {
            if (!temp[k].matches("\\d+")) { // schaut ob es nicht eine ziffer von 0-9 ist (also ob es text ist)
                nameOfPatch += temp[k] + " ";
            } else {
                coordinatesOfPatch += temp[k] + ";";
                String[] coords = new String[]{};
                coords = coordinatesOfPatch.split(";");
                x = new int[coords.length / 2];
                y = new int[coords.length / 2];
                for (int i = 0, j = 1, xyIndex = 0; i < coords.length - 1; i += 2, j += 2, xyIndex++) { //-1 da k einen index vorraus ist
                    x[xyIndex] = Integer.valueOf(coords[i]);
                    y[xyIndex] = Integer.valueOf(coords[j]);
                }
                p = new Polygon(x, y, x.length);
            }
        }
        return new ContinentPatch(nameOfPatch.replace("patch-of",""),new Point(0,0),p);

    }

    public static String neighbours(String s) {
       // Map<String, String> neighboursMap = new TreeMap<String, String>();
        String firstsplit = s.split(": ")[1];
        String ret = s.split(" : ")[0].split("neighbors-of")[1] + ",";
        for(String tmp : firstsplit.split(" - "))
        {
            ret += tmp + ",";
        }
        ret = ret.substring(0, ret.length()-1);
        return ret;
    }

    public static String capital(String s)
    {
        String[] work = s.split("capital-of ")[1].split(" ");
        String Cap = "";
        String x = "";
        String y = "";
        boolean first = false;
        boolean xfound = false;
        for(String a : work)
        {
            if(a.matches("\\d+"))
            {
                if(xfound)
                    y = a;
                else
                {
                    x = a;
                    xfound = true;
                }

            }
            else
            {
                if(!first)
                    Cap += " " + a;
                else
                    first = true;
            }
        }
        return Cap + "," + x + "," + y;
    }

    public static String continent(String s)
    {
        String firstsplit = s.split(" : ")[1];
        String ret = s.split(" : ")[0].split("continent")[1] + ",";
        for(String tmp : firstsplit.split(" - "))
        {
            ret += tmp + ",";
        }
        ret = ret.substring(0, ret.length()-1);
        return ret;
    }


    public static void main(String[] args) {
        String line = "";
        Polygon p = null;
        List<Polygon> polyList = new LinkedList<Polygon>();
        List<ContinentPatch> Continents = new ArrayList<ContinentPatch>();
        List<String> Neighborlist = new ArrayList<String>();
        List<String> ContinentPatches = new ArrayList<String>();
        List<String> Capitals = new ArrayList<String>();
        Map<String, String> neighboursMap = new TreeMap<String, String>();
        try {

            BufferedReader br = new BufferedReader(new FileReader("world.map"));
            while ((line = br.readLine()) != null) {
                if (line.contains("patch-of")) {
                    Continents.add(createPoly(line));
                }
                if (line.contains("neighbors-of")) {
                    Neighborlist.add(neighbours(line));
                }
                if (line.contains("capital-of")) {
                   Capitals.add(capital(line));
                }
                if (line.contains("continent")) {
                    ContinentPatches.add(continent(line));
                }
            }

            br.close();
            new Frame(new World(Continents,Neighborlist,ContinentPatches,Capitals)).setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



