package AllThoseTerritories;

import java.util.Random;

/**
 * Created by Dominik on 29.01.2016.
 */
public class Player
{
    private String _name;
    private int _Figures = 0;
    public Player(String Name,int Figures)
    {
        _name = Name;
        _Figures = Figures;
    }

    public int roll_the_dice()
    {
        boolean valid = false;
        int val1 = 0;
        int val2 = 0;
        while(!valid)
        {
            if(val1 == 0 || val1 > 6)
            {
                val1 = (int)Math.random() * 10;
            }
            else if(val2 == 0 || val2 > 6)
            {
                val2 = (int)Math.random() * 10;
            }
            else
            {
                valid = true;
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


}
