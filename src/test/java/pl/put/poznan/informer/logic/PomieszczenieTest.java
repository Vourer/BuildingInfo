package pl.put.poznan.informer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PomieszczenieTest {
    private Pomieszczenie testPom;

    @BeforeEach
    void setUp() {
        testPom = new Pomieszczenie(12, "room 12");
    }

    @Test
    void testGetLight() {
        double light = 2.0;
        double area = 10.0;
        testPom.setLight(light);
        testPom.setArea(area);
        assertEquals(testPom.getLight(), light/area);
    }

    @Test
    void testGetHeating() {
        double heat = 10.0;
        double cube = 5.0;
        testPom.setCube(cube);
        testPom.setHeating(heat);
        assertEquals(testPom.getHeating(), heat/cube);
    }

    @Test
    void testGetRentPerArea() {
        double rent = 100.0;
        double area = 10.0;
        testPom.setRent(rent);
        testPom.setArea(area);
        assertEquals(testPom.getRentPerArea(), rent/area);
    }
}
