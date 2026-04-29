package test;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

    private StanzaBloccata stanzaBloccata;
    private Stanza stanzaNord;
    private static final String DIREZIONE_BLOCCATA = "nord";
    private static final String ATTREZZO_SBLOCCANTE = "passepartout";

    @BeforeEach
    public void setUp() {
        stanzaBloccata = new StanzaBloccata("Prigione", DIREZIONE_BLOCCATA, ATTREZZO_SBLOCCANTE);
        stanzaNord = new Stanza("Corridoio");

        stanzaBloccata.impostaStanzaAdiacente("nord", stanzaNord);
    }

    @Test
    public void testGetStanzaAdiacente_bloccataSenzaAttrezzo() {
        // Se manca l'attrezzo, dovrebbe restituire sé stessa
        assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("nord"));
    }

    @Test
    public void testGetStanzaAdiacente_sbloccataConAttrezzo() {
        stanzaBloccata.addAttrezzo(new Attrezzo(ATTREZZO_SBLOCCANTE, 1));
        assertEquals(stanzaNord, stanzaBloccata.getStanzaAdiacente("nord"));
    }

    @Test
    public void testGetDescrizione_bloccata() {
        String descrizione = stanzaBloccata.getDescrizione();
        assertTrue(descrizione.contains("bloccata"));
    }

    @Test
    public void testGetDescrizione_sbloccata() {
        stanzaBloccata.addAttrezzo(new Attrezzo(ATTREZZO_SBLOCCANTE, 1));
        String descrizione = stanzaBloccata.getDescrizione();
        assertFalse(descrizione.contains("bloccata"));
    }
}
