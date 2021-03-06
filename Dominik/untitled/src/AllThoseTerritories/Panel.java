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
    JLabel _troopslabel;
    boolean playersetfigures = false;
    private ContinentPatch selected;

    public Panel(World Continents)
    {
        this.setSize(1250,650);
        this.setLayout(null);
        _Continents = Continents;
        this.addMouseListener(this);
        _curPlayers = new ArrayList<Player>();
        one = new Player("Dominik",21,Color.blue);
        KI = new Player("KI",21,Color.red);

        _troopslabel = new JLabel("Troops: " + one.get_Figures());
        _troopslabel.setFont(new Font("Verdana", 1, 20));
        _troopslabel.setLocation(990,570);
        _troopslabel.setSize(250,50);
        this.add(_troopslabel);

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

        for(ContinentPatch cpatch :_Continents.get_Allcontinentpatchess())
        {
            this.add(cpatch.getTroopstext());
        }


        this.validate();
        this.repaint();
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
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(backgroundImage, 0, 0, this);
        g2.setColor(Color.BLUE);

//Linien
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.LIGHT_GRAY);
        g2.drawLine(0,72,74,72);
        g2.drawLine(215,74,434,29);
        g.drawLine(227,144,434,29);
        g.drawLine(287,143,434,29);
        g.drawLine(434,29,506,76);
        g.drawLine(138,264,265,334);
        g.drawLine(356,407,569,247);
        g.drawLine(569,247,568,155);
        g.drawLine(569,247,648,161);
        g.drawLine(648,161,650,243);
        g.drawLine(648,161,753,213);
        g.drawLine(506,76,556,126);
        g.drawLine(506,76,606,89);
        g.drawLine(606,89,556,126);
        g.drawLine(606,89,607,131);
        g.drawLine(606,89,702,120);
        g.drawLine(556,126,568,155);
        g.drawLine(556,126,607,131);
        g.drawLine(705,321,753,213);
        g.drawLine(705,321,746,449);
        g.drawLine(746,449,650,468);
        g.drawLine(1039,473,1129,378);
        g.drawLine(1138,473,1129,378);
        g.drawLine(1129,378,1031,360);
        g.drawLine(1031,360,970,278);
        g.drawLine(964,161,1105,198);
        g.drawLine(1105,198,1076,71);
        g.drawLine(1076,71,1250,71);



        g2.setStroke(new BasicStroke(3));
        for (ContinentPatch p : _Continents.get_Allcontinentpatchess())
        {
            g.setColor(Color.BLACK);
            g.drawPolygon(p.get_ContinentPatch());
        }

        for(Player p : _curPlayers) {

            for (ContinentPatch cpatch : _Continents.getContinentPatchesfromPlayer(p.get_name()))
            {
                if(!cpatch.get_hovered())
                    g.setColor(p.get_Color());
                else
                    g.setColor(Color.pink);

                alreadypainted.add(cpatch.get_Name());
                g.fillPolygon(cpatch.get_ContinentPatch().xpoints, cpatch.get_ContinentPatch().ypoints, cpatch.get_ContinentPatch().npoints);
            }
        }
        for (ContinentPatch p : _Continents.get_Allcontinentpatchess())
        {
            if(!alreadypainted.contains(p.get_Name()))
            {
                if(!p.get_hovered())
                    g.setColor(c);
                else
                    g.setColor(c.brighter());

                g.fillPolygon(p.get_ContinentPatch().xpoints, p.get_ContinentPatch().ypoints, p.get_ContinentPatch().npoints);

            }
        }


    }

    @Override
    public void mouseClicked(MouseEvent a)
    {
        if(a.getButton() == MouseEvent.BUTTON3)
        {
            for(ContinentPatch tmp : _Continents.get_Allcontinentpatchess())
            {
                if(tmp.get_ContinentPatch().contains(a.getX(),a.getY()))
                {
                    if(selected != null)
                    {
                       switch (_Continents.Attack(selected,tmp))
                       {
                           case win:
                               System.out.println("You successfully conquered " + tmp.get_Name());
                               break;
                           case notenoughmen:
                               System.out.println("You dont have enough troops to attack!");
                               break;
                           case notallmendown:
                               System.out.println("There are still men left on " + tmp.get_Name());
                               break;
                       }
                    }
                }
            }
        }
        if(a.getButton() == MouseEvent.BUTTON1)
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
                            selected = tmp;
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
        _troopslabel.setText("Troops: " + one.get_Figures());

    }

    private void NormalGame()
    {

    }

    private void setfigures(ContinentPatch toconqu,Player p,Player ki)
    {
        String Figurecount = "";
        if(toconqu.get_owner().get_name().equals(p.get_name()))
            Figurecount = JOptionPane.showInputDialog(null, toconqu.get_Name() + " troops: " + toconqu.get_figuresonpatch(), "How many figures do you want to set ?");

        if(Figurecount != "" && Figurecount != null)
        {
            int figureset = 0;
            try
            {
                figureset = Integer.parseInt(Figurecount);
                if(!_Continents.besetzen(toconqu.get_Name(),p,figureset,false))
                    JOptionPane.showMessageDialog(null, "You dont have enough troops!");
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid input");
            }
            if(p.get_Figures() <= 0)
            {
                _currentstate = gamestate.normal;
                System.out.println("current state normal");
            }
        }
         //_troopslabel.setText("Troops: " + p.get_Figures());
    }

    private void begin(ContinentPatch toconqu,Player p,Player ki)
    {
        boolean found = false;
        if(!_Continents.checkifallcontinentsareconquered())
        {
            //Player setzt eine figur auf die gewünschte position, muss noch angepasst werden, wie viele figuren.
            if(!working)
            {
                if(_Continents.besetzen(toconqu.get_Name(),p,1,true))
                {
                    // _troopslabel.setText("Troops: " + one.get_Figures());
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
                            while(!_Continents.besetzen(_Continents.get_Allcontinentpatchess().get(rnd).get_Name(), ki, 1,true))
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
                        _Continents.handoutfigures(one);
                        _Continents.handoutfigures(KI);
                        _currentstate = gamestate.setfigures;
                        _troopslabel.setText("Troops: " + one.get_Figures());
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
    public void mouseEntered(MouseEvent a)
    {


    }
    @Override
    public void mousePressed(MouseEvent a){}
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        for(ContinentPatch tmp : _Continents.get_Allcontinentpatchess())
        {
            int tmp1 = e.getX();
            int tmp2 = e.getY();
            if (tmp.get_ContinentPatch().contains(e.getX(), e.getY()))
            {
                tmp.set_hovered(true);
            }
        }
        this.validate();
        this.repaint();
    }
}
