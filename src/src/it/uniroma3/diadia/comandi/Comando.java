package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;
public interface Comando {
    
	
	public void esegui (Partita partita); 
	void setParametro(String parametro);
	void setIO (IO io);
	
	 String getNome();       // aggiunto
	 String getParametro(); 
}
