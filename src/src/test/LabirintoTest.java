package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.Labirinto; // ✅ Uso corretto del nome

class LabirintoTest {

    @Test
    void testStanzaCorrenteNonNull() {
        Labirinto lab = new Labirinto();
        assertNotNull(lab.getStanzaCorrente());
    }

    @Test
    void testStanzaVincenteNonNull() {
        Labirinto lab = new Labirinto();
        assertNotNull(lab.getStanzaVincente());
    }

    @Test
    void testCambioStanzaCorrente() {
        Labirinto lab = new Labirinto();
        Stanza nuova = new Stanza("Segreteria");
        lab.setStanzaCorrente(nuova);
        assertEquals("Segreteria", lab.getStanzaCorrente().getNome());
    }
}
