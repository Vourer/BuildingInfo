package pl.put.poznan.informer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class PoziomTest {
    private Poziom testPoz;

    @BeforeEach
    void setUp() {
        testPoz = new Poziom(11, "floor 1");
        for (int i = 1; i <= 3; i++) {
            Pomieszczenie pom = new Pomieszczenie(100+i, "room"+(100+i));
            pom.setLight(4.0);
            pom.setArea(2.0);
            pom.setHeating(6.0);
            pom.setCube(3.0);
            testPoz.addPomieszczenie(pom);
        }
    }

    @Test
    void testGetArea() {
        assertEquals(testPoz.getArea(), 6.0);
    }

    @Test
    void testGetCube() {
        assertEquals(testPoz.getCube(), 9.0);
    }

    @Test
    void testGetLight() {
        assertEquals(testPoz.getLight(), 12.0/6.0);
    }

    @Test
    void testGetLightPower() {
        assertEquals(testPoz.getLightPower(), 12.0);
    }

    @Test
    void testGetHeating() {
        assertEquals(testPoz.getHeating(), 18.0/9.0);
    }

    @Test
    void testGetHeatingPower() {
        assertEquals(testPoz.getHeatingPower(), 18.0);
    }

    @Test
    void testGetValidRooms() {
        // pusta lista
        assertEquals(testPoz.getValidRooms(3.0), Collections.emptyList());
        // wszystkie pomieszczenia
        List<Integer> roomNums = new ArrayList<Integer>();
        roomNums.add(101);
        roomNums.add(102);
        roomNums.add(103);
        assertEquals(testPoz.getValidRooms(1.0), roomNums);
    }

}
