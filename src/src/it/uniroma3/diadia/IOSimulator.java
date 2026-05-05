package it.uniroma3.diadia;

import java.util.Arrays;

/**
 * Implementazione di IO utile nei test automatici.
 * Permette di simulare l'input dell'utente e di salvare i messaggi stampati dal gioco.
 */
public class IOSimulator implements IO {

    private String[] righeDaLeggere;
    private int indiceRigaDaLeggere;

    private String[] messaggiMostrati;
    private int numeroMessaggiMostrati;

    public IOSimulator(String[] righeDaLeggere) {
        this.righeDaLeggere = righeDaLeggere;
        this.indiceRigaDaLeggere = 0;
        this.messaggiMostrati = new String[10];
        this.numeroMessaggiMostrati = 0;
    }

    @Override
    public void mostraMessaggio(String messaggio) {
        if (this.numeroMessaggiMostrati == this.messaggiMostrati.length) {
            this.messaggiMostrati = Arrays.copyOf(this.messaggiMostrati, this.messaggiMostrati.length * 2);
        }
        this.messaggiMostrati[this.numeroMessaggiMostrati] = messaggio;
        this.numeroMessaggiMostrati++;
    }

    @Override
    public String leggiRiga() {
        if (this.indiceRigaDaLeggere >= this.righeDaLeggere.length) {
            throw new IllegalStateException("Non ci sono altre righe da leggere nel simulatore.");
        }
        String riga = this.righeDaLeggere[this.indiceRigaDaLeggere];
        this.indiceRigaDaLeggere++;
        return riga;
    }

    public String[] getMessaggiMostrati() {
        return Arrays.copyOf(this.messaggiMostrati, this.numeroMessaggiMostrati);
    }

    public String getMessaggioMostrato(int indice) {
        if (indice < 0 || indice >= this.numeroMessaggiMostrati) {
            throw new IndexOutOfBoundsException("Indice messaggio non valido: " + indice);
        }
        return this.messaggiMostrati[indice];
    }

    public int getNumeroMessaggiMostrati() {
        return this.numeroMessaggiMostrati;
    }

    public boolean contieneMessaggio(String testo) {
        for (int i = 0; i < this.numeroMessaggiMostrati; i++) {
            if (this.messaggiMostrati[i] != null && this.messaggiMostrati[i].contains(testo)) {
                return true;
            }
        }
        return false;
    }
}
