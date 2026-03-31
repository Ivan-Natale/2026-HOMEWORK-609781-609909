package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.giocatore.Borsa;

class BorsaTest {

    private Borsa borsa;
    private Attrezzo lanterna;
    private Attrezzo osso;
   

    @BeforeEach
    void setUp() {
        this.borsa = new Borsa();
        this.lanterna = new Attrezzo("lanterna", 3);
        this.osso = new Attrezzo("osso", 1);
    }

    @Test
    void testBorsaVuotaAllInizio() {
        assertTrue(this.borsa.isEmpty());
    }

    @Test
    void testAddAttrezzo() {
        assertTrue(this.borsa.addAttrezzo(this.lanterna));
        assertFalse(this.borsa.isEmpty());
    }


    @Test
    void testHasAttrezzo() {
        this.borsa.addAttrezzo(this.osso);

        assertTrue(this.borsa.hasAttrezzo("osso"));
    }


    @Test
    void testRemoveAttrezzo() {
        this.borsa.addAttrezzo(this.lanterna);

        assertEquals(this.lanterna, this.borsa.removeAttrezzo("lanterna"));
        assertFalse(this.borsa.hasAttrezzo("lanterna"));
    }

    
}
