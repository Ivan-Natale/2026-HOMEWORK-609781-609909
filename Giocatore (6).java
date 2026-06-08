package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IONull;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
    private String nomeAttrezzo;
    private IO io = new IONull();
    public ComandoPrendi() {}

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
        return "prendi";
    }

    @Override
    public String getParametro() {
        return this.nomeAttrezzo;
    }
    
    @Override
    public void esegui(Partita partita) {
        if (nomeAttrezzo == null) {
        	io.mostraMessaggio("Che attrezzo vuoi prendere?");
            return;
        }

        Attrezzo attrezzo = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
        if (attrezzo != null) {
            if (partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
                partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attrezzo);
                io.mostraMessaggio("Hai preso: " + nomeAttrezzo);
            } else {
            	io.mostraMessaggio("La borsa è piena o troppo pesante.");
            }
        } else {
        	io.mostraMessaggio("Attrezzo non trovato nella stanza.");
        }
    }
}