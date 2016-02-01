

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;

import java.util.List;
import java.util.ArrayList;

public class Board extends JPanel implements MouseListener {

    private List<Object2D> objects;

//    Board() {
//        super();
//        objects = new ArrayList<Object2D>();
//        this.setPreferredSize(new Dimension(1250,650));
//
//        addMouseListener(this);
//        setBackground(Color.WHITE);
//
//    }
//
//    public void mouseClicked(MouseEvent me) {
//        int x = 10;
//        for (Object2D o : objects) {
//            Point p = me.getPoint();
//            if (p.x >=  x && p.x <= (x + 40) &&
//                p.y >= 10 && p.y <= (10 + 40)) {
//                o.changeColor();
//            }
//            x += 40 + 10;
//        }
//
//        repaint();
//    }
//
//    public void mousePressed(MouseEvent me) {}
//    public void mouseReleased(MouseEvent me) {}
//    public void mouseEntered(MouseEvent me) {}
//    public void mouseExited(MouseEvent me) {}
//
//
//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        drawObjects((Graphics2D)g);
//    }
//
//    private void drawObjects(Graphics2D g2) {
//        int x = 10;
//        int y = 10;
//        for (Object2D o : objects) {
//            o.draw(g2, new Point(x, y));
//            x += 40 + 10;
//        }
//    }
//
//    public static boolean isNumeric(String str)
//    {
//        try
//        {
//            double d = Double.parseDouble(str);
//        }
//        catch(NumberFormatException nfe)
//        {
//            return false;
//        }
//        return true;
//    }
//
//    public void readObjectString(String path)
//    {
//        objects.clear();
//        FileInputStream fis = null;
//        BufferedReader reader = null;
//        String ret ="";
//
//        try {
//            fis = new FileInputStream(path);
//            reader = new BufferedReader(new InputStreamReader(fis));
//
//            System.out.println("Reading File line by line using BufferedReader");
//
//            String line = reader.readLine();
//           // while(line != null){
//            List<String> outp = new ArrayList<String>();
//            for(int i = 0; i < 8; i++)
//            {
//                outp.add(line);
//                line = reader.readLine();
//            }
//            int counter = 0;
//            for(String tm : outp) {
//                String[] temp = tm.split(" ");
//                for (String a : temp) {
//                    if (isNumeric(a)) {
//                        ret += " " + a;
//                    }
//                }
//
//            }
//
//
//        }
//        catch (FileNotFoundException ex) {
//        }
//        catch(Exception e)
//        {
//        }
//        finally {
//            try {
//                reader.close();
//                fis.close();
//            } catch (IOException ex) {
//            }
//        }
//
//        objects.add(new Country(ret));
//
//
//        /*setPreferredSize(new Dimension(10 +  objects.size() * 40
//                                          + (objects.size() - 1) * 10 + 10,
//                                       10 + 40 + 10));
//                                       */
//    }

    public void addObject(Object2D o) {
        objects.add(o);
    }

    public void addObject(int i) {
        objects.add(objects.get(i));
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
