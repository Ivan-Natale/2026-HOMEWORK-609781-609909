package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IONull;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
    private String nomeAttrezzo;
    private IO io = new IONull();
    public ComandoPosa() {
        // Costruttore vuoto obbligatorio per la fabbrica
    }

    @Override
    public void setParametro(String parametro) {
        this.nomeAttrezzo = parametro;
    }
    
    @Override
    public void setIO(IO io) {
    	this.io=io;
    }
    
    @Override
    public String getNome() {
        return "posa";
    }

    @Override
    public String getParametro() {
        return this.nomeAttrezzo;
    }
    
    @Override
    public void esegui(Partita partita) {
        if (nomeAttrezzo == null) {
        	io.mostraMessaggio("Che attrezzo vuoi posare?");
            return;
        }

        Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
        if (attrezzo != null) {
            partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
            partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
            io.mostraMessaggio("Hai posato: " + nomeAttrezzo);
        } else {
        	io.mostraMessaggio("Attrezzo non presente nella borsa.");
        }
    }
}