import Class.Traitement;
import org.junit.After;
import org.junit.Before;

import java.util.List;

import static org.junit.Assert.assertEquals;

import Class.Traitement;
/**
 * Created by Fabienne_2 on 14/11/2015.
 */
public class TraitementTest {

    private Traitement traitement;

    @Before
    public void setUp() {
        traitement = new Traitement();
    }

    @After
    public void tearDown() {
        traitement = null;
    }

    @org.junit.Test
    public void testTraiment (){
        List<String> listChaine = traitement.traitement("145545114 44515452144411 10000 23");
        assertEquals(listChaine.get(0),"145545114");
        assertEquals(listChaine.get(1),"44515452144411");
        assertEquals(listChaine.get(2),"10000");
        assertEquals(listChaine.get(3),"23");
    }
}