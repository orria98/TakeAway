package vinnsla;

import org.junit.Test;

import static org.junit.Assert.*;

public class KarfaTest
{

    @Test
    public void setjaGognTest()
    {
        Karfa k = new Karfa();

        Veitingar v = new Veitingar("Carbonara", 2990);
        k.setjaGogn(v);

        assertFalse(k.veitingar.isEmpty());
    }

    @Test
    public void hreinsaKorfuTest()
    {
        Karfa k = new Karfa();

        k.setjaGogn(new Veitingar("pizza", 2200));
        k.hreinsaKorfu();

        assertTrue(k.veitingar.isEmpty());
    }

    @Test
    public void takaUrKorfuTest()
    {
        Karfa k = new Karfa();

        Veitingar v1 = new Veitingar("pizza", 2000);
        Veitingar v2 = new Veitingar("Burger", 3000);

        k.setjaGogn(v1);
        k.setjaGogn(v2);

        k.takaUrKorfu(v1);

        int expected = 3000;

        assertEquals(expected, k.getHeildarverd());
    }
}
