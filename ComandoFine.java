package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {

    private static final int SOGLIA_MAGICA_DEFAULT = 3;

    private int contatoreAttrezziPosati;
    private int sogliaMagica;

    public StanzaMagica(String nome) {
        this(nome, SOGLIA_MAGICA_DEFAULT);
    }

    public StanzaMagica(String nome, int soglia) {
        super(nome);
        this.contatoreAttrezziPosati = 0;
        this.sogliaMagica = soglia;
    }

    @Override
    public boolean addAttrezzo(Attrezzo attrezzo) {
        this.contatoreAttrezziPosati++;

        // Se è stata superata la soglia, si modifica l'attrezzo
        if (this.contatoreAttrezziPosati > this.sogliaMagica) {
            attrezzo = this.modificaAttrezzo(attrezzo);
        }

        // Si delega alla superclasse
        return super.addAttrezzo(attrezzo);
    }

    /**
     * Restituisce un nuovo attrezzo con:
     * - nome invertito
     * - peso raddoppiato
     */
    private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
        StringBuilder nomeInvertito = new StringBuilder(attrezzo.getNome());
        nomeInvertito.reverse();

        int pesoDoppio = attrezzo.getPeso() * 2;

        return new Attrezzo(nomeInvertito.toString(), pesoDoppio);
    }
}