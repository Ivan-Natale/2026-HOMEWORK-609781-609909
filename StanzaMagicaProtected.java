package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.giocatore.Giocatore;

public class Partita {

    private Giocatore giocatore;
    private Labirinto labirinto;
    private boolean finita;

    public Partita() {
        this(new Labirinto());
    }

    public Partita(Labirinto labirinto) {
        this.labirinto = labirinto;
        this.giocatore = new Giocatore();
        this.finita = false;
    }

    public Giocatore getGiocatore() {
        return this.giocatore;
    }

    public Labirinto getLabirinto() {
        return this.labirinto;
    }

    public void setLabirinto(Labirinto labirinto) {
        this.labirinto = labirinto;
    }

    public boolean vinta() {
        return this.labirinto.getStanzaCorrente() == this.labirinto.getStanzaVincente();
    }

    public boolean giocatoreIsVivo() {
        return this.giocatore.getCfu() > 0;
    }

    public boolean isFinita() {
        return this.finita || this.vinta() || !this.giocatoreIsVivo();
    }

    public void setFinita() {
        this.finita = true;
    }

    @Override
    public String toString() {
        return this.labirinto.getStanzaCorrente() + "\nCfu: " + this.giocatore.getCfu();
    }
}
