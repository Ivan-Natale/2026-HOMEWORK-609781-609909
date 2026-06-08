package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
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
    private FabbricaDiComandi factory;

    public DiaDia(IO io) {
        this(new Labirinto(), io);
    }

    public DiaDia(Labirinto labirinto, IO io) {
        this.partita = new Partita(labirinto);
        this.io = io;
        this.factory = new FabbricaDiComandiFisarmonica(this.io);
    }

    public void gioca() {
        String istruzione;

        this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
        do {
            istruzione = this.io.leggiRiga();
        } while (!processaIstruzione(istruzione));
    }

    private boolean processaIstruzione(String istruzione) {
        Comando comandoDaEseguire = this.factory.costruisciComando(istruzione);
        comandoDaEseguire.esegui(this.partita);

        this.io.mostraMessaggio("CFU rimasti: " + this.partita.getGiocatore().getCfu());
        this.io.mostraMessaggio("Contenuto borsa: " + this.partita.getGiocatore().getBorsa());

        if (this.partita.vinta())
            this.io.mostraMessaggio("Hai vinto!");
        if (!this.partita.giocatoreIsVivo())
            this.io.mostraMessaggio("Hai esaurito i CFU...");

        return this.partita.isFinita();
    }

    public static void main(String[] argc) {
        IO io = new IOConsole();
        Labirinto labirinto = new LabirintoBuilder()
            .addStanzaIniziale("Atrio")
            .addStanza("Aula N11")
            .addStanza("Aula N10")
            .addStanza("Laboratorio Campus")
            .addStanzaVincente("Biblioteca")
            .addAdiacenza("Atrio", "Biblioteca", "nord")
            .addAdiacenza("Atrio", "Aula N11", "est")
            .addAdiacenza("Atrio", "Aula N10", "sud")
            .addAdiacenza("Atrio", "Laboratorio Campus", "ovest")
            .addAdiacenza("Aula N11", "Laboratorio Campus", "est")
            .addAdiacenza("Aula N11", "Atrio", "ovest")
            .addAdiacenza("Aula N10", "Atrio", "nord")
            .addAdiacenza("Aula N10", "Aula N11", "est")
            .addAdiacenza("Aula N10", "Laboratorio Campus", "ovest")
            .addAdiacenza("Laboratorio Campus", "Atrio", "est")
            .addAdiacenza("Laboratorio Campus", "Aula N11", "ovest")
            .addAdiacenza("Biblioteca", "Atrio", "sud")
            .addStanza("Aula N10")
            .addAttrezzo("lanterna", 3)
            .addStanza("Atrio")
            .addAttrezzo("osso", 1)
            .getLabirinto();

        DiaDia gioco = new DiaDia(labirinto, io);
        gioco.gioca();
    }
}
