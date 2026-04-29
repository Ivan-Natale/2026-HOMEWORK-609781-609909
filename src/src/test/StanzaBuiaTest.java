package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.*;

public class StanzaBuiaTest {

    private StanzaBuia stanzaBuia;
    private static final String ATTREZZO_LUCE = "lanterna";

    @BeforeEach
    public void setUp() {
        stanzaBuia = new StanzaBuia("Cantina", ATTREZZO_LUCE);
    }

    @Test
    public void testDescrizioneSenzaAttrezzo() {
        assertEquals("qui c'è un buio pesto", stanzaBuia.getDescrizione());
    }

    @Test
    public void testDescrizioneConAttrezzo() {
        stanzaBuia.addAttrezzo(new Attrezzo(ATTREZZO_LUCE, 1));
        assertTrue(stanzaBuia.getDescrizione().contains("Cantina")); // usa super.getDescrizione()
    }
}
