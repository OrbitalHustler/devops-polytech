package fr.unice.polytech.qgl.qbd.gameObject.map;

import fr.unice.polytech.qgl.qbd.gameObject.Direction;
import fr.unice.polytech.qgl.qbd.results.Result;

/*
 * On considère que l'origine, (0,0) est en haut a gauche de la carte
 */
public class DroneMap {
    //private static Logger logger= LogManager.getLogger(DroneMap.class);
    private Cell[][] map;

    //Spawn par défaut: Direction du Nord
    public DroneMap(int width, int height){
        this(Direction.N, width, height);
    }
    public DroneMap(Direction spawnDirection, int relativeWidth, int relativeHeight) {
        if (spawnDirection == Direction.S || spawnDirection == Direction.N)
            map = new Cell[relativeWidth][relativeHeight];
        else
            map = new Cell[relativeHeight][relativeWidth];
    }
    private Coords relativeCalcul(Coords pos, int range, Direction d){
        switch (d){
            case E:
                return pos.add(range, 0);
            case N:
                return pos.add(0, -range);
            case W:
                return pos.add(-range, 0);
            default:
                return pos.add(0, range);
        }
    }
    private void updateEcho(Coords pos, Direction d, int range, boolean groundFound){
        Coords p = relativeCalcul(pos, range, d);
        map[p.x][p.y] = new Cell();
        map[p.x][p.y].setGround(groundFound);
        while (range - 1 > -1){
            p = relativeCalcul(pos, range, d);
            if (map[pos.x][pos.y] == null){
                Cell c = new Cell();
                c.setGround(false);
                map[pos.x][pos.y] = c;
            }
            --range;
        }
    }
    public void acknowledgeResults(Result result){
        /*if (a.getName() == Actions.ECHO && r.getExtras().get("found").equals("GROUND")){
            EchoAction a
        }
        else if (a.getName() == Actions.SCAN){
            //TODO
        }*/
    }
    public Cell getCell(int x, int y){
        return map[x][y];
    }

    public int getWidth(){
        return map.length;
    }
    public int getHeight(){
        return map[0].length;
    }
}
