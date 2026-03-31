package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.diadia.Partita;

import org.junit.jupiter.api.Test;

class PartitaTest {
    
	private Partita partita;
	
	@BeforeEach
	void setUp() {
        this.partita = new Partita();
    }

  
    @Test
    void testPartitaNonFinitaAllInizio() {
        assertFalse(this.partita.isFinita());
    }

   
    @Test
    void testPartitaFinitaPerCfuZero() {
        this.partita.setCfu(0);
        assertTrue(this.partita.isFinita());
    }

    
    @Test
    void testPartitaVinta() {
        Stanza vincente = this.partita.getStanzaVincente();
        this.partita.setStanzaCorrente(vincente);

        assertTrue(this.partita.vinta());
        assertTrue(this.partita.isFinita()); // bonus: controlla anche fine partita
    }

}
