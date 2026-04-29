package it.uniroma3.diadia.comandi;

import java.util.Scanner;
import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {


    private IO io;

    public FabbricaDiComandiFisarmonica(IO io) {
        this.io = io;
    }

    @Override
    public Comando costruisciComando(String istruzione) {
        Scanner scannerDiParole = new Scanner(istruzione);
        String nomeComando = null;
        String parametro = null;

        if (scannerDiParole.hasNext())
            nomeComando = scannerDiParole.next();

        if (scannerDiParole.hasNext())
            parametro = scannerDiParole.next();

        Comando comando;

        switch (nomeComando) {
            case "vai":
                comando = new ComandoVai();
                break;
            case "prendi":
                comando = new ComandoPrendi();
                break;
            case "posa":
                comando = new ComandoPosa();
                break;
            case "aiuto":
                comando = new ComandoAiuto();
                break;
            case "fine":
                comando = new ComandoFine();
                break;
            case "guarda":
                comando = new ComandoGuarda();
                break;
            default:
                comando = new ComandoNonValido();
        }

        comando.setParametro(parametro);
        comando.setIO(this.io); // <-- fondamentale!
        return comando;
    }
}