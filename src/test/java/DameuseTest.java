import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Fabienne_2 on 14/11/2015.
 */
public class DameuseTest {

    private Dameuse dameuse;

    @Before
    public void setUp() {

        this.dameuse = new Dameuse("dam1");
    }

    @After
    public void tearDown() {

        this.dameuse = null;
    }

    @Test
    public void testGetNom() {
        assertEquals(this.dameuse.getNom(),"dam1");
    }

    @Test
    public void testSetDonnees() {

    }

    @Test
    public void testSetNom() {

    }

    @Test
    public void testToString() {

    }
}