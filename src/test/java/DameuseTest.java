import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;

/**
 * Created by Fabienne_2 on 14/11/2015.
 */
public class DameuseTest {

    private Class.Dameuse dameuse;
    private Class.Traitement traitement;
    private Class.Donnees donnees;

    @Before
    public void setUp() throws IOException {
        traitement = new Class.Traitement();
        this.donnees = new Class.Donnees(traitement.traitement("22/12/2015 12:45:12 0 0 dam1"));
        this.dameuse = new Class.Dameuse(this.donnees);

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

        Class.Donnees donnees1 = new Class.Donnees(traitement.traitement("28/12/2015 12:45:12 0 0 dam1"));
        this.dameuse.setDonnees(donnees1);
        assertEquals(this.dameuse.getDonnees().toString(),"28/12/2015 12:45:12 0 0 dam1");
        assertNotEquals(this.dameuse.getDonnees().toString(),"22/12/2015 12:45:12 0 0 dam1");
    }

    @Test
    public void testToString() {
        assertEquals(this.dameuse.toString(), "Class.Dameuse dam1 : 0 0 0 0 0");
    }
}