package AllThoseTerritories;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;


public class Panel extends JPanel implements MouseListener, MouseMotionListener {
    private List<Polygon> t;
    private Graphics _g;
    private World _Continents;
    public Panel(World Continents){
        this.setSize(1250,650);
        this.setLayout(null);
        _Continents = Continents;
        this.addMouseListener(this);


    }


    private void begingame()
    {
        Player one = new Player("Dominik",10);
        Player KI = new Player("KI",10);
    }

    @Override
    protected void paintComponent(Graphics g){
        _g = g;
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        for(ContinentPatch p : _Continents.get_Allcontinentpatchess()){
            g.drawPolygon(p.get_ContinentPatch());
        }
    }
    @Override
    public void mouseClicked(MouseEvent a){

        for(ContinentPatch tmp : _Continents.get_Allcontinentpatchess())
        {
            if(tmp.get_ContinentPatch().contains(a.getX(),a.getY()))
            {
                System.out.println("in the ContinentPatch" + tmp.get_Name());
                _g.fillPolygon(tmp.get_ContinentPatch());
            }
        }
    }
    @Override
    public void mouseExited(MouseEvent a){}
    @Override
    public void mouseReleased(MouseEvent a){}
    @Override
    public void mouseEntered(MouseEvent a){}
    @Override
    public void mousePressed(MouseEvent a){}


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e)
    {

    }
}