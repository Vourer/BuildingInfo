package pl.put.poznan.informer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DBTest {

    @Test
    void testGetObjectByID() {
        DB testDb = new DB();
        assertNull(testDb.getObjectById(7));

        Budynek buddy = new Budynek(1, "buddy");
        testDb.add(buddy);
        assertEquals(testDb.getObjectById(1), buddy);
    }


}
