package fr.unice.polytech.qgl.qbd.gameObject.map;

/**
 * PolyTech Nice / SI3 / Module POO-Java
 * Annee 2015 - qbd - Lab 3
 * Package fr.unice.polytech.qgl.qbd.gameObject.map
 *
 * @author Flavian Jacquot
 * @version 27/12/2015
 * @since 1.8.0_60
 */
public class MapTest {

    /*int rangeL=6;
    int rangeR=10;
    int rangeF=30;
    Map map = null;
    Direction original =Direction.E;


    @Before
    public void setContext()
    {


        //echo gauche initial
        JSONObject result=new JSONObject();
        result.put("cost",10);
        result.put("status","OK");

        JSONObject extra = new JSONObject();
        extra.put("found", "OUT_OF_RANGE");
        extra.put("range", rangeL);
        System.out.println("11"+extra.getInt("range"));
        result.put("extras",extra);

        Result res = new Result(result.toString());
        EchoAction a =new EchoAction(Direction.N);
        res.setAction(a);

        //echo droit initial
        JSONObject result2=new JSONObject();
        result2.put("cost",10);
        result2.put("status","OK");
        JSONObject extra2 = new JSONObject();
        extra2.put("found", "OUT_OF_RANGE");
        extra2.put("range", rangeR);
        result2.put("extras",extra2);

        Result res2 = new Result(result2.toString());
        EchoAction a2 =new EchoAction(Direction.S);

        res2.setAction(a2);

        //echo frontal
        JSONObject result3=new JSONObject();
        result3.put("cost",12);
        result3.put("status","OK");
        JSONObject extra3 = new JSONObject();
        extra3.put("found", "OUT_OF_RANGE");
        extra3.put("range", rangeF);
        result3.put("extras",extra3);

        Result res3 = new Result(result3.toString());
        EchoAction a3 =new EchoAction(Direction.E);
        res3.setAction(a3);

        ArrayList<Result> toCreateMap = new ArrayList<>();
        toCreateMap.add(res);
        toCreateMap.add(res2);
        toCreateMap.add(res3);
        this.map=new Map(original,toCreateMap);

    }
    @Test
    public void testConstructor()
    {
        map.dropMapOnLogger();
        assertTrue (!this.map.getCells().isEmpty());


        assertEquals((rangeF-1)+(rangeL-1)+(rangeR-1)+1,map.getCells().size());
        assertEquals(new Coords(rangeL,0),map.getPosition());

        assertEquals((rangeL+1+rangeR),map.getWidth());
        assertEquals((rangeF+1),map.getHeight());
    }
    @Test
    public void testApplyFly() throws Exception {
        assertEquals(new Coords(rangeL,0),map.getPosition());
        map.applyFly();
        assertEquals(new Coords(rangeL,1),map.getPosition());


    }

    @Test
    public void testApplyTurn() throws Exception {
        assertEquals(new Coords(rangeL,0),map.getPosition());
        map.applyTurn(original.getLeft());
        assertEquals(new Coords(rangeL-1,1),map.getPosition());
        assertEquals(original.getLeft(),map.getCompas());

    }

    @Test
    public void testApplyEcho() throws Exception {
        //test dans le constructeur déjà mais plus à faire
        int size = map.getCells().size();

    }

    @Test public void  testApplyScan()
    {
        JSONObject result=new JSONObject("{\"cost\": 2, \"extras\": { \"biomes\": [\"GLACIER\", \"ALPINE\"], \"creeks\": [\"id\"]}, \"status\": \"OK\"}\n");

        Result res = new Result(result.toString());
        ScanAction a =new ScanAction();
        res.setAction(a);

        map.apllyScan(res);

        Cell updated = map.getCells().get(map.getPosition());
        assertTrue(updated.getBiomes().containsKey(Biome.biomes.get("GLACIER")));
        assertTrue(updated.getBiomes().containsKey(Biome.biomes.get("ALPINE")));

        assertTrue(updated.getCreeksID().contains("id"));


    }*/
}