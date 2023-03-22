package giocatore;
import attrezzi.Attrezzo;

public class Giocatore {
	private int CFU;
	private Borsa borsa;
	
	public Giocatore(int pesoMax) {
		CFU = 20;
		borsa = new Borsa(pesoMax);
	}
	
	public boolean prendiAttrezzo(Attrezzo attrezzo) {
		return borsa.addAttrezzo(attrezzo);
	}
	public Attrezzo lasciaAttrezzo(Attrezzo attrezzo) {
		return borsa.removeAttrezzo(attrezzo.getNome());
	}
	public Borsa getBorsa() {
		return borsa;
	}
	public void setCFU(int cfu) {
		CFU=cfu;
	}
	public int getCFU() {
		return CFU;
	}
	public void addCFU(int cfu) {
		CFU+=cfu;
	}
}
