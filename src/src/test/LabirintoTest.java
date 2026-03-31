package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.ambienti.Labirinto;
import it.uniroma3.ambienti.Stanza;

class LabirintoTest {

    private Labirinto labirinto;

    @BeforeEach
    void setUp() {
        this.labirinto = new Labirinto();
    }

    @Test
    void testStanzaInizialeNonNull() {
        assertNotNull(this.labirinto.getStanzaIniziale());
    }

    @Test
    void testStanzaFinaleNonNull() {
        assertNotNull(this.labirinto.getStanzaFinale());
    }

    @Test
    void testNomeStanzaIniziale() {
        assertEquals("Atrio", this.labirinto.getStanzaIniziale().getNome());
    }

    @Test
    void testNomeStanzaFinale() {
        assertEquals("Biblioteca", this.labirinto.getStanzaFinale().getNome());
    }

    @Test
    void testCollegamentoAtrioNordBiblioteca() {
        Stanza atrio = this.labirinto.getStanzaIniziale();
        assertEquals("Biblioteca", atrio.getStanzaAdiacente("nord").getNome());
    }
}