package fr.unice.polytech.qgl.qbd.gameObject;

/**
 * PolyTech Nice / SI3 / Module POO-Java
 * Annee 2015 - qbd - Lab 3
 * Package fr.unice.polytech.qgl.qbd.gameObject
 *
 * @author Flavian Jacquot
 * @version 28/11/2015
 * @since 1.8.0_60
 */
public enum Direction {
    N("N"), W("W"), S("S"), E("E");

    private String JSONString;

    Direction(String JSONString){
        this.JSONString = JSONString;
    }

    public Direction getRear() {
        int index = this.ordinal()+2;

        return getFromInt(index);
    }

    public Direction getRight() {
        int index = this.ordinal()-1;

        return getFromInt(index);
    }

    public Direction getFromInt(int index)
    {
        index%=4;
        if(index<0)
        {
            index+=4;
        }
        return Direction.values()[index];
    }

    public Direction getLeft() {
        int index = this.ordinal()+1;

        return getFromInt(index);
    }

    public Direction getFront() {
        return this;
    }

    public static Direction get(String s)
    {
        if(s==null)
            return null;
        s=s.toUpperCase();
        for(Direction dir: Direction.values())
        {
            if(s.equals(dir.name()))
                return dir;
        }
        return null;

    }

    public String toJSONString(){
        return JSONString;
    }

}
