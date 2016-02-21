package AllThoseTerritories;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dominik on 21.01.2016.
 */
public class World
{
    List<ContinentPatch> _Allcontinentpatchess;
    List<String> _Capitals;
    List<Continent> _AllContinents;
    List<Player> _Players;
    boolean first = true;
    boolean firstphasenotready = true;

    public World(List<ContinentPatch> Allcontinents,List<String> neighbors,List<String> ContinentPatches,List<String> Capitals)
    {
        _Allcontinentpatchess = Allcontinents;
        AddNeighborstoPatches(neighbors);
        _AllContinents = new ArrayList<Continent>();
        AddPatchestoContinent(ContinentPatches);
        AddCapitals(Capitals);
        _Players = new ArrayList<Player>();
    }

    public void AddPlayer(Player p)
    {
        _Players.add(p);
    }

    public void handoutfigures(Player p)
    {
        p.add_figures(getContinentPatchesfromPlayer(p.get_name()).size() / 3);
        for (Continent a : get_owned_Continents(p.get_name()))
        {
            p.add_figures(a.getBonus());
        }
        System.out.println("Player: " + p.get_name() + "has now " + p.get_Figures() + " figures");
    }

    private void AddCapitals(List<String> Capitals)
    {
        for(String a : Capitals)
        {
            String[] Work = a.split(",");
            getContinentPatchwithname(Work[0]).setCapital(new Point(Integer.parseInt(Work[1]),Integer.parseInt(Work[2])));
        }

    }

    private List<Continent> get_owned_Continents(String playername)
    {
        List<Continent> ret = new ArrayList<Continent>();
        for(Continent c : _AllContinents)
        {
           if(c.is_Continent_owned(getContinentPatchesfromPlayer(playername)))
           {
                ret.add(c);
           }
        }
        return ret;
    }

    private void AddPatchestoContinent(List<String> Continentpatch)
    {
        List<ContinentPatch> currentcontinentlist;
        for(String a : Continentpatch)
        {
            String firststring = a.split(",")[0];
            String bonusnumber = firststring.split(" ")[firststring.split(" ").length-1];
            currentcontinentlist = new ArrayList<ContinentPatch>();
            String currentcont = firststring.substring(0,firststring.length() - bonusnumber.length() - 1);
            for(String curne : a.split(","))
            {
                if(!curne.equals(firststring))
                {
                    ContinentPatch curcont = getContinentPatchwithname(currentcont);
                    if(curcont != null )
                        currentcontinentlist.add(getContinentPatchwithname(curne));
                }
            }
            _AllContinents.add(new Continent(currentcontinentlist,Integer.parseInt(bonusnumber)));

        }
    }

    private void AddNeighborstoPatches(List<String> neighbors)
    {
        for(String a : neighbors)
        {
            String currentcont = a.split(",")[0];
            for(String curne : a.split(","))
            {
                if(!curne.equals(currentcont))
                {
                    ContinentPatch curcont = getContinentPatchwithname(currentcont);
                    if(curcont != null )
                        curcont.addneighbor(getContinentPatchwithname(curne));
                }
            }

        }
    }

    public boolean checkifallcontinentsareconquered()
    {
        boolean allset = true;
        for(ContinentPatch a : get_Allcontinentpatchess())
        {
            if(a.get_owner() == "")
            {
                allset = false;
                System.out.println(a.get_Name());
            }
        }
        return allset;
    }

    //dient zum besetzen eines Gebietes, solange noch feindliche Truppen auf dem Gebiet sind liefert die Methode false zurück und kann somit noch nicht besetzt werden.
    //wenn das Gebiet leer ist, wird der Owner auf "" gesetzt.
    public boolean besetzen(String ContinentPatchname,Player owner,int Figurestomove,boolean besetzenvar)
    {
        ContinentPatch tmp = getContinentPatchwithname(ContinentPatchname);
        if(tmp.get_owner().equals(""))
        {
            //der owner wird überschrieben, im falle in einem Continentpatch alle armeen geschlagen wurden, muss der owner auf "" gesetzt werden
                if(owner.get_Figures() - Figurestomove >= 0)
                {
                    tmp.setowner(owner.get_name());
                    tmp.setFiguresonpatch(Figurestomove,owner);
                    owner.reducefigures(Figurestomove);
                    System.out.println(owner.get_name() + " Conquered " + ContinentPatchname);
                    return true;
                }
            else
                    System.out.println("Select another continentpatch, "+ContinentPatchname+" is already owned.");
        }
        else if(tmp.get_owner().equals(owner.get_name()) && !besetzenvar)
        {
            //dann werden nur truppen gesetzt
            if(owner.get_Figures() - Figurestomove >= 0)
            {
                tmp.setFiguresonpatch(Figurestomove, owner);
                owner.reducefigures(Figurestomove);
                return true;
            }
            else
                System.out.println("You only have " + owner.get_Figures() + " troops left!");
        }

            return false;
    }

    //public boolean battle(Player Playerwhoattacks,Player Playerwhodefends, String ContinentPatchname)
    //{

    //}

    public List<ContinentPatch> getContinentPatchesfromPlayer(String Playername)
    {
        List<ContinentPatch> contilist = new ArrayList<ContinentPatch>();
        String Work = Playername;
        for(ContinentPatch cur : _Allcontinentpatchess)
        {
            if(Work.equals(cur.get_owner()))
            {
                contilist.add(cur);
            }
        }
        return contilist;
    }

    public ContinentPatch getContinentPatchwithname(String Name)
    {
        String Work = Name.replace(" ","");
        for(ContinentPatch cur : _Allcontinentpatchess)
        {
            if(Work.equals(cur.get_Name().replace(" ", "")))
            {
                //System.out.println(cur.get_Name());
            return cur;

            }
        }
        return null;
    }

    public List<ContinentPatch> get_Allcontinentpatchess()
    {
        return _Allcontinentpatchess;
    }
}
