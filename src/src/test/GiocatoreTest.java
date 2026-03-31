package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.giocatore.Borsa;
import it.uniroma3.giocatore.Giocatore;

class GiocatoreTest {

    private Giocatore giocatore;

    @BeforeEach
    void setUp() {
        this.giocatore = new Giocatore(20);
    }

    @Test
    void testCfuIniziali() {
        assertEquals(20, this.giocatore.getCfu());
    }

    @Test
    void testSetCfu() {
        this.giocatore.setCfu(10);
        assertEquals(10, this.giocatore.getCfu());
    }

    @Test
    void testBorsaNonNull() {
        assertNotNull(this.giocatore.getBorsa());
    }

    @Test
    void testBorsaInizialmenteVuota() {
        assertTrue(this.giocatore.getBorsa().isEmpty());
    }

    @Test
    void testSetBorsa() {
        Borsa nuovaBorsa = new Borsa(15);
        this.giocatore.setBorsa(nuovaBorsa);

        assertEquals(nuovaBorsa, this.giocatore.getBorsa());
    }
}