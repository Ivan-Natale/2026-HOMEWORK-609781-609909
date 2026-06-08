package it.uniroma3.diadia.ambienti;

import java.util.LinkedHashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Builder per costruire oggetti Labirinto con method chaining.
 */
public class LabirintoBuilder {

    private Labirinto labirinto;
    private Map<String, Stanza> stanze;
    private Stanza ultimaStanzaAggiunta;

    public LabirintoBuilder() {
        this.labirinto = new Labirinto(false);
        this.stanze = new LinkedHashMap<>();
    }

    public LabirintoBuilder addStanza(String nome) {
        this.ultimaStanzaAggiunta = this.getOCreaStanza(nome);
        return this;
    }

    public LabirintoBuilder addStanzaIniziale(String nome) {
        Stanza stanza = this.getOCreaStanza(nome);
        this.labirinto.setStanzaCorrente(stanza);
        this.ultimaStanzaAggiunta = stanza;
        return this;
    }

    public LabirintoBuilder addStanzaVincente(String nome) {
        Stanza stanza = this.getOCreaStanza(nome);
        this.labirinto.setStanzaVincente(stanza);
        this.ultimaStanzaAggiunta = stanza;
        return this;
    }

    public LabirintoBuilder addStanzaBuia(String nome, String nomeAttrezzoLuminoso) {
        return this.addStanzaSpeciale(new StanzaBuia(nome, nomeAttrezzoLuminoso));
    }

    public LabirintoBuilder addStanzaBloccata(String nome, String direzioneBloccata, String nomeAttrezzoSbloccante) {
        return this.addStanzaSpeciale(new StanzaBloccata(nome, direzioneBloccata, nomeAttrezzoSbloccante));
    }

    public LabirintoBuilder addStanzaMagica(String nome) {
        return this.addStanzaSpeciale(new StanzaMagica(nome));
    }

    public LabirintoBuilder addStanzaMagica(String nome, int sogliaMagica) {
        return this.addStanzaSpeciale(new StanzaMagica(nome, sogliaMagica));
    }

    public LabirintoBuilder addAdiacenza(String nomeStanzaPartenza, String nomeStanzaArrivo, String direzione) {
        Stanza partenza = this.getOCreaStanza(nomeStanzaPartenza);
        Stanza arrivo = this.getOCreaStanza(nomeStanzaArrivo);
        partenza.impostaStanzaAdiacente(direzione, arrivo);
        return this;
    }

    public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
        if (this.ultimaStanzaAggiunta == null)
            throw new IllegalStateException("Nessuna stanza a cui aggiungere l'attrezzo");
        this.ultimaStanzaAggiunta.addAttrezzo(new Attrezzo(nomeAttrezzo, peso));
        return this;
    }

    public Labirinto getLabirinto() {
        return this.labirinto;
    }

    private LabirintoBuilder addStanzaSpeciale(Stanza stanza) {
        this.stanze.put(stanza.getNome(), stanza);
        this.ultimaStanzaAggiunta = stanza;
        return this;
    }

    private Stanza getOCreaStanza(String nome) {
        return this.stanze.computeIfAbsent(nome, Stanza::new);
    }
}
