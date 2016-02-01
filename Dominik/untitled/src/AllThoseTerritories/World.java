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

    private void AddCapitals(List<String> Capitals)
    {
        for(String a : Capitals)
        {
            String[] Work = a.split(",");
            getContinentPatchwithname(Work[0]).setCapital(new Point(Integer.parseInt(Work[1]),Integer.parseInt(Work[2])));
        }

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
            _AllContinents.add(new Continent(currentcontinentlist));

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
    //dient zum besetzen eines Gebietes, solange noch feindliche Truppen auf dem Gebiet sind liefert die Methode false zurück und kann somit noch nicht besetzt werden.
    //wenn das Gebiet leer ist, wird der Owner auf "" gesetzt.
    public boolean besetzen(String ContinentPatchname,Player owner,int Figurestomove)
    {
        ContinentPatch tmp = getContinentPatchwithname(ContinentPatchname);
        if(tmp.get_owner() != "")
        {
            if(firstphasenotready)
            {
                tmp.setowner(owner.get_name());
                tmp.setFiguresonpatch(Figurestomove);
            }
            else
            {
                if(owner.get_Figures() > 0)
                {
                    tmp.setowner(owner.get_name());
                    tmp.setFiguresonpatch(Figurestomove);
                }
            }
        }
        else
        {
            return false;
        }
        return true;
    }

    //public boolean battle(Player Playerwhoattacks,Player Playerwhodefends, String ContinentPatchname)
    //{

    //}

    public ContinentPatch getContinentPatchwithname(String Name)
    {
        String Work = Name.replace(" ","");
        for(ContinentPatch cur : _Allcontinentpatchess)
        {
            if(Work.equals(cur.get_Name().replace(" ", "")))
            {
                System.out.println(cur.get_Name());
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
