package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {

    private Borsa borsa;
    private Attrezzo attrezzo;

    @BeforeEach
    void setUp() {
        borsa = new Borsa();
        attrezzo = new Attrezzo("osso", 1);
    }

    @Test
    void testAddAttrezzo() {
        assertTrue(borsa.addAttrezzo(attrezzo));
    }

    @Test
    void testHasAttrezzo() {
        borsa.addAttrezzo(attrezzo);
        assertTrue(borsa.hasAttrezzo("osso"));
    }

    @Test
    void testGetPeso() {
        borsa.addAttrezzo(attrezzo);
        assertEquals(1, borsa.getPeso());
    }

    @Test
    void testIsEmpty() {
        assertTrue(borsa.isEmpty());
    }
}

