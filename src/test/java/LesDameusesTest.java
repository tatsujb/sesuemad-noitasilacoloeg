import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Class.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Fabienne_2 on 14/11/2015.
 */
public class LesDameusesTest {

    private LesDameuses lesDameuses;

    @Before
    public void setUp() throws Exception {
        this.lesDameuses = new LesDameuses();
    }

    @After
    public void tearDown() throws Exception {
        this.lesDameuses = null;
    }

    @Test
    public void testAjouterDameuse() throws Exception {
        Traitement traitement = new Traitement();
        Donnees donnees = new Donnees(traitement.traitement("22/12/2015 12:45:12 0 0 dam1"));
        Donnees donnees1 = new Donnees(traitement.traitement("22/12/2015 12:45:12 0 0 dam2"));
        Dameuse dameuse = new Dameuse(donnees);
        dameuse.setDonnees(donnees);
        this.lesDameuses.ajouterDameuse(dameuse);
        assertEquals(this.lesDameuses.getLesDameuses().size(),1);
        Dameuse dameuse2 = new Dameuse(donnees1);
        this.lesDameuses.ajouterDameuse(dameuse2);
        assertEquals(this.lesDameuses.getLesDameuses().size(),2);
    }


}