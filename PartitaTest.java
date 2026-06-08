package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Simulatore di input/output per testare partite complete senza usare la console.
 * Versione HWC: usa solo collezioni del Java Collection Framework.
 */
public class IOSimulator implements IO {

    private List<String> righeDaLeggere;
    private List<String> messaggiProdotti;
    private Map<Integer, List<String>> messaggiPerRigaLetta;
    private int indiceProssimaRiga;
    private int numeroRigheLette;

    public IOSimulator(List<String> righeDaLeggere) {
        this.righeDaLeggere = new ArrayList<>(righeDaLeggere);
        this.messaggiProdotti = new ArrayList<>();
        this.messaggiPerRigaLetta = new LinkedHashMap<>();
        this.indiceProssimaRiga = 0;
        this.numeroRigheLette = 0;
    }

    @Override
    public void mostraMessaggio(String messaggio) {
        this.messaggiProdotti.add(messaggio);
        this.messaggiPerRigaLetta
            .computeIfAbsent(this.numeroRigheLette, chiave -> new ArrayList<>())
            .add(messaggio);
    }

    @Override
    public String leggiRiga() {
        if (this.indiceProssimaRiga >= this.righeDaLeggere.size())
            return "fine";
        String riga = this.righeDaLeggere.get(this.indiceProssimaRiga);
        this.indiceProssimaRiga++;
        this.numeroRigheLette++;
        return riga;
    }

    public List<String> getMessaggiProdotti() {
        return Collections.unmodifiableList(this.messaggiProdotti);
    }

    public List<String> getRigheDaLeggere() {
        return Collections.unmodifiableList(this.righeDaLeggere);
    }

    public Map<Integer, List<String>> getMessaggiPerRigaLetta() {
        Map<Integer, List<String>> copia = new LinkedHashMap<>();
        for (Map.Entry<Integer, List<String>> entry : this.messaggiPerRigaLetta.entrySet())
            copia.put(entry.getKey(), Collections.unmodifiableList(entry.getValue()));
        return Collections.unmodifiableMap(copia);
    }

    public boolean haProdottoMessaggioContenente(String testo) {
        return this.messaggiProdotti.stream().anyMatch(messaggio -> messaggio.contains(testo));
    }
}
