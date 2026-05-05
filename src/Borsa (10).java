package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
    private String parametro;
    private IO io;
    public ComandoGuarda() {}

    @Override
    public void setParametro(String parametro) {
        this.parametro = parametro; // Ignorato, ma mantenuto per coerenza
    }

    @Override
    public void setIO(IO io) {
    	this.io=io;
    }
    
    @Override
    public String getNome() {
        return "guarda";
    }

    @Override
    public String getParametro() {
        return null;
    }
    
    @Override
    public void esegui(Partita partita) {
        io.mostraMessaggio("CFU: " + partita.getGiocatore().getCfu());
        io.mostraMessaggio("Stanza corrente: " + partita.getLabirinto().getStanzaCorrente().getDescrizione());
        io.mostraMessaggio("Contenuto borsa: " + partita.getGiocatore().getBorsa());
    }
}