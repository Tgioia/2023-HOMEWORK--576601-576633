package it.uniroma3.diadia.ambienti;

/*Stanza buia: a meno che non sia presente un attrezzo
 * che emetta luce, la stanza non può rivelare la descrizione
 * @author matricole 
 * @see Stanza
 * @version 1.1
 */

public class StanzaBuia extends Stanza{
	String nomeAttrezzoLuce;
	
	/**
	 * Crea una stanza buia e definisce quale attrezzo la illumina
	 * @param nome il nome della stanza
	 * @param nomeAttrezzoLuce il nome dell'attrezzo che la illumina
	 */
	public StanzaBuia(String nome, String nomeAttrezzoLuce){
		super(nome);
		this.nomeAttrezzoLuce = nomeAttrezzoLuce;
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(nomeAttrezzoLuce)) {
			return this.toString();
		} else {
			return "qui c'è un buio pesto";
		}
	}
}
