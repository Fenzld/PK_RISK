package AllThoseTerritories;
import java.util.*;
/**
 * Created by Dominik on 21.01.2016.
 */
public class Continent
{
    private List<ContinentPatch> _Allpatches;
    private int _Bonus;

    public Continent(List<ContinentPatch> Patches,int bonus)
    {
        _Allpatches = Patches;
        _Bonus = bonus;
    }
    public void addContinentPatch(ContinentPatch patch)
    {
        _Allpatches.add(patch);
    }
    public boolean is_Continent_owned(List<ContinentPatch> allpatchesfromplayer)
    {
        boolean found = false;
        for (ContinentPatch c : _Allpatches)
        {
            found = false;
            for (ContinentPatch ctmp : allpatchesfromplayer)
            {
                if(c.get_Name().equals(ctmp.get_Name()))
                {
                    found = true;
                }
            }
            if(!found)
                return false;
        }
        return true;
    }

    public int getBonus()
    {
        return _Bonus;
    }

//    public List<ContinentPatch> get_Allpatches()
//    {
//        return _Allpatches;
//    }
}
