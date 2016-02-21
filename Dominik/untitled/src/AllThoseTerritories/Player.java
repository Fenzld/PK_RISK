package AllThoseTerritories;

import java.awt.*;
import java.util.Random;

/**
 * Created by Dominik on 29.01.2016.
 */
public class Player
{
    private String _name;
    private int _Figures = 0;
    private Color _Color;
    public Player(String Name,int Figures,Color c)
    {
        _name = Name;
        _Figures = Figures;
        _Color = c;
    }

    public void reducefigures(int count)
    {
        _Figures -= count;
    }

    public int[] roll_the_dice(int availabletroops)
    {

        if(availabletroops > 3)
            availabletroops = 3;
        else if (availabletroops > 2)
        {
            availabletroops = 2;
        }
        else if(availabletroops > 1)
        {
            availabletroops = 1;
        }
        else
            availabletroops = 0;

        int[] retdices = new int[availabletroops];
        Random rn = new Random();
        for(int i = 0; i < availabletroops-1;i++)
        {
            retdices[i] =  rn.nextInt(5) + 1;
        }
        return retdices;
    }

    public String get_name()
    {
        return _name;
    }
    public int get_Figures()
    {
        return _Figures;
    }

    public void add_figures(int value)
    {
        _Figures += value;
    }

    public Color get_Color()
    {
        return _Color;
    }


}
