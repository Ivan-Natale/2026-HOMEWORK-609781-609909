package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {

    public final static int DEFAULT_PESO_MAX_BORSA = 10;

    private Map<String, Attrezzo> attrezzi;
    private int pesoMax;

    private static final Comparator<Attrezzo> COMPARATORE_PER_NOME =
            Comparator.comparing(Attrezzo::getNome);

    private static final Comparator<Attrezzo> COMPARATORE_PER_PESO_E_NOME =
            Comparator.comparingInt(Attrezzo::getPeso)
                      .thenComparing(Attrezzo::getNome);

    public Borsa() {
        this(DEFAULT_PESO_MAX_BORSA);
    }

    public Borsa(int pesoMax) {
        this.pesoMax = pesoMax;
        this.attrezzi = new LinkedHashMap<>();
    }

    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (attrezzo == null)
            return false;
        if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
            return false;
        this.attrezzi.put(attrezzo.getNome(), attrezzo);
        return true;
    }

    public int getPesoMax() {
        return this.pesoMax;
    }

    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        return this.attrezzi.get(nomeAttrezzo);
    }

    public int getPeso() {
        return this.attrezzi.values().stream()
                .mapToInt(Attrezzo::getPeso)
                .sum();
    }

    public boolean isEmpty() {
        return this.attrezzi.isEmpty();
    }

    public boolean hasAttrezzo(String nomeAttrezzo) {
        return this.attrezzi.containsKey(nomeAttrezzo);
    }

    public Attrezzo removeAttrezzo(String nomeAttrezzo) {
        return this.attrezzi.remove(nomeAttrezzo);
    }

    /**
     * Restituisce una lista ordinata per peso crescente e, a parita' di peso,
     * per nome.
     */
    public List<Attrezzo> getContenutoOrdinatoPerPeso() {
        List<Attrezzo> ordinati = new ArrayList<>(this.attrezzi.values());
        ordinati.sort(COMPARATORE_PER_PESO_E_NOME);
        return ordinati;
    }

    /**
     * Restituisce un SortedSet ordinato per nome.
     */
    public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
        SortedSet<Attrezzo> ordinati = new TreeSet<>(COMPARATORE_PER_NOME);
        ordinati.addAll(this.attrezzi.values());
        return ordinati;
    }

    /**
     * Raggruppa gli attrezzi in base al loro peso.
     */
    public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
        Map<Integer, Set<Attrezzo>> raggruppati = new TreeMap<>();
        for (Attrezzo attrezzo : this.attrezzi.values()) {
            raggruppati
                .computeIfAbsent(attrezzo.getPeso(), peso -> new TreeSet<>(COMPARATORE_PER_NOME))
                .add(attrezzo);
        }
        return raggruppati;
    }

    /**
     * Restituisce un SortedSet ordinato per peso e poi per nome.
     * Il confronto include il nome, quindi due attrezzi con stesso peso ma nome
     * diverso rimangono distinti.
     */
    public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
        SortedSet<Attrezzo> ordinati = new TreeSet<>(COMPARATORE_PER_PESO_E_NOME);
        ordinati.addAll(this.attrezzi.values());
        return ordinati;
    }

    @Override
    public String toString() {
        if (this.isEmpty())
            return "Borsa vuota";

        StringBuilder s = new StringBuilder();
        s.append("Contenuto borsa (")
         .append(this.getPeso())
         .append("kg/")
         .append(this.getPesoMax())
         .append("kg): ");

        for (Attrezzo attrezzo : this.getContenutoOrdinatoPerPeso())
            s.append(attrezzo).append(" ");

        return s.toString();
    }
}
