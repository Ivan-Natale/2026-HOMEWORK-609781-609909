package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {
	private IO io;
    public ComandoNonValido() {}

    @Override
    public void setParametro(String parametro) {
        // Non fa nulla
    }

    @Override
    public void setIO(IO io) {
    	this.io=io;
    }
    
    @Override
    public String getNome() {
        return "nonvalido";
    }

    @Override
    public String getParametro() {
        return null;
    }
    
    @Override
    public void esegui(Partita partita) {
    	io.mostraMessaggio("Comando non riconosciuto.");
    }
}