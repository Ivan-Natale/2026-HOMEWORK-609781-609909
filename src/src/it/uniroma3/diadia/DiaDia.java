package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class DiaDia {

    static final private String MESSAGGIO_BENVENUTO = ""
        + "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
        + "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
        + "I locali sono popolati da strani personaggi, alcuni amici, altri... chissa!\n"
        + "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
        + "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n"
        + "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
        + "Per conoscere le istruzioni usa il comando 'aiuto'.";

    private Partita partita;
    private IO io;

    public DiaDia(IO io) {
        this.partita = new Partita();
        this.io = new IOConsole();
    }

    public void gioca() {
        String istruzione;
        Scanner scannerDiLinee = new Scanner(System.in);

        io.mostraMessaggio(MESSAGGIO_BENVENUTO);
        do {
            istruzione = scannerDiLinee.nextLine();
        } while (!processaIstruzione(istruzione));
    }

    private boolean processaIstruzione(String istruzione) {
        FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica(this.io);
        Comando comandoDaEseguire = factory.costruisciComando(istruzione);
        comandoDaEseguire.esegui(this.partita);

        io.mostraMessaggio("CFU rimasti: " + this.partita.getGiocatore().getCfu());
        io.mostraMessaggio("Contenuto borsa: " + this.partita.getGiocatore().getBorsa().toString());
        if (this.partita.vinta())
            this.io.mostraMessaggio("Hai vinto!");
        if (!this.partita.giocatoreIsVivo())
            this.io.mostraMessaggio("Hai esaurito i CFU...");
        return this.partita.isFinita();
    }


    public static void main(String[] argc) {
    	IO io = new IOConsole();
        DiaDia gioco = new DiaDia(io);
        gioco.gioca();
    }
}
