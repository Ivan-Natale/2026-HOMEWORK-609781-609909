package it.uniroma3.ambienti;

import it.uniroma3.attrezzi.Attrezzo;

/**
 * Questa classe rappresenta il labirinto del gioco.
 * Ha la responsabilità di creare le stanze e memorizzare
 * la stanza iniziale e quella finale.
 */
public class Labirinto {

    private Stanza stanzaIniziale;
    private Stanza stanzaFinale;

    /**
     * Costruttore: crea il labirinto
     */
    public Labirinto() {
        this.creaLabirinto();
    }

    /**
     * Metodo che crea le stanze, le collega e inserisce gli attrezzi
     */
    private void creaLabirinto() {

        /* crea gli attrezzi */
        Attrezzo lanterna = new Attrezzo("lanterna", 3);
        Attrezzo osso = new Attrezzo("osso", 1);

        /* crea le stanze */
        Stanza atrio = new Stanza("Atrio");
        Stanza aulaN11 = new Stanza("Aula N11");
        Stanza aulaN10 = new Stanza("Aula N10");
        Stanza laboratorio = new Stanza("Laboratorio Campus");
        Stanza biblioteca = new Stanza("Biblioteca");

        /* collega le stanze */
        atrio.impostaStanzaAdiacente("nord", biblioteca);
        atrio.impostaStanzaAdiacente("est", aulaN11);
        atrio.impostaStanzaAdiacente("sud", aulaN10);
        atrio.impostaStanzaAdiacente("ovest", laboratorio);

        aulaN11.impostaStanzaAdiacente("est", laboratorio);
        aulaN11.impostaStanzaAdiacente("ovest", atrio);

        aulaN10.impostaStanzaAdiacente("nord", atrio);
        aulaN10.impostaStanzaAdiacente("est", aulaN11);
        aulaN10.impostaStanzaAdiacente("ovest", laboratorio);

        laboratorio.impostaStanzaAdiacente("est", atrio);
        laboratorio.impostaStanzaAdiacente("ovest", aulaN11);

        biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* inserisce gli attrezzi */
        aulaN10.addAttrezzo(lanterna);
        atrio.addAttrezzo(osso);

        /* definisce entrata e uscita */
        this.stanzaIniziale = atrio;
        this.stanzaFinale = biblioteca;
    }

    /**
     * Restituisce la stanza iniziale
     */
    public Stanza getStanzaIniziale() {
        return this.stanzaIniziale;
    }

    /**
     * Restituisce la stanza finale (vincente)
     */
    public Stanza getStanzaFinale() {
        return this.stanzaFinale;
    }
}