package fr.unice.polytech.qgl.qbd.stats;

import fr.unice.polytech.qgl.qbd.gameObject.map.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SingularResourceDatabase {
    private Resource resourceName;                           //ex: WOOD, FUR
    private ArrayList<SampleExplore> SampleList;
    private HashMap<SampleExplore,Float> averageExploitCost;

    //TODO: update les stats
    //TODO: autres stats par ressource


    public SingularResourceDatabase(Resource nResourceName){
        this.resourceName = nResourceName;
        this.SampleList = new ArrayList<SampleExplore>();
        this.averageExploitCost = new HashMap<SampleExplore,Float>();
    }

    /*
     * Register a sample in the list after the case has been explored
     */
    public void explore(ExploreStr nAmountTxt, ExploreStr nConditions){
        SampleExplore newSample = new SampleExplore(this.resourceName, nAmountTxt, nConditions);
        SampleList.add(newSample);
    }

    /*
     * Update the sample of the current case, after the case has been exploited (we assume the case has been explored)
     */
    public void exploit(SampleExplore currentCaseSample, int nAmountInt, int actionCost){
        Resource name = currentCaseSample.getName();
        ExploreStr amountTxt = currentCaseSample.getAmountTxt();
        ExploreStr conditions = currentCaseSample.getConditions();
        SampleExploit newSample = new SampleExploit(name, amountTxt, conditions, nAmountInt, actionCost);
        for (SampleExplore test : SampleList){
            if (test.equals(currentCaseSample) && !(test instanceof SampleExploit)){
                SampleList.set( (SampleList.indexOf(test)), newSample); //Replace the Sample by the new one (update the sample)
                updateAverageExploitCost();
                return;
            }
        }
    }

    //Update the averageExploitCost stat once a sample has been exploited
    public void updateAverageExploitCost(){
        HashMap<SampleExplore,Integer> numberOfExploit = new HashMap<>();
        HashMap<SampleExplore,Integer> totalOfExploitCost = new HashMap<>();
        for (SampleExplore test : SampleList){
            if (test instanceof SampleExploit){
                SampleExplore testExplore = new SampleExplore(test.getName(),test.getAmountTxt(),test.getConditions());
                if (numberOfExploit.containsKey(testExplore)){
                    numberOfExploit.put(testExplore,numberOfExploit.get(testExplore)+1);
                    totalOfExploitCost.put(testExplore, numberOfExploit.get(testExplore)+((SampleExploit)test).getCost());
                    System.out.println("A");
                }
                else{
                    numberOfExploit.put(testExplore,1);
                    totalOfExploitCost.put(testExplore, ((SampleExploit)test).getCost());
                    System.out.println("B");
                }
            }
        }

        Iterator it = numberOfExploit.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry numberOfExploitPair = (HashMap.Entry)it.next();

            SampleExplore currentSampleExplore = (SampleExplore)numberOfExploitPair.getKey();
            int currentNumberOfExploit = (int)numberOfExploitPair.getValue();
            int currentTotalOfExploitCost = totalOfExploitCost.get(currentSampleExplore);
            float currentAverage = currentTotalOfExploitCost/currentNumberOfExploit;

            //TODO: DEBUG ICIIIIIIIIIIIIIIIIIIIIII?
            this.averageExploitCost.put(currentSampleExplore,currentAverage);   //Add the new average for the matching conditions in the hashmap
            it.remove(); // avoids a ConcurrentModificationException
        }
    }

    //Return the average exploit cost for the matching conditions, if at least one exploit has been made for those conditions. Otherwise, return -1
    public double getAverageExploitCostforConditions(ExploreStr amountTxt, ExploreStr conditions){
        SampleExplore testSample = new SampleExplore(this.resourceName, amountTxt, conditions);
        if (this.averageExploitCost.containsKey(testSample)){
            return averageExploitCost.get(testSample);
        }
        else {
            return (-1);
        }
    }


    public Resource getName(){
        return resourceName;
    }
    public ArrayList<SampleExplore> getSampleList(){
        return SampleList;
    }
    public HashMap<SampleExplore,Float> getAverageExploitCost(){
        return averageExploitCost;
    }
}
