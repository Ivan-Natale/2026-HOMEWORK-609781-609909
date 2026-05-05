package test;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComandoPosaTest {

    private Partita partita;
    private IOConsole io;
    private Stanza stanza;
    private Attrezzo attrezzo;

    @BeforeEach
    public void setUp() {
        this.io = new IOConsole();
        this.partita = new Partita();
        this.stanza = new Stanza("Laboratorio");
        this.partita.getLabirinto().setStanzaCorrente(this.stanza);

        this.attrezzo = new Attrezzo("chiave", 1);
        this.partita.getGiocatore().getBorsa().addAttrezzo(this.attrezzo);
    }

    @Test
    public void testPosaAttrezzoPresenteInBorsa() {
        ComandoPosa comando = new ComandoPosa();
        comando.setParametro("chiave");
        comando.setIO(io);
        comando.esegui(partita);

        assertNull(partita.getGiocatore().getBorsa().getAttrezzo("chiave"),
                   "L'attrezzo deve essere stato rimosso dalla borsa");
        assertEquals(attrezzo, stanza.getAttrezzo("chiave"),
                     "L'attrezzo deve essere stato aggiunto alla stanza");
    }

    @Test
    public void testPosaAttrezzoNonPresenteInBorsa() {
        partita.getGiocatore().getBorsa().removeAttrezzo("chiave"); // rimozione forzata prima del test

        ComandoPosa comando = new ComandoPosa();
        comando.setParametro("chiave");
        comando.setIO(io);
        comando.esegui(partita);

        assertNull(stanza.getAttrezzo("chiave"),
                   "L'attrezzo non deve essere stato aggiunto alla stanza");
    }

    @Test
    public void testPosaConParametroNull() {
        ComandoPosa comando = new ComandoPosa();
        comando.setParametro(null);
        comando.setIO(io);
        comando.esegui(partita);

        assertEquals(attrezzo, partita.getGiocatore().getBorsa().getAttrezzo("chiave"),
                     "L'attrezzo non dovrebbe essere stato rimosso senza parametro");
        assertNull(stanza.getAttrezzo("chiave"),
                   "L'attrezzo non dovrebbe essere stato posato nella stanza");
    }
}

