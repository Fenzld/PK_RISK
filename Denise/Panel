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
    Player one;
    Player KI;
    Color c;
    boolean begin;
    boolean working;
    private Image backgroundImage;
    JLabel _troopslabel;
    boolean playersetfigures = false;
    private ContinentPatch selected;

    public Panel(World Continents) {
        this.setSize(1250, 650);
        this.setLayout(null);
        _Continents = Continents;
        this.addMouseListener(this);
        _curPlayers = new ArrayList<Player>();
        one = new Player("Dominik", 21, Color.blue);
        KI = new Player("KI", 21, Color.red);

        _troopslabel = new JLabel("Troops: " + one.get_Figures());
        _troopslabel.setFont(new Font("Verdana", 1, 20));
        _troopslabel.setLocation(990, 570);
        _troopslabel.setSize(250, 50);
        this.add(_troopslabel);

        c = Color.lightGray;
        begin = true;
        working = false;
        begingame();

        try {
            backgroundImage = ImageIO.read(new File("sea_bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (ContinentPatch cpatch : _Continents.get_Allcontinentpatchess()) {
            this.add(cpatch.getTroopstext());
        }


        this.validate();
        this.repaint();
    }

    public enum gamestate {
        begin, normal, end, setfigures;
    }

    private void begingame() {
        _curPlayers.add(one);
        _curPlayers.add(KI);
        _currentstate = gamestate.begin;
    }

    @Override
    protected void paintComponent(Graphics g) {

        List<String> alreadypainted = new ArrayList<String>();
        _g = g;
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(backgroundImage, 0, 0, this);
        g2.setColor(Color.BLUE);

        g2.setStroke(new BasicStroke(3));
        for (ContinentPatch p : _Continents.get_Allcontinentpatchess()) {
            g.setColor(Color.BLACK);
            g.drawPolygon(p.get_ContinentPatch());
        }

        for (Player p : _curPlayers) {

            for (ContinentPatch cpatch : _Continents.getContinentPatchesfromPlayer(p.get_name())) {
                if (!cpatch.get_hovered())
                    g.setColor(p.get_Color());
                else
                    g.setColor(Color.pink);

                alreadypainted.add(cpatch.get_Name());
                g.fillPolygon(cpatch.get_ContinentPatch().xpoints, cpatch.get_ContinentPatch().ypoints, cpatch.get_ContinentPatch().npoints);
                if (cpatch.get_ContinentPatch().xpoints[0] == 225 && cpatch.get_ContinentPatch().ypoints[0] == 39) {
                    northWest(g);
                }
                if (cpatch.get_ContinentPatch().xpoints[0] == 1096 && cpatch.get_ContinentPatch().ypoints[0] == 164) {
                    japan(g);
                }
                if (cpatch.get_ContinentPatch().xpoints[0] == 1051 && cpatch.get_ContinentPatch().ypoints[0] == 280) {
                    newGuinea(g);
                }
                if (cpatch.get_ContinentPatch().xpoints[0] == 1146 && cpatch.get_ContinentPatch().ypoints[0] == 415) {
                    easternAustralia(g);
                }
                if (cpatch.get_ContinentPatch().xpoints[0] == 550 && cpatch.get_ContinentPatch().ypoints[0] == 104) {
                    greatbritain(g);
                }
                if (cpatch.get_ContinentPatch().xpoints[0] == 104 && cpatch.get_ContinentPatch().ypoints[0] == 217) {
                    centralAmerica(g);
                }
                if (cpatch.get_ContinentPatch().xpoints[0] == 837 && cpatch.get_ContinentPatch().ypoints[0] == 196) {
                    india(g);
                }
                if (cpatch.get_ContinentPatch().xpoints[0] == 867 && cpatch.get_ContinentPatch().ypoints[0] == 154) {
                    china(g);
                }
                if (cpatch.get_ContinentPatch().xpoints[0] == 1042 && cpatch.get_ContinentPatch().ypoints[0] == 334) {
                    indonesia(g);
                }

            }
        }
        for (ContinentPatch p : _Continents.get_Allcontinentpatchess()) {
            if (!alreadypainted.contains(p.get_Name())) {
                if (!p.get_hovered())
                    g.setColor(c);
                else
                    g.setColor(c.brighter());

                g.fillPolygon(p.get_ContinentPatch().xpoints, p.get_ContinentPatch().ypoints, p.get_ContinentPatch().npoints);
                if (p.get_ContinentPatch().xpoints[0] == 225 && p.get_ContinentPatch().ypoints[0] == 39) {
                    northWest(g);
                }
                if (p.get_ContinentPatch().xpoints[0] == 1096 && p.get_ContinentPatch().ypoints[0] == 164) {
                    japan(g);
                }
                if (p.get_ContinentPatch().xpoints[0] == 1051 && p.get_ContinentPatch().ypoints[0] == 280) {
                    newGuinea(g);
                }
                if (p.get_ContinentPatch().xpoints[0] == 1146 && p.get_ContinentPatch().ypoints[0] == 415) {
                    easternAustralia(g);
                }
                if (p.get_ContinentPatch().xpoints[0] == 550 && p.get_ContinentPatch().ypoints[0] == 104) {
                    greatbritain(g);
                }
                if (p.get_ContinentPatch().xpoints[0] == 104 && p.get_ContinentPatch().ypoints[0] == 217) {
                    centralAmerica(g);
                }
                if (p.get_ContinentPatch().xpoints[0] == 837 && p.get_ContinentPatch().ypoints[0] == 196) {
                    india(g);
                }
                if (p.get_ContinentPatch().xpoints[0] == 867 && p.get_ContinentPatch().ypoints[0] == 154) {
                    china(g);
                }
                if (p.get_ContinentPatch().xpoints[0] == 1042 && p.get_ContinentPatch().ypoints[0] == 334) {
                    indonesia(g);
                }


            }
        }


    }

    @Override
    public void mouseClicked(MouseEvent a) {
        if (a.getButton() == MouseEvent.BUTTON3) {
            for (ContinentPatch tmp : _Continents.get_Allcontinentpatchess()) {
                if (tmp.get_ContinentPatch().contains(a.getX(), a.getY())) {
                    if (selected != null) {
                        switch (_Continents.Attack(selected, tmp)) {
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
        if (a.getButton() == MouseEvent.BUTTON1) {
            for (ContinentPatch tmp : _Continents.get_Allcontinentpatchess()) {
                if (tmp.get_ContinentPatch().contains(a.getX(), a.getY())) {
                    switch (_currentstate) {
                        case begin:
                            begin(tmp, one, KI);
                            break;

                        case normal:
                            selected = tmp;
                            break;
                        case end:
                            break;

                        case setfigures:
                            setfigures(tmp, one, KI);
                            break;
                    }

                }
            }
        }
        _troopslabel.setText("Troops: " + one.get_Figures());

    }

    private void NormalGame() {

    }

    private void setfigures(ContinentPatch toconqu, Player p, Player ki) {
        String Figurecount = "";
        if (toconqu.get_owner().get_name().equals(p.get_name()))
            Figurecount = JOptionPane.showInputDialog(null, toconqu.get_Name() + " troops: " + toconqu.get_figuresonpatch(), "How many figures do you want to set ?");

        if (Figurecount != "" && Figurecount != null) {
            int figureset = 0;
            try {
                figureset = Integer.parseInt(Figurecount);
                if (!_Continents.besetzen(toconqu.get_Name(), p, figureset, false))
                    JOptionPane.showMessageDialog(null, "You dont have enough troops!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid input");
            }
            if (p.get_Figures() <= 0) {
                _currentstate = gamestate.normal;
                System.out.println("current state normal");
            }
        }
        //_troopslabel.setText("Troops: " + p.get_Figures());
    }

    private void begin(ContinentPatch toconqu, Player p, Player ki) {
        boolean found = false;
        if (!_Continents.checkifallcontinentsareconquered()) {
            //Player setzt eine figur auf die gewünschte position, muss noch angepasst werden, wie viele figuren.
            if (!working) {
                if (_Continents.besetzen(toconqu.get_Name(), p, 1, true)) {
                    // _troopslabel.setText("Troops: " + one.get_Figures());
//                _g.setColor(p.get_Color());
//                _g.fillPolygon(toconqu.get_ContinentPatch().xpoints,toconqu.get_ContinentPatch().ypoints,toconqu.get_ContinentPatch().npoints);
//                paintComponent(_g);
//                validate();
                    repaint();
                    //worked
                    //System.out.println(p.get_name() + " Conquered " + toconqu.get_Name());
                    while (!found) {
                        working = true;
                        //Double tmp = Math.random() * 10;
                        //Integer rnd = tmp.intValue();
                        Random rn = new Random();
                        int rnd = rn.nextInt(_Continents.get_Allcontinentpatchess().size());
                        if (rnd < _Continents.get_Allcontinentpatchess().size()) {
                            while (!_Continents.besetzen(_Continents.get_Allcontinentpatchess().get(rnd).get_Name(), ki, 1, true)) {
                                //tmp = Math.random() * 10;
                                rnd = rn.nextInt(_Continents.get_Allcontinentpatchess().size());
                            }

                            found = true;
                        }
                    }
                    repaint();
                    working = false;
                    if (_Continents.checkifallcontinentsareconquered()) {
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
        } else {
            System.out.println("All continents conquered");
            _currentstate = gamestate.setfigures;
        }
    }

    @Override
    public void mouseExited(MouseEvent a) {
    }

    @Override
    public void mouseReleased(MouseEvent a) {
    }

    @Override
    public void mouseEntered(MouseEvent a) {


    }

    @Override
    public void mousePressed(MouseEvent a) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for (ContinentPatch tmp : _Continents.get_Allcontinentpatchess()) {
            int tmp1 = e.getX();
            int tmp2 = e.getY();
            if (tmp.get_ContinentPatch().contains(e.getX(), e.getY())) {
                tmp.set_hovered(true);
            }
        }
        this.validate();
        this.repaint();
    }


    public void japan(Graphics g) {
        int[] japanx = {1063, 1065, 1068, 1072, 1076, 1078, 1080, 1082, 1086, 1088, 1090, 1087, 1084, 1082, 1081, 1083, 1084, 1082, 1079, 1076, 1073, 1070, 1068, 1063, 1063};
        int[] japany = {124, 128, 131, 135, 138, 142, 147, 151, 154, 155, 154, 150, 145, 143, 141, 142, 142, 138, 136, 133, 130, 127, 125, 123, 124};
        g.fillPolygon(japanx, japany, japanx.length);
        int[] japanxx = {1095, 1093, 1094, 1096, 1099, 1099, 1097, 1096, 1094, 1090, 1088, 1086, 1083, 1082, 1081, 1079, 1077, 1075, 1072, 1074, 1077, 1079, 1081, 1085, 1088, 1090, 1092, 1093, 1094, 1094, 1095, 1098, 1101, 1105, 1106, 1107, 1105, 1105, 1105, 1105, 1103, 1102, 1098, 1096, 1095};
        int[] japanyy = {178, 179, 182, 186, 188, 190, 193, 195, 199, 200, 202, 203, 203, 202, 202, 204, 206, 207, 207, 209, 209, 207, 206, 206, 206, 209, 212, 213, 210, 206, 205, 205, 205, 205, 202, 200, 195, 192, 189, 188, 183, 182, 179, 178, 178};
        g.fillPolygon(japanxx, japanyy, japanxx.length);
        int[] japanxxx = {1072, 1070, 1072, 1075, 1076, 1077, 1078, 1079, 1077, 1076, 1074, 1073, 1072};
        int[] japanyyy = {210, 213, 215, 217, 220, 222, 221, 218, 215, 213, 211, 211, 210};
        g.fillPolygon(japanxxx, japanyyy, japanxxx.length);
        int[] japanxxxx = {1084, 1081, 1079, 1082, 1085, 1086, 1087, 1084};
        int[] japanyyyy = {210, 210, 214, 216, 216, 214, 212, 210};
        g.fillPolygon(japanxxxx, japanyyyy, japanxxxx.length);
    }

    public void indonesia(Graphics g) {
        int[] x = {1070, 1069, 1066, 1064, 1060, 1059, 1056, 1055, 1053, 1053, 1053, 1052, 1051, 1050, 1050, 1050, 1052, 1052, 1051, 1052, 1054, 1056, 1056, 1055, 1054, 1056, 1058, 1059, 1061, 1063, 1066, 1067, 1064, 1064, 1063, 1064, 1067, 1068, 1068, 1065, 1061, 1059, 1057, 1056, 1056, 1057, 1058, 1059, 1061, 1063, 1067, 1070, 1072, 1075, 1077, 1076, 1076, 1075};
        int[] y = {358, 359, 360, 359, 358, 358, 360, 363, 364, 368, 370, 373, 375, 376, 378, 379, 381, 383, 385, 389, 390, 387, 385, 381, 378, 375, 376, 379, 382, 384, 386, 386, 380, 377, 373, 371, 369, 369, 367, 368, 369, 369, 368, 367, 366, 364, 362, 362, 361, 361, 363, 364, 364, 363, 361, 357, 355, 355};
        g.fillPolygon(x, y, x.length);
        int[] x1 = {1083, 1076, 1075, 1070, 1069, 1068, 1066, 1071, 1073, 1074, 1076, 1079, 1081, 1082};
        int[] y1 = {403, 400, 401, 403, 404, 409, 410, 411, 409, 406, 404, 404, 404, 403};
        g.fillPolygon(x1, y1, x1.length);
        int[] x2 = {952, 953, 953, 960, 964, 966, 973, 975, 977, 979, 982, 986, 989, 992, 994, 995, 995, 994, 992, 988, 986, 982, 981, 980, 976, 973, 971, 970, 969, 964, 958, 956, 951, 951};
        int[] y2 = {339, 342, 343, 348, 353, 359, 367, 370, 375, 380, 384, 386, 389, 389, 387, 384, 382, 375, 374, 369, 367, 364, 359, 358, 356, 354, 352, 350, 348, 344, 341, 340, 339, 338};
        g.fillPolygon(x2, y2, x2.length);
        int[] x3 = {998, 993, 995, 999, 1004, 1008, 1008, 1014, 1016, 1021, 1024, 1028, 1032, 1035, 1030, 1026, 1024, 1022, 1018, 1014, 1010, 1008, 1007, 1006, 1001, 1000, 999, 996, 994};
        int[] y3 = {393, 393, 396, 397, 399, 398, 398, 400, 401, 401, 401, 403, 403, 400, 400, 398, 397, 396, 394, 395, 395, 395, 394, 393, 392, 391, 392, 392, 393};
        g.fillPolygon(x3, y3, x3.length);
        int[] x4 = {1039, 1039, 1041, 1044, 1047, 1047, 1045, 1041, 1039};
        int[] y4 = {401, 405, 405, 404, 404, 402, 401, 401, 402};
        g.fillPolygon(x4, y4, x4.length);
        int[] x5 = {1052, 1049, 1051, 1054, 1057, 1056, 1054, 1053, 1052};
        int[] y5 = {406, 407, 409, 411, 411, 409, 408, 407, 407};
        g.fillPolygon(x5, y5, x5.length);
        int[] x6 = {1055, 1053, 1055, 1059, 1060, 1063, 1064, 1062, 1059, 1055};
        int[] y6 = {401, 402, 405, 405, 403, 403, 401, 401, 401, 401};
        g.fillPolygon(x6, y6, x6.length);
    }

    public void china(Graphics g) {
        int[] x = {1048, 1046, 1044, 1045, 1048, 1050, 1049, 1051, 1051, 1051, 1048};
        int[] y = {250, 252, 256, 261, 264, 264, 260, 257, 254, 250, 249};
        g.fillPolygon(x, y, x.length);
        int[] xx = {1006, 1002, 1002, 1003, 1006, 1008, 1010, 1010, 1007};
        int[] yy = {274, 275, 278, 280, 281, 279, 276, 274, 275};
        g.fillPolygon(xx, yy, xx.length);

    }

    public void india(Graphics g) {
        int[] x = {888, 887, 886, 887, 887, 888, 889, 892, 894, 894, 894, 893, 893, 890, 889, 888};
        int[] y = {321, 323, 326, 329, 333, 335, 335, 335, 333, 332, 330, 328, 326, 323, 322, 321};
        g.fillPolygon(x, y, x.length);
    }

    public void centralAmerica(Graphics g) {
        int[] americax = {211, 218, 227, 232, 237, 241, 248, 251, 252, 248, 246, 242, 235, 234, 235, 233, 225, 224, 219, 215, 211, 212, 210, 211};
        int[] americay = {262, 259, 258, 261, 264, 266, 269, 271, 272, 273, 273, 273, 271, 271, 269, 267, 263, 262, 260, 261, 262, 263, 262, 262};
        g.fillPolygon(americax, americay, americax.length);
        int[] americaxx = {233, 233, 235, 239, 241, 238, 236, 234, 233};
        int[] americayy = {279, 281, 282, 282, 282, 279, 279, 279, 279};
        g.fillPolygon(americaxx, americayy, americaxx.length);
        int[] americaxxx = {248, 251, 253, 256, 258, 260, 263, 265, 268, 271, 273, 271, 269, 263, 258, 255, 256, 257, 253, 250, 249};
        int[] americayyy = {279, 280, 281, 280, 280, 280, 281, 281, 280, 279, 278, 275, 274, 273, 273, 274, 277, 277, 278, 279, 279};
        g.fillPolygon(americaxxx, americayyy, americaxxx.length);
        int[] americaxxxx = {278, 279, 285, 287, 283, 279, 278};
        int[] americayyyy = {279, 282, 282, 279, 279, 279, 279};
        g.fillPolygon(americaxxxx, americayyyy, americaxxxx.length);
    }

    public void greatbritain(Graphics g) {
        int[] x = {543, 532, 528, 526, 527, 528, 528, 527, 526, 527, 528, 531, 533, 536, 538, 539, 539, 541, 542, 541, 538, 536, 534};
        int[] y = {116, 118, 120, 120, 122, 123, 125, 127, 129, 131, 133, 130, 128, 128, 129, 125, 123, 120, 118, 117, 116, 116, 116};
        g.fillPolygon(x, y, y.length);
    }

    public void easternAustralia(Graphics g) {
        int[] australiax = {1111, 1111, 1111, 1109, 1109, 1111, 1116, 1119, 1121, 1122, 1123, 1123, 1121, 1116};
        int[] austrliay = {548, 552, 556, 558, 562, 562, 562, 560, 558, 555, 553, 551, 550, 551};
        g.fillPolygon(australiax, austrliay, australiax.length);
    }

    public void newGuinea(Graphics g) {
        int[] guineax = {1069, 1072, 1075, 1077, 1074, 1072, 1070};
        int[] guineay = {308, 311, 314, 314, 311, 309, 308};
        g.fillPolygon(guineax, guineay, guineax.length);
        int[] guineaxx = {1054, 1053, 1056, 1058, 1059, 1057, 1055, 1054};
        int[] guineayy = {303, 307, 309, 310, 309, 307, 304, 303};
        g.fillPolygon(guineaxx, guineayy, guineaxx.length);
        int[] guineaxxx = {1062, 1060, 1059, 1059, 1061, 1063, 1064, 1064, 1062, 1060};
        int[] guineayyy = {312, 312, 313, 316, 316, 314, 313, 311, 311, 311};
        g.fillPolygon(guineaxxx, guineayyy, guineaxxx.length);
        int[] guineax1 = {1064, 1062, 1063, 1065, 1066, 1067, 1066, 1065};
        int[] guineay1 = {317, 319, 322, 323, 321, 319, 318, 317};
        g.fillPolygon(guineax1, guineay1, guineax1.length);
        int[] guineax2 = {1068, 1070, 1071, 1073, 1072, 1072, 1070, 1069, 1069};
        int[] guineay2 = {314, 317, 319, 319, 316, 315, 314, 313, 314};
        g.fillPolygon(guineax2, guineay2, guineax2.length);
        int[] guineax3 = {1051, 1045, 1042, 1040, 1044, 1047, 1050, 1051, 1051, 1051};
        int[] guineay3 = {313, 320, 323, 326, 326, 323, 320, 318, 315, 313};
        g.fillPolygon(guineax3, guineay3, guineax3.length);
        int[] guineax4 = {1070, 1065, 1063, 1062, 1066, 1068, 1071, 1073, 1073, 1074, 1077, 1077, 1075, 1076, 1078, 1080, 1081, 1080, 1079, 1078, 1076, 1076, 1075, 1074, 1073, 1071, 1069, 1069, 1067};
        int[] guineay4 = {326, 326, 329, 329, 330, 329, 331, 334, 337, 339, 338, 335, 333, 331, 332, 334, 333, 330, 327, 323, 321, 319, 321, 323, 324, 326, 326, 326, 326};
        g.fillPolygon(guineax4, guineay4, guineax4.length);
        int[] guineax5 = {1090, 1088, 1086, 1087, 1085, 1085, 1086, 1088, 1089, 1090, 1090, 1088, 1089, 1090, 1091, 1090};
        int[] guineay5 = {353, 352, 355, 357, 360, 362, 364, 365, 364, 363, 360, 358, 357, 355, 354, 353};
        g.fillPolygon(guineax5, guineay5, guineax5.length);
        int[] guineax6 = {1088, 1087, 1090, 1093, 1095, 1098, 1093, 1090, 1088};
        int[] guineay6 = {376, 379, 379, 380, 379, 379, 377, 377, 377};
        g.fillPolygon(guineax6, guineay6, guineax6.length);
        int[] guineax7 = {1101, 1102, 1105, 1109, 1109, 1107, 1106, 1107, 1110, 1116, 1116, 1122, 1126, 1129, 1130, 1130, 1133, 1130, 1129, 1130, 1134, 1135, 1139, 1141, 1145, 1148, 1151, 1154, 1155, 1159, 1164, 1165, 1168, 1172, 1178, 1181, 1183, 1177, 1174, 1171, 1167, 1166, 1167, 1167, 1166, 1165, 1163, 1160, 1157, 1154, 1150, 1138, 1135, 1131, 1127, 1124, 1120, 1118, 1117, 1115, 1114, 1113, 1111, 1110, 1107, 1104, 1102, 1101, 1102};
        int[] guineay7 = {396, 370, 372, 374, 376, 376, 378, 380, 381, 382, 384, 385, 387, 389, 391, 395, 396, 398, 399, 401, 401, 401, 402, 404, 405, 406, 402, 399, 398, 399, 403, 405, 408, 411, 412, 413, 414, 407, 404, 401, 398, 396, 395, 392, 391, 389, 386, 385, 383, 381, 379, 374, 373, 372, 371, 374, 376, 378, 380, 377, 375, 372, 369, 367, 367, 367, 369, 369, 368};
        g.fillPolygon(guineax7, guineay7, guineax7.length);
        int[] guineax8 = {1180, 1183, 1188, 1191, 1192, 1193, 1192, 1190, 1187, 1184, 1181, 1180, 1180};
        int[] guineay8 = {376, 377, 382, 386, 386, 383, 382, 380, 378, 377, 375, 375, 376};
        g.fillPolygon(guineax8, guineay8, guineax8.length);
        int[] guineax9 = {1187, 1184, 1182, 1180, 1174, 1173, 1176, 1178, 1182, 1184, 1185, 1186, 1187, 1187, 1187};
        int[] guineay9 = {384, 385, 388, 389, 389, 390, 393, 395, 394, 392, 391, 388, 386, 385, 384};
        g.fillPolygon(guineax9, guineay9, guineax9.length);
        int[] guineax10 = {1195, 1195, 1197, 1198, 1201, 1201, 1199, 1197, 1196, 1196, 1195};
        int[] guineay10 = {388, 391, 395, 397, 397, 395, 393, 392, 390, 389, 388};
        g.fillPolygon(guineax10, guineay10, guineax10.length);
        int[] guineax11 = {1202, 1204, 1208, 1208, 1205, 1201, 1202};
        int[] guineay11 = {395, 397, 400, 397, 396, 395, 395};
        g.fillPolygon(guineax11, guineay11, guineax11.length);
        int[] guineax12 = {1210, 1210, 1213, 1214, 1214, 1212, 1210};
        int[] guineay12 = {399, 401, 403, 403, 401, 400, 399};
        g.fillPolygon(guineax12, guineay12, guineax12.length);
        int[] guineax13 = {1217, 1217, 1219, 1222, 1221, 1220, 1218, 1217};
        int[] guineay13 = {403, 405, 410, 409, 406, 404, 403, 403};
        g.fillPolygon(guineax13, guineay13, guineax13.length);
        int[] guineax14 = {1204, 1206, 1207, 1208, 1209, 1207, 1207, 1206, 1203, 1204};
        int[] guineay14 = {400, 403, 404, 406, 404, 403, 402, 400, 400, 400};
        g.fillPolygon(guineax14, guineay14, guineax14.length);
        int[] guineax15 = {1212, 1213, 1215, 1218, 1217, 1215, 1212, 1211};
        int[] guineay15 = {406, 408, 409, 410, 408, 407, 406, 406};
        g.fillPolygon(guineax15, guineay15, guineax15.length);
        int[] guineax16 = {1219, 1218, 1221, 1223, 1225, 1223, 1220, 1219};
        int[] guineay16 = {411, 413, 416, 415, 413, 412, 411, 411};
        g.fillPolygon(guineax16, guineay16, guineax16.length);
    }

    public void northWest(Graphics g) {
        int[] northwestx = {141, 99, 99, 107, 246, 255, 262, 270, 269, 271, 272, 276, 287, 283, 285, 288, 289, 292, 293, 295, 307, 312, 315, 317, 318, 316, 310, 307, 305, 303, 300, 298, 295, 295, 298, 296, 294, 292, 291, 290, 292, 291, 289, 286, 283, 280, 279, 282, 282, 282, 280, 277, 274, 272, 269, 266, 264, 266, 258, 254, 245, 242, 237, 235, 232, 230, 228, 227, 223, 214, 212, 216, 214, 208, 202, 193, 188, 186, 181, 174, 170, 162, 150, 146, 141};
        int[] northwesty = {58, 92, 95, 96, 96, 90, 87, 84, 80, 79, 80, 80, 76, 73, 71, 72, 74, 74, 72, 70, 70, 68, 64, 62, 60, 58, 58, 59, 63, 64, 65, 66, 66, 64, 61, 59, 60, 61, 59, 56, 53, 51, 50, 51, 52, 55, 56, 57, 59, 60, 62, 62, 63, 65, 67, 66, 64, 64, 65, 65, 62, 62, 63, 65, 70, 69, 65, 64, 65, 65, 63, 61, 60, 59, 57, 57, 57, 55, 55, 56, 57, 60, 60, 58, 58};
        g.fillPolygon(northwestx, northwesty, northwestx.length);
        int[] northwestxx = {267, 269, 272, 276, 275, 272, 267, 268};
        int[] northwestyy = {58, 62, 61, 59, 57, 57, 58, 58};
        g.fillPolygon(northwestxx, northwestyy, northwestxx.length);
        int[] northwestxxx = {270, 276, 276, 278, 283, 287, 289, 289, 284, 281, 279, 277, 276, 272};
        int[] northwestyyy = {45, 48, 50, 50, 48, 45, 42, 40, 40, 42, 43, 45, 45, 45};
        g.fillPolygon(northwestxxx, northwestyyy, northwestxxx.length);
        int[] northwestxxxx = {293, 297, 302, 305, 304, 300, 296, 292, 290, 291, 293};
        int[] northwestyyyy = {46, 45, 45, 43, 40, 41, 41, 42, 44, 46, 46};
        g.fillPolygon(northwestxxxx, northwestyyyy, northwestxxxx.length);
    }

    public void lines(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.LIGHT_GRAY);
        g.drawLine(0, 72, 74, 72);
        g.drawLine(215, 74, 434, 29);
        g.drawLine(227, 144, 434, 29);
        g.drawLine(287, 143, 434, 29);
        g.drawLine(434, 29, 506, 76);
        g.drawLine(138, 264, 265, 334);
        g.drawLine(356, 407, 569, 247);
        g.drawLine(569, 247, 568, 155);
        g.drawLine(569, 247, 648, 161);
        g.drawLine(648, 161, 650, 243);
        g.drawLine(648, 161, 753, 213);
        g.drawLine(506, 76, 556, 126);
        g.drawLine(506, 76, 606, 89);
        g.drawLine(606, 89, 556, 126);
        g.drawLine(606, 89, 607, 131);
        g.drawLine(606, 89, 702, 120);
        g.drawLine(556, 126, 568, 155);
        g.drawLine(556, 126, 607, 131);
        g.drawLine(705, 321, 753, 213);
        g.drawLine(705, 321, 746, 449);
        g.drawLine(746, 449, 650, 468);
        g.drawLine(1039, 473, 1129, 378);
        g.drawLine(1138, 473, 1129, 378);
        g.drawLine(1129, 378, 1031, 360);
        g.drawLine(1031, 360, 970, 278);
        g.drawLine(964, 161, 1105, 198);
        g.drawLine(1105, 198, 1076, 71);
        g.drawLine(1076, 71, 1250, 71);

    }
}
