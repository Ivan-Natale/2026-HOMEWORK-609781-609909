package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.ambienti.Labirinto;

public class ComandoVaiTest {
    private Partita partita;
    private Stanza stanzaIniziale, stanzaNord;

    @BeforeEach
    public void setUp() {
        stanzaIniziale = new Stanza("aula");
        stanzaNord = new Stanza("biblioteca");
        stanzaIniziale.impostaStanzaAdiacente("nord", stanzaNord);

        Labirinto labirinto = new Labirinto();
        labirinto.setStanzaCorrente(stanzaIniziale);

        partita = new Partita();
        partita.getLabirinto().setStanzaCorrente(stanzaIniziale);

    }

    @Test
    public void testVaiADirezioneValida() {
        ComandoVai comando = new ComandoVai();
        comando.setParametro("nord");
        comando.esegui(partita);

        assertEquals("biblioteca", partita.getLabirinto().getStanzaCorrente().getNome());
    }

    @Test
    public void testVaiADirezioneInesistente() {
        ComandoVai comando = new ComandoVai();
        comando.setParametro("sud");
        comando.esegui(partita);

        assertEquals("aula", partita.getLabirinto().getStanzaCorrente().getNome());
    }
}