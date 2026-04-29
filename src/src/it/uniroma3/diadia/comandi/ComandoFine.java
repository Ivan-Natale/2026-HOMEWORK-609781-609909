package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
    private String parametro; // non usato
    private IO io;
    public ComandoFine() {}

    @Override
    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    @Override
    public void setIO(IO io) {
    	this.io=io;
    }
    
    @Override
    public String getNome() {
        return "fine";
    }

    @Override
    public String getParametro() {
        return null;
    }
    
    @Override
    public void esegui(Partita partita) {
        partita.setFinita();
        io.mostraMessaggio("Grazie di aver giocato!");
    }
}