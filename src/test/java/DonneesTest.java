import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fabienne_2 on 14/11/2015.
 */
public class DonneesTest {

    private Donnees donnees;
    private  Traitement traitement;

    @Before
    public void setUp() {
        this.traitement = new Traitement();
        List<String> t = traitement.traitement("10/12/2015 12:45:12 0 0 dam1");
        this.donnees = new Donnees(t);
    }

    @After
    public void tearDown() {
        this.donnees = null;
    }

    @org.junit.Test
    public void testGetLattitude(){
        assertEquals(this.donnees.getLattitude(),"0");
    }

    @org.junit.Test
    public void testGetLongitude() {
        assertEquals(this.donnees.getLongitude(),"0");
    }

    @org.junit.Test
    public void testSetLattitude(){
        donnees.setLattitude("10");
        assertEquals(this.donnees.getLattitude(),"10");
    }

    @org.junit.Test
    public void testSetLongitude() {
        donnees.setLongitude("10");
        assertEquals(this.donnees.getLongitude(),"10");
    }

    @org.junit.Test
    public void testToString() {
        assertEquals(this.donnees.toString(),"10/12/2015 12:45:12 0 0 dam1");
    }

    @Test
    public void testSetHeure(){
        donnees.setHeure("14:25:45");
        assertEquals(this.donnees.getHeure(),"14:25:45");
    }

    @Test
    public void testSetDate() throws Exception {
        donnees.setDate("14/11/2015");
        assertEquals(this.donnees.getDate(),"14/11/2015");
    }

    @Test
    public void testGetHeure() throws Exception {
        assertEquals(this.donnees.getHeure(),"12:45:12");
    }

    @Test
    public void testGetDate() throws Exception {
        assertEquals(this.donnees.getDate(),"10/12/2015");
    }

    @Test
    public void testGetIdentifiant() throws Exception {
        assertEquals(this.donnees.getIdentifiantDameuse(),"dam1");
    }
}