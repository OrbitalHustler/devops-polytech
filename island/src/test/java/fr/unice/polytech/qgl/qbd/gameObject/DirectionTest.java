package fr.unice.polytech.qgl.qbd.gameObject;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * PolyTech Nice / SI3 / Module POO-Java
 * Annee 2015 - qbd - Lab 3
 * Package fr.unice.polytech.qgl.qbd.gameObject
 *
 * @author Flavian Jacquot
 * @version 30/11/2015
 * @since 1.8.0_60
 */
public class DirectionTest {
    Direction d;
    Direction res;


    @Test
    public void testDefaultConstructor() throws Exception {
        d = Direction.E;
        assertEquals("E", d.toJSONString());
    }


    @Test
    public void testGetRear() throws Exception {
        d = Direction.E;
        res = d.getRear();
        assertEquals(Direction.W, res);
    }

    @Test
    public void testGetRight() throws Exception {
        d = Direction.E;
        res = d.getRight();
        assertEquals(Direction.S, res);
    }

    @Test
    public void testGetLeft() throws Exception {
        d = Direction.E;
        res = d.getLeft();
        assertEquals(Direction.N, res);

        res = Direction.N.getLeft();
        assertEquals(Direction.W, res);

        res = Direction.N.getRight();
        assertEquals(Direction.E, res);
    }

    @Test
    public void testGetFront() throws Exception {
        d = Direction.E;
        res = d.getFront();
        assertEquals(Direction.E, res);
    }
    @Test
    public void testEquals()
    {
        assertNotEquals(Direction.W,Direction.N);
        assertNotEquals(Direction.S,Direction.N);
        assertNotEquals(Direction.E,Direction.N);

        assertNotEquals(Direction.S,Direction.W);
        assertNotEquals(Direction.E,Direction.W);

        assertNotEquals(Direction.S,Direction.E);
    }
}