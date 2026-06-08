package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaProtected {

    protected static final int NUMERO_MASSIMO_DIREZIONI = 4;
    protected static final int NUMERO_MASSIMO_ATTREZZI = 10;

    protected String nome;
    protected Attrezzo[] attrezzi;
    protected int numeroAttrezzi;

    protected Stanza[] stanzeAdiacenti;
    protected int numeroStanzeAdiacenti;

    protected String[] direzioni;

    public StanzaProtected(String nome) {
        this.nome = nome;
        this.numeroStanzeAdiacenti = 0;
        this.numeroAttrezzi = 0;
        this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
        this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
        this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
    }

    public String getNome() {
        return this.nome;
    }

    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
            this.attrezzi[numeroAttrezzi++] = attrezzo;
            return true;
        }
        return false;
    }

    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        for (Attrezzo a : attrezzi) {
            if (a != null && a.getNome().equals(nomeAttrezzo))
                return a;
        }
        return null;
    }

    public boolean hasAttrezzo(String nomeAttrezzo) {
        return getAttrezzo(nomeAttrezzo) != null;
    }

    public boolean removeAttrezzo(Attrezzo attrezzo) {
        for (int i = 0; i < this.numeroAttrezzi; i++) {
            if (this.attrezzi[i] != null && this.attrezzi[i].equals(attrezzo)) {
                for (int j = i; j < numeroAttrezzi - 1; j++)
                    this.attrezzi[j] = this.attrezzi[j + 1];
                this.attrezzi[--numeroAttrezzi] = null;
                return true;
            }
        }
        return false;
    }

    public String[] getDirezioni() {
        String[] direzioniValide = new String[this.numeroStanzeAdiacenti];
        for (int i = 0; i < this.numeroStanzeAdiacenti; i++)
            direzioniValide[i] = this.direzioni[i];
        return direzioniValide;
    }

    public String getDescrizione() {
        return this.toString();
    }

    public String toString() {
        StringBuilder risultato = new StringBuilder();
        risultato.append(this.nome).append("\nUscite: ");
        for (String dir : this.direzioni)
            if (dir != null)
                risultato.append(dir).append(" ");
        risultato.append("\nAttrezzi nella stanza: ");
        for (Attrezzo a : this.attrezzi)
            if (a != null)
                risultato.append(a.toString()).append(" ");
        return risultato.toString();
    }
}
