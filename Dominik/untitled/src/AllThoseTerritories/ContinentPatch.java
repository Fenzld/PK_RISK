package AllThoseTerritories;

import com.sun.javafx.scene.control.behavior.CellBehaviorBase;

import javax.swing.*;
import java.awt.*;
import java.security.acl.Owner;
import java.util.*;
import java.util.List;

public class ContinentPatch
{
    String _Name;
    Point _Capital;
    List<ContinentPatch> _Neighbors;
    Polygon _Continentmap;
    private Player _owner;
    private int _figuresonpatch = 0;
    private boolean _hovered = false;
    JLabel troopstext;

    public ContinentPatch(String Name, Point Capital, Polygon ContinentonMap)
    {
        _Neighbors = new ArrayList<ContinentPatch>();
        _Name = Name;
        _Capital = Capital;
        _Continentmap = ContinentonMap;
        _owner = null;
        troopstext = new JLabel();
        troopstext.setLocation(Capital.x,_Capital.y);
        troopstext.setSize(70,70);
        troopstext.setText(String.valueOf(_figuresonpatch));
    }

    public boolean setFiguresonpatch(int figures,Player p)
    {
        if(_owner.get_name().equals(p.get_name()))
        {
            _figuresonpatch += figures;
            troopstext.setText(String.valueOf(_figuresonpatch));
            return true;
        }

        return false;
    }

    public ContinentPatch(String Name, Point Capital, List<ContinentPatch> neighbors)
    {
        _Neighbors = new ArrayList<ContinentPatch>();
        _Name = Name;
        _Capital = Capital;
        _Neighbors = neighbors;
    }

    public void setowner(Player Owner)
    {
        _owner = Owner;
        //Check in World if the continent is owned
    }

    public Player get_owner()
    {
        return _owner;
    }

    public void setCapital(Point p)
    {
        _Capital = p;
        troopstext.setLocation(_Capital.x,_Capital.y-35);
    }

    public void addneighbor(ContinentPatch newneigh)
    {
        _Neighbors.add(newneigh);
    }

    public String get_Name()
    {
        return _Name;
    }

    public int get_figuresonpatch()
    {
        return _figuresonpatch;
    }

    public void reduce_figuresonpatch(int reducecnt)
    {
        if(_figuresonpatch - reducecnt >= 0)
        {
            _figuresonpatch -= reducecnt;
            troopstext.setText(String.valueOf(_figuresonpatch));
        }
    }

    public Polygon get_ContinentPatch()
    {
        return _Continentmap;
    }
    public void set_hovered(boolean tmp)
    {
        _hovered = tmp;
    }
    public boolean get_hovered()
    {
        return _hovered;
    }
    public JLabel getTroopstext()
    {
        return troopstext;
    }
}
