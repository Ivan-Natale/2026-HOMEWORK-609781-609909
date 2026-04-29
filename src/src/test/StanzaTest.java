package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {

    private Stanza stanza;
    private Attrezzo osso;

    @BeforeEach
    void setUp() {
        stanza = new Stanza("Atrio");
        osso = new Attrezzo("osso", 1);
    }

    @Test
    void testAddAttrezzo() {
        assertTrue(stanza.addAttrezzo(osso));
        assertTrue(stanza.hasAttrezzo("osso"));
    }

    @Test
    void testGetAttrezzo() {
        stanza.addAttrezzo(osso);
        assertEquals(osso, stanza.getAttrezzo("osso"));
    }

    @Test
    void testGetStanzaAdiacente() {
        Stanza biblioteca = new Stanza("Biblioteca");
        stanza.impostaStanzaAdiacente("nord", biblioteca);
        assertEquals(biblioteca, stanza.getStanzaAdiacente("nord"));
    }

    @Test
    void testHasAttrezzoFalse() {
        assertFalse(stanza.hasAttrezzo("lanterna"));
    }
}

