package test;
import it.uniroma3.ambienti.Stanza;
import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.diadia.*;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class StanzaTest {
	
    private Stanza stanza;
    private Stanza stanzaNord;
    private Stanza stanzaSud;
    private Attrezzo osso;
    private Attrezzo lanterna;
    
    @BeforeEach
    public void setUp() {
    	this.stanza= new Stanza("Atrio");
    	this.stanzaNord= new Stanza("Bagno");
    	this.stanzaSud= new Stanza("Sala");
    	this.osso = new Attrezzo("osso", 1);
    	this.lanterna= new Attrezzo("lanterna",3);
    }
	
	

	@Test
	void testimpostastanzaadiacente() {
		this.stanza.impostaStanzaAdiacente("nord", this.stanzaNord);
		assertEquals(this.stanza.getStanzaAdiacente("nord"), this.stanzaNord);
	}
	
	
	@Test
	void testgetattrezzo() {
		this.stanza.addAttrezzo(this.lanterna);
		assertEquals(this.stanza.getAttrezzo("lanterna"), this.lanterna);
	}
	
	
	@Test
	void testhasattrezzo() {
		this.stanza.addAttrezzo(this.lanterna);
		assertEquals(this.stanza.hasAttrezzo("lanterna"), true);
	}

}
