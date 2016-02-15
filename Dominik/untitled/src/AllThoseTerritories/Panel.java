package AllThoseTerritories;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.*;
import java.io.*;


public class Panel extends JPanel implements MouseListener, MouseMotionListener {
    private List<Polygon> t;
    private Graphics _g;
    private World _Continents;
    private gamestate _currentstate;
    private List<Player> _curPlayers;
    Player one ;
    Player KI ;
    Color c;
    boolean begin;
    boolean working;
    private Image backgroundImage;
    public Panel(World Continents)
    {
        this.setSize(1250,650);
        this.setLayout(null);
        _Continents = Continents;
        this.addMouseListener(this);
        _curPlayers = new ArrayList<Player>();
        one = new Player("Dominik",22,Color.blue);
        KI = new Player("KI",22,Color.red);
        c = Color.lightGray;
        begin = true;
        working = false;
        begingame();

        try {
            backgroundImage = ImageIO.read(new File("sea_bg.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public enum gamestate
    {
        begin,normal,end,setfigures;
    }

    private void begingame()
    {
        _curPlayers.add(one);
        _curPlayers.add(KI);
        _currentstate = gamestate.begin;
    }

    @Override
    protected void paintComponent(Graphics g){

        List<String> alreadypainted = new ArrayList<String>();
        _g = g;
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
        g.setColor(Color.BLUE);
            for (ContinentPatch p : _Continents.get_Allcontinentpatchess())
            {
                g.setColor(Color.BLACK);
                g.drawPolygon(p.get_ContinentPatch());
            }

            for(Player p : _curPlayers) {
                g.setColor(p.get_Color());
                for (ContinentPatch cpatch : _Continents.getContinentPatchesfromPlayer(p.get_name())) {
                    alreadypainted.add(cpatch.get_Name());
                    g.fillPolygon(cpatch.get_ContinentPatch().xpoints, cpatch.get_ContinentPatch().ypoints, cpatch.get_ContinentPatch().npoints);
                }
            }
        for (ContinentPatch p : _Continents.get_Allcontinentpatchess())
        {
            if(!alreadypainted.contains(p.get_Name()))
            {
                g.setColor(c);
                g.fillPolygon(p.get_ContinentPatch().xpoints, p.get_ContinentPatch().ypoints, p.get_ContinentPatch().npoints);

            }
        }


    }

    @Override
    public void mouseClicked(MouseEvent a)
    {
        for(ContinentPatch tmp : _Continents.get_Allcontinentpatchess())
        {
            if(tmp.get_ContinentPatch().contains(a.getX(),a.getY()))
            {
                switch (_currentstate)
                {
                    case begin:
                        begin(tmp,one,KI);
                        break;

                    case normal:

                        break;
                    case end:
                        break;

                    case setfigures:
                        setfigures(tmp,one,KI);
                        break;
                }

            }
        }
    }

    private void setfigures(ContinentPatch toconqu,Player p,Player ki)
    {
        _Continents.handoutfigures(p);
        _Continents.handoutfigures(ki);

    }

    private void begin(ContinentPatch toconqu,Player p,Player ki)
    {
        boolean found = false;
        if(!_Continents.checkifallcontinentsareconquered())
        {
            //Player setzt eine figur auf die gewŁnschte position, muss noch angepasst werden, wie viele figuren.
            if(!working)
            {
                if(_Continents.besetzen(toconqu.get_Name(),p,1))
                {
//                _g.setColor(p.get_Color());
//                _g.fillPolygon(toconqu.get_ContinentPatch().xpoints,toconqu.get_ContinentPatch().ypoints,toconqu.get_ContinentPatch().npoints);
//                paintComponent(_g);
//                validate();
                    repaint();
                    //worked
                    //System.out.println(p.get_name() + " Conquered " + toconqu.get_Name());
                    while(!found)
                    {
                        working = true;
                        //Double tmp = Math.random() * 10;
                        //Integer rnd = tmp.intValue();
                        Random rn = new Random();
                        int rnd = rn.nextInt(_Continents.get_Allcontinentpatchess().size());
                        if(rnd < _Continents.get_Allcontinentpatchess().size())
                        {
                            while(!_Continents.besetzen(_Continents.get_Allcontinentpatchess().get(rnd).get_Name(), ki, 1))
                            {
                                //tmp = Math.random() * 10;
                                rnd = rn.nextInt(_Continents.get_Allcontinentpatchess().size());
                            }

                            found = true;
                        }
                    }
                    repaint();
                    working = false;
                    if(_Continents.checkifallcontinentsareconquered())
                    {
                        System.out.println("All continents conquered");
                        _currentstate = gamestate.setfigures;
                    }

                }
            }

            //else
                //System.out.println("Select another continentpatch, this one is already owned.");
        }
        else
        {
            System.out.println("All continents conquered");
            _currentstate = gamestate.setfigures;
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