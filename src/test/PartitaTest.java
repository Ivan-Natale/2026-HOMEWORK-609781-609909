package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.*;

class PartitaTest {

    @Test
    void testPartitaNonFinitaInizialmente() {
        Partita partita = new Partita();
        assertFalse(partita.isFinita());
    }

    @Test
    void testPartitaVinta() {
        Partita partita = new Partita();
        partita.getLabirinto().setStanzaCorrente(partita.getLabirinto().getStanzaVincente());
        assertTrue(partita.vinta());
    }

    @Test
    void testSetFinita() {
        Partita partita = new Partita();
        partita.setFinita();
        assertTrue(partita.isFinita());
    }
}

