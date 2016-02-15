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

    public int roll_the_dice(boolean twodices)
    {
        boolean valid = false;
        int val1 = 0;
        int val2 = 0;
        while(!valid)
        {
            if(twodices)
            {
                if (val2 == 0 || val2 > 6)
                {
                    val2 = (int) Math.random() * 10;
                }
                else if(val1 == 0 || val1 > 6)
                {
                    val1 = (int)Math.random() * 10;
                }
                else
                {
                    valid = true;
                }
            }
            else
            {
                if (val1 == 0 || val1 > 6)
                {
                    val1 = (int) Math.random() * 10;
                }
                else
                {
                    valid = true;
                }
            }


        }
        return val1 + val2;
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
