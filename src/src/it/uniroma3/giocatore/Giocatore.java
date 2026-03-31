package it.uniroma3.giocatore;

public class Giocatore {

	 
	 private int cfu;
	 private Borsa borsa;
	 
	 public Giocatore(int cfu_init) {
		 this.cfu = cfu_init;
		 this.borsa= new Borsa();
	 }
	 
	  public int getCfu() {
	        return this.cfu;
	    }

	    public void setCfu(int cfu) {
	        this.cfu = cfu;
	    }
	    
	 public Borsa getBorsa() {
		 return this.borsa;
	 }
	 
	 public void setBorsa(Borsa nuova) {
		  this.borsa= nuova;
	 }
}
