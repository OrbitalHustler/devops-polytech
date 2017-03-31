package fr.unice.polytech.qgl.qbd.stats;

import fr.unice.polytech.qgl.qbd.gameObject.map.Resource;

/*
 * Data given after a case is explored
 * Parent class of SampleExploit
 */
public class SampleExplore {
    private Resource name;
    private ExploreStr amountTxt;
    private ExploreStr conditions;

    public SampleExplore(Resource nName, ExploreStr nAmountTxt, ExploreStr nConditions){
        this.name = nName;
        this.amountTxt = nAmountTxt;
        this.conditions = nConditions;
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof SampleExplore))return false;
        SampleExplore otherSample = (SampleExplore)other;
        if (this.getName() != otherSample.getName()) return false;
        if (this.getAmountTxt() != otherSample.getAmountTxt()) return false;
        if (this.getConditions() != otherSample.getConditions()) return false;
        return true;
    }

    //Random prime numbers are used here : the only objective is to identify if two SampleExplore are the same in a HashMap
    @Override
    public int hashCode()
    {
        return ( 3*this.name.hashCode() + 7*this.amountTxt.hashCode() + 8*this.conditions.hashCode() );
    }

    public Resource getName() {
        return this.name;
    }
    public ExploreStr getAmountTxt() {
        return amountTxt;
    }
    public ExploreStr getConditions() {
        return conditions;
    }
}
