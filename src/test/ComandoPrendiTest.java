package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;

public class ComandoPrendiTest {

    private Partita partita;
    private IOConsole io;
    private Stanza stanza;
    private Attrezzo attrezzo;

    @BeforeEach
    public void setUp() {
        io = new IOConsole();
        partita = new Partita();
        stanza = new Stanza("Aula");
        attrezzo = new Attrezzo("libro", 1);

        stanza.addAttrezzo(attrezzo);
        partita.getLabirinto().setStanzaCorrente(stanza);
    }

    @Test
    public void testAttrezzoPresoCorrettamente() {
        ComandoPrendi comando = new ComandoPrendi();
        comando.setParametro("libro");
        comando.setIO(io);
        comando.esegui(partita);

        assertNull(stanza.getAttrezzo("libro"));
        assertEquals(attrezzo, partita.getGiocatore().getBorsa().getAttrezzo("libro"));
    }

    @Test
    public void testAttrezzoNonPresente() {
    	Attrezzo daRimuovere = stanza.getAttrezzo("libro");
    	stanza.removeAttrezzo(daRimuovere);

        ComandoPrendi comando = new ComandoPrendi();
        comando.setParametro("libro");
        comando.setIO(io);
        comando.esegui(partita);

        assertNull(partita.getGiocatore().getBorsa().getAttrezzo("libro"));
    }

    @Test
    public void testParametroNull() {
        ComandoPrendi comando = new ComandoPrendi();
        comando.setParametro(null);
        comando.setIO(io);
        comando.esegui(partita);

        assertTrue(partita.getGiocatore().getBorsa().isEmpty());
    }
}