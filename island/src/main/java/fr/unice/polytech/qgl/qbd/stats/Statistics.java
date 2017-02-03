package fr.unice.polytech.qgl.qbd.stats;

import fr.unice.polytech.qgl.qbd.exception.NoSingularResourceDatabaseFoundException;
import fr.unice.polytech.qgl.qbd.gameObject.map.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/*
 * Has access to every stats, to every resource types, every samples registered.
 * Also has its own map, which only contains informations about resources.
 */
public class Statistics implements IntStat{
    private ArrayList<SingularResourceDatabase> globalResourceDatabase;   //Contain each SingularResourceDatabase linked to each ressource type from the contract
    private HashMap<Resource,Integer> contracts;
    private SampleExplore[][] resourceMap;
    private int mapPosX;
    private int mapPosY;

    public Statistics(HashMap<Resource,Integer> nContracts, int mapSizeX, int mapSizeY, int nMapPosX, int nMapPosY){
        this.contracts = nContracts;
        this.globalResourceDatabase = buildDatabaseFromContracts(this.contracts);
        this.resourceMap = new SampleExplore[mapSizeX][mapSizeY];
        this.mapPosX = nMapPosX;
        this.mapPosY = nMapPosY;
    }


    /*
     * Build the ArrayList from the HashMap (create a ressource database for every ressource type in the contract)
     */
    public ArrayList<SingularResourceDatabase> buildDatabaseFromContracts(HashMap<Resource,Integer> nContracts){
        ArrayList<SingularResourceDatabase> GRDatabase = new ArrayList<SingularResourceDatabase>();
        Iterator it = nContracts.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            SingularResourceDatabase newDatabase = new SingularResourceDatabase((Resource)pair.getKey());   //Create a new database from the ressource's name
            GRDatabase.add(newDatabase);
            it.remove(); // avoids a ConcurrentModificationException
        }
        return GRDatabase;
    }

    /*
     * Update the sample after the case has been explored, in the matching resource type database
     */
    public void explore(Resource resourceName, ExploreStr nAmountTxt, ExploreStr nConditions){
        //TODO: ameliorer si possible (voir SingularResourceDatabase)
        SingularResourceDatabase Database = getResourceDatabase(resourceName);
        Database.explore(nAmountTxt, nConditions);

        SampleExplore newSample = new SampleExplore(resourceName, nAmountTxt, nConditions);
        this.getResourceMap()[this.mapPosX][this.mapPosY] = newSample;
    }

    /*
     * Update the sample of the current case, after the case has been exploited, in the matching resource type database
     */
    public void exploit(int nAmountInt, int actionCost){
        //TODO: ameliorer si possible (voir SingularResourceDatabase)
        SampleExplore currentCaseSample = this.getCurrentCaseSample();
        SingularResourceDatabase Database = getResourceDatabase(currentCaseSample.getName());
        Database.exploit(currentCaseSample,nAmountInt, actionCost);

        Resource name = currentCaseSample.getName();
        ExploreStr amountTxt = currentCaseSample.getAmountTxt();
        ExploreStr conditions = currentCaseSample.getConditions();
        SampleExploit newSample = new SampleExploit(name, amountTxt, conditions, nAmountInt, actionCost);
        this.getResourceMap()[this.mapPosX][this.mapPosY] = newSample;
    }

    /*
     * Move on the resource map to the coordinates
     */
    public void move(int nMapPosX, int nMapPosY){
        this.mapPosX = nMapPosX;
        this.mapPosY = nMapPosY;
    }

    /*
     * Find the SingularResourceDatabase of the corresponding ressource type name
     */
    public SingularResourceDatabase getResourceDatabase(Resource name) throws NoSingularResourceDatabaseFoundException {
        for (SingularResourceDatabase test : globalResourceDatabase){
            if (test.getName() == name){
                return test;
            }
        }
        throw new NoSingularResourceDatabaseFoundException();
    }

    /*
     * Return the average exploit cost for the matching resource name, and the desired conditions
     */
    public double getAverageExploitCostforNameAndConditions(Resource name, ExploreStr amountTxt, ExploreStr conditions){
        return this.getResourceDatabase(name).getAverageExploitCostforConditions(amountTxt,conditions);
    }


    public SampleExplore[][] getResourceMap() { return this.resourceMap; }
    public boolean isCurrentCaseExplored(){
        return (this.getCurrentCaseSample() != null);
    }
    public SampleExplore getCurrentCaseSample(){
        return this.resourceMap[mapPosX][mapPosY];
    }
    public ArrayList<SingularResourceDatabase> getGlobalResourceDatabase(){
        return this.globalResourceDatabase;
    }
    public HashMap<Resource,Integer> getContracts(){
        return this.contracts;
    }
}
