package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

    private String nomeAttrezzoLuminoso;

    public StanzaBuia(String nome, String attrezzoNecessario) {
        super(nome);
        this.nomeAttrezzoLuminoso = attrezzoNecessario;
    }

    @Override
    public String getDescrizione() {
        if (!this.hasAttrezzo(this.nomeAttrezzoLuminoso))
            return "qui c'è un buio pesto";
        return super.getDescrizione();
    }
}
