package pl.put.poznan.informer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


/**
 * Implementacja klasy odpowiedzialnej za testowanie klasy Budynek
 * @version 2.0.0
 * @author Delta
 */
public class BudynekTest {
    private Budynek buddy;
    private Poziom mock1poz;
    private Poziom mock2poz;

    @BeforeEach
    void setUp() {
        buddy = new Budynek(1, "budynek 1");
        mock1poz = mock(Poziom.class);
        mock2poz = mock(Poziom.class);
    }

    @Test
    void testGetArea() {
        when(mock1poz.getArea()).thenReturn(10.0);
        buddy.addPoziom(mock1poz);
        assertEquals(buddy.getArea(), 10.0);

        when(mock2poz.getArea()).thenReturn(20.0);
        buddy.addPoziom(mock2poz);
        assertEquals(buddy.getArea(), 30.0);

        verify(mock1poz, times(2)).getArea();
        verify(mock2poz, atLeastOnce()).getArea();
    }

    @Test
    void testGetCube() {
        when(mock1poz.getCube()).thenReturn(21.0);
        buddy.addPoziom(mock1poz);
        assertEquals(buddy.getCube(), 21.0);

        when(mock2poz.getCube()).thenReturn(37.0);
        buddy.addPoziom(mock2poz);
        assertEquals(buddy.getCube(), 58.0);

        verify(mock1poz, times(2)).getCube();
        verify(mock2poz, atLeastOnce()).getCube();
    }

    @Test
    void testGetLight() {
        when(mock1poz.getLightPower()).thenReturn(2.0);
        when(mock1poz.getArea()).thenReturn(1.0);
        buddy.addPoziom(mock1poz);
        assertEquals(buddy.getLight(), 2.0);

        when(mock2poz.getLightPower()).thenReturn(1.0);
        when(mock2poz.getArea()).thenReturn(2.0);
        buddy.addPoziom(mock2poz);
        assertEquals(buddy.getLight(), 3.0/3.0);

        verify(mock1poz, times(2)).getLightPower();
        verify(mock1poz, times(2)).getArea();
        verify(mock2poz, atLeastOnce()).getLightPower();
        verify(mock2poz, atLeastOnce()).getArea();
    }

    @Test
    void testGetHeating() {
        when(mock1poz.getHeatingPower()).thenReturn(2.0);
        when(mock1poz.getCube()).thenReturn(1.0);
        buddy.addPoziom(mock1poz);
        assertEquals(buddy.getHeating(), 2.0);

        when(mock2poz.getHeatingPower()).thenReturn(4.0);
        when(mock2poz.getCube()).thenReturn(2.0);
        buddy.addPoziom(mock2poz);
        assertEquals(buddy.getHeating(), 6.0/3.0);

        verify(mock1poz, times(2)).getCube();
        verify(mock1poz, times(2)).getHeatingPower();
        verify(mock2poz, atLeastOnce()).getCube();
        verify(mock2poz, atLeastOnce()).getHeatingPower();
    }

    @Test
    void testGetValidRooms() {
        List<Integer> lista1 = new ArrayList<>();
        lista1.add(111);
        lista1.add(112);

        when(mock1poz.getValidRooms(anyDouble())).thenReturn(lista1);
        buddy.addPoziom(mock1poz);
        assertEquals(buddy.getValidRooms(3.0), lista1);

        when(mock2poz.getValidRooms(anyDouble())).thenReturn(Collections.emptyList());
        buddy.addPoziom(mock2poz);
        assertEquals(buddy.getValidRooms(5.0), lista1);

        verify(mock1poz, times(2)).getValidRooms(anyDouble());
        verify(mock2poz, atLeastOnce()).getValidRooms(anyDouble());
    }

    @Test
    void testGetRent() {
        when(mock1poz.getRent()).thenReturn(2000.0);
        buddy.addPoziom(mock1poz);
        assertEquals(buddy.getRent(), 2000.0);

        when(mock2poz.getRent()).thenReturn(3000.0);
        buddy.addPoziom(mock2poz);
        assertEquals(buddy.getRent(), 5000.0);

        verify(mock1poz, times(2)).getRent();
        verify(mock2poz, atLeastOnce()).getRent();
    }

    @Test
    void testGetRentPerArea() {
        when(mock1poz.getRent()).thenReturn(1000.0);
        when(mock1poz.getArea()).thenReturn(10.0);
        buddy.addPoziom(mock1poz);
        assertEquals(buddy.getRentPerArea(), 100.0);

        when(mock2poz.getRent()).thenReturn(4000.0);
        when(mock2poz.getArea()).thenReturn(10.0);
        buddy.addPoziom(mock2poz);
        assertEquals(buddy.getRentPerArea(), 5000.0/20.0);

        verify(mock1poz, times(2)).getRent();
        verify(mock1poz, times(2)).getArea();
        verify(mock2poz, atLeastOnce()).getRent();
        verify(mock2poz, atLeastOnce()).getArea();
    }


    @Test
    void testGetWater() {
        when(mock1poz.getWater()).thenReturn(10.0);
        buddy.addPoziom(mock1poz);
        assertEquals(buddy.getWater(), 10.0);

        when(mock2poz.getWater()).thenReturn(15.0);
        buddy.addPoziom(mock2poz);
        assertEquals(buddy.getWater(), 25.0);

        verify(mock1poz, times(2)).getWater();
        verify(mock2poz, atLeastOnce()).getWater();
    }

}
