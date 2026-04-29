package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.giocatore.Giocatore; 
class GiocatoreTest {

    @Test
    void testCfuIniziali() {
        Giocatore g = new Giocatore();
        assertEquals(20, g.getCfu());
    }

    @Test
    void testSetCfu() {
        Giocatore g = new Giocatore();
        g.setCfu(10);
        assertEquals(10, g.getCfu());
    }
}


