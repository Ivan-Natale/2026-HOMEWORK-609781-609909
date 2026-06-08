package it.uniroma3.diadia;

/**
 * Implementazione nulla di IO utile come valore di default nei comandi creati
 * direttamente nei test senza passare dalla fabbrica.
 */
public class IONull implements IO {

    @Override
    public void mostraMessaggio(String messaggio) {
        // non fa nulla
    }

    @Override
    public String leggiRiga() {
        return "fine";
    }
}
