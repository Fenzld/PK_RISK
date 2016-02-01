package AllThoseTerritories;

import com.sun.javafx.scene.control.behavior.CellBehaviorBase;

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
    private String _owner;
    private int _figuresonpatch = 0;

    public ContinentPatch(String Name, Point Capital, Polygon ContinentonMap)
    {
        _Neighbors = new ArrayList<ContinentPatch>();
        _Name = Name;
        _Capital = Capital;
        _Continentmap = ContinentonMap;
        _owner = "";
    }

    public void setFiguresonpatch(int figures)
    {
        _figuresonpatch = figures;
    }

    public ContinentPatch(String Name, Point Capital, List<ContinentPatch> neighbors)
    {
        _Neighbors = new ArrayList<ContinentPatch>();
        _Name = Name;
        _Capital = Capital;
        _Neighbors = neighbors;
    }

    public void setowner(String Owner)
    {
        _owner = Owner;
        //Check in World if the continent is owned
    }

    public String get_owner()
    {
        return _owner;
    }

    public void setCapital(Point p)
    {
        _Capital = p;
    }

    public void addneighbor(ContinentPatch newneigh)
    {
        _Neighbors.add(newneigh);
    }

    public String get_Name()
    {
        return _Name;
    }

    public Polygon get_ContinentPatch()
    {
        return _Continentmap;
    }
}
