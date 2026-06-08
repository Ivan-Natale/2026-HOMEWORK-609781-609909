package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IONull;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
    private String direzione;
    private IO io = new IONull();
   
    
    public ComandoVai() {
        // costruttore vuoto per la fabbrica
    }

    
    @Override
    public String getNome() {
        return "vai";
    }

    @Override
    public String getParametro() {
        return this.direzione;
    }
    
    
    @Override
    public void setParametro(String parametro) {
        this.direzione = parametro;
    }
    
    @Override
    public void setIO(IO io) {
    	this.io=io;
    }
    @Override
    public void esegui(Partita partita) {
        if (direzione == null) {
        	io.mostraMessaggio("Dove vuoi andare?");
            return;
        }

        Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
        Stanza prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);

        if (prossimaStanza == null) {
        	io.mostraMessaggio("Direzione inesistente.");
        } else {
            partita.getLabirinto().setStanzaCorrente(prossimaStanza);
            partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
            io.mostraMessaggio(prossimaStanza.getDescrizione());
        }
    }
}