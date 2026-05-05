package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

    private String direzioneBloccata;
    private String attrezzoSbloccante;

    public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
        super(nome);
        this.direzioneBloccata = direzioneBloccata;
        this.attrezzoSbloccante = attrezzoSbloccante;
    }

    @Override
    public Stanza getStanzaAdiacente(String direzione) {
        if (direzione.equals(this.direzioneBloccata) && !this.hasAttrezzo(attrezzoSbloccante)) {
            return this; // stanza corrente → direzione bloccata
        }
        return super.getStanzaAdiacente(direzione);
    }

    @Override
    public String getDescrizione() {
        if (!this.hasAttrezzo(attrezzoSbloccante))
            return super.getDescrizione() + "\nLa direzione '" + this.direzioneBloccata + "' è bloccata, serve: " + this.attrezzoSbloccante;
        return super.getDescrizione();
    }
}
