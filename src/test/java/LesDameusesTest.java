import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fabienne_2 on 14/11/2015.
 */
public class LesDameusesTest {

    private Class.LesDameuses lesDameuses;

    @Before
    public void setUp() throws Exception {
        this.lesDameuses = new Class.LesDameuses();
    }

    @After
    public void tearDown() throws Exception {
        this.lesDameuses = null;
    }

    @Test
    public void testAjouterDameuse() throws Exception {
        Class.Traitement traitement = new Class.Traitement();
        Class.Donnees donnees = new Class.Donnees(traitement.traitement("22/12/2015 12:45:12 0 0 dam1"));
        Class.Donnees donnees1 = new Class.Donnees(traitement.traitement("22/12/2015 12:45:12 0 0 dam2"));
        Class.Dameuse dameuse = new Class.Dameuse(donnees);
        dameuse.setDonnees(donnees);
        this.lesDameuses.ajouterDameuse(dameuse);
        assertEquals(this.lesDameuses.getLesDameuses().size(),1);
        Class.Dameuse dameuse2 = new Class.Dameuse(donnees1);
        this.lesDameuses.ajouterDameuse(dameuse2);
        assertEquals(this.lesDameuses.getLesDameuses().size(),2);
    }


}