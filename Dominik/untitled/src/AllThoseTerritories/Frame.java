package AllThoseTerritories;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class Frame extends JFrame {

    public Frame (World Continents){
        this.setSize(1250,650);



        this.add(new Panel(Continents));
        JLabel _troopslabel;



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}