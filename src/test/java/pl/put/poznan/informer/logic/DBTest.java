package pl.put.poznan.informer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Implementacja klasy odpowiedzialnej za testowanie klasy DB
 * @version 2.0.0
 * @author Delta
 */
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
