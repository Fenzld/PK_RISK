package AllThoseTerritories;
import java.util.*;
/**
 * Created by Dominik on 21.01.2016.
 */
public class Continent
{
    private List<ContinentPatch> _Allpatches;
    private int Bonus;

    public Continent(List<ContinentPatch> Patches)
    {
        _Allpatches = Patches;
    }
    public void addContinentPatch(ContinentPatch patch)
    {
        _Allpatches.add(patch);
    }
}
