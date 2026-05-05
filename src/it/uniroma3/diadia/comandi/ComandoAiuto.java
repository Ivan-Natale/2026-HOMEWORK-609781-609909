package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
    private String parametro; // non usato
    private IO io;
    
    public ComandoAiuto() {}

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
        return "aiuto";
    }

    @Override
    public String getParametro() {
        return null;
    }
    
    
    @Override
    public void esegui(Partita partita) {
        io.mostraMessaggio("Comandi disponibili: vai, prendi, posa, aiuto, fine, guarda");
    }
}
