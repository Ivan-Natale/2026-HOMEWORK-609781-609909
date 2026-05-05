package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;

public class DiaDiaAcceptanceTest {

    @Test
    public void testPartitaVintaAndandoSubitoInBiblioteca() {
        String[] comandi = { "vai nord" };
        IOSimulator io = new IOSimulator(comandi);

        DiaDia gioco = new DiaDia(io);
        gioco.gioca();

        assertTrue(io.contieneMessaggio("Hai vinto!"));
    }

    @Test
    public void testPartitaTerminataConComandoFine() {
        String[] comandi = { "fine" };
        IOSimulator io = new IOSimulator(comandi);

        DiaDia gioco = new DiaDia(io);
        gioco.gioca();

        assertTrue(io.contieneMessaggio("Grazie di aver giocato!"));
    }

    @Test
    public void testComandoNonValidoProduceMessaggioErrore() {
        String[] comandi = { "salta", "fine" };
        IOSimulator io = new IOSimulator(comandi);

        DiaDia gioco = new DiaDia(io);
        gioco.gioca();

        assertTrue(io.contieneMessaggio("Comando non riconosciuto"));
    }
}
