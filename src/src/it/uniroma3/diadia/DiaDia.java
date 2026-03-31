package it.uniroma3.diadia;


import it.uniroma3.ambienti.Stanza;
import it.uniroma3.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "prendi", "posa", "fine"};

	private Partita partita;
    private IOConsole io;
    
	public DiaDia(IOConsole io) {
		this.partita = new Partita();
		this.io=io;
	}

	public void gioca() {
		String istruzione; 
		

		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
				
		do		
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			this.io.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			this.io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			this.io.mostraMessaggio(elencoComandi[i]+" ");
		this.io.mostraMessaggio("");
	}

	
	private void prendi(String NomeAttrezzo) {
		if (NomeAttrezzo == null) {
			this.io.mostraMessaggio("Quale attrezzo vuoi prendere?");
            return;
        }

        Stanza stanzaCorrente = this.partita.getStanzaCorrente();
        Attrezzo attrezzo = stanzaCorrente.getAttrezzo(NomeAttrezzo);

        if (attrezzo == null) {
        	this.io.mostraMessaggio("Attrezzo non presente nella stanza.");
            return;
        }

        boolean aggiunto = this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);

        if (aggiunto) {
            stanzaCorrente.removeAttrezzo(attrezzo);
            this.io.mostraMessaggio("Hai preso: " + NomeAttrezzo);
            this.io.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
        } else {
        	this.io.mostraMessaggio("Non puoi prendere l'attrezzo: borsa piena o peso eccessivo.");
        }
	}
	
	
    private void posa(String NomeAttrezzo) {
    	 if (NomeAttrezzo == null) {
    		 this.io.mostraMessaggio("Quale attrezzo vuoi posare?");
             return;
         }

         Attrezzo attrezzo = this.partita.getGiocatore().getBorsa().removeAttrezzo(NomeAttrezzo);

         if (attrezzo == null) {
        	 this.io.mostraMessaggio("Attrezzo non presente nella borsa.");
             return;
         }

         boolean rimosso = this.partita.getStanzaCorrente().addAttrezzo(attrezzo);

         if (rimosso) {
        	 this.io.mostraMessaggio("Hai posato: " + NomeAttrezzo);
         } else {
             this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
             this.io.mostraMessaggio("Non puoi posare l'attrezzo: stanza piena.");
         }
	}
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			this.io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getCfu();
			this.partita.setCfu(cfu-1);
		}
		this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.io.mostraMessaggio("Grazie per aver giocato, alla prossima");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole io= new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}