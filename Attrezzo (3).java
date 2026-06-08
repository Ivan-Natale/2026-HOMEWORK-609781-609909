package it.uniroma3.diadia.ambienti;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 *
 * Versione HWC: le collezioni di stanze adiacenti e attrezzi non sono piu'
 * implementate con array, ma con Map del Java Collection Framework.
 */
public class Stanza {

    private String nome;
    private Map<String, Attrezzo> attrezzi;
    private Map<String, Stanza> stanzeAdiacenti;

    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.attrezzi = new LinkedHashMap<>();
        this.stanzeAdiacenti = new LinkedHashMap<>();
    }

    /**
     * Imposta una stanza adiacente nella direzione indicata.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        this.stanzeAdiacenti.put(direzione, stanza);
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata.
     */
    public Stanza getStanzaAdiacente(String direzione) {
        return this.stanzeAdiacenti.get(direzione);
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce una vista non modificabile degli attrezzi presenti.
     */
    public Collection<Attrezzo> getAttrezzi() {
        return Collections.unmodifiableCollection(this.attrezzi.values());
    }

    /**
     * Mette un attrezzo nella stanza.
     * Si assume che, nello stesso labirinto, non esistano due attrezzi con lo
     * stesso nome: la mappa usa il nome come chiave.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (attrezzo == null)
            return false;
        this.attrezzi.put(attrezzo.getNome(), attrezzo);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder risultato = new StringBuilder();
        risultato.append(this.nome);
        risultato.append("\nUscite: ");
        risultato.append(String.join(" ", this.stanzeAdiacenti.keySet()));
        risultato.append("\nAttrezzi nella stanza: ");
        for (Attrezzo attrezzo : this.attrezzi.values())
            risultato.append(attrezzo).append(" ");
        return risultato.toString();
    }

    /**
     * Controlla se un attrezzo esiste nella stanza, cercandolo per nome.
     */
    public boolean hasAttrezzo(String nomeAttrezzo) {
        return this.attrezzi.containsKey(nomeAttrezzo);
    }

    /**
     * Restituisce l'attrezzo con il nome indicato, se presente.
     */
    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        return this.attrezzi.get(nomeAttrezzo);
    }

    /**
     * Rimuove un attrezzo dalla stanza.
     */
    public boolean removeAttrezzo(Attrezzo attrezzo) {
        if (attrezzo == null)
            return false;
        return this.attrezzi.remove(attrezzo.getNome(), attrezzo);
    }

    /**
     * Restituisce le direzioni disponibili.
     */
    public Set<String> getDirezioni() {
        return Collections.unmodifiableSet(this.stanzeAdiacenti.keySet());
    }
}
