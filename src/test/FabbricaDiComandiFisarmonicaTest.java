package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class FabbricaDiComandiFisarmonicaTest {
    private IO io;
    private FabbricaDiComandi factory;

    @BeforeEach
    public void setUp() {
        factory = new FabbricaDiComandiFisarmonica(this.io);
    }

    @Test
    public void testComandoVaiConParametro() {
        Comando comando = factory.costruisciComando("vai nord");
        assertEquals("vai", comando.getNome());
        assertEquals("nord", comando.getParametro());
    }

    @Test
    public void testComandoPrendiConParametro() {
        Comando comando = factory.costruisciComando("prendi chiave");
        assertEquals("prendi", comando.getNome());
        assertEquals("chiave", comando.getParametro());
    }

    @Test
    public void testComandoPosaSenzaParametro() {
        Comando comando = factory.costruisciComando("posa");
        assertEquals("posa", comando.getNome());
        assertNull(comando.getParametro());
    }

    @Test
    public void testComandoNonValido() {
        Comando comando = factory.costruisciComando("banana");
        assertEquals("nonvalido", comando.getNome()); // assicurati che ComandoNonValido.getNome() restituisca "nonvalido"
    }
}