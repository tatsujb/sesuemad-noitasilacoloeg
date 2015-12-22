
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;

/**
 * Created by Fabienne_2 on 14/11/2015.
 */
public class DameuseTest {

    private Dameuse dameuse;
    private Traitement traitement;
    private Donnees donnees;

    @Before
    public void setUp() throws IOException {
        traitement = new Traitement();
        this.donnees = new Donnees(traitement.traitement("22/12/2015 12:45:12 0 0 dam1"));
        this.dameuse = new Dameuse(this.donnees);

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

        assertEquals(this.dameuse.getDonnees().toString(),"0 0 0 0 0");

        Donnees donnees1 = new Donnees(traitement.traitement("28/12/2015 12:45:12 0 0 dam1"));
        this.dameuse.setDonnees(donnees1);
        assertEquals(this.dameuse.getDonnees().toString(),"28/12/2015 12:45:12 0 0 dam1");
        assertNotEquals(this.dameuse.getDonnees().toString(),"22/12/2015 12:45:12 0 0 dam1");
    }

    @Test
    public void testToString() {
        assertEquals(this.dameuse.toString(), "Dameuse dam1 : 0 0 0 0 0");
    }
}