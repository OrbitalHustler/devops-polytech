package fr.unice.polytech.qgl.qbd.stats;

import fr.unice.polytech.qgl.qbd.exception.NoSingularResourceDatabaseFoundException;
import fr.unice.polytech.qgl.qbd.gameObject.map.Resource;

import java.util.ArrayList;
import java.util.HashMap;

public interface IntStat {
    /*
     * INITIALIZE THE STAT DATABASE
     * Build the database from the HashMap (create a ressource database for every ressource type in the contract)
     */
    public ArrayList<SingularResourceDatabase> buildDatabaseFromContracts(HashMap<Resource,Integer> nContracts);

    /*
     * Move on the resource map to the given coordinates
     */
    public void move(int nMapPosX, int nMapPosY);

    //TODO: methode interpretant un result pour lancer Explore ou Exploit (voir le format de Result)?

    /*
     * Register a sample in the list after the case has been explored
     */
    public void explore(Resource resourceName, ExploreStr nAmountTxt, ExploreStr nConditions);

    /*
     * Update the sample of the current case, after the case has been exploited (we assume the case has been explored)
     */
    public void exploit(int nAmountInt, int actionCost);

    /*
     * Return the Resource map. This map contains a single SampleExplore on cases explored,
     * which can be changed into a SampleExploit by exploiting the case
     * Those samples contains every information acquired when exploring or exploiting the case
     */
    public SampleExplore[][] getResourceMap();

    /*
     * Return the sample of the current case, or void if the case has not been at least explored
     */
    public SampleExplore getCurrentCaseSample();

    /*
     * Return the globabal database, ArrayList containing all SingularResourceDatabase, each specialized in
     * a single resource type, and recording everything regarding it
     */
    public ArrayList<SingularResourceDatabase> getGlobalResourceDatabase();

    /*
     * Return the matching SingularResourceDatabase, which contains every information acquired about the type given
     */
    public SingularResourceDatabase getResourceDatabase(Resource name) throws NoSingularResourceDatabaseFoundException;

    /*
     * Return the average exploit cost for the matching resource name, and the desired conditions
     */
    public double getAverageExploitCostforNameAndConditions(Resource name, ExploreStr amountTxt, ExploreStr conditions);
}
