package it.uniroma3.diadia.ambienti;

/*Stanza bloccata: a meno che non sia presente un attrezzo
 * che la sblocchi, la porta per una stanza adiacente è bloccata
 * @author matricole 
 * @see Stanza
 * @version 1.1
 */
public class StanzaBloccata extends Stanza{
	String nomeDirezioneBloccata;
	String nomeAttrezzoSblocca;

	public StanzaBloccata(String nome, String direzione, String attrezzo) {
		super(nome);
		this.nomeDirezioneBloccata = direzione;
		this.nomeAttrezzoSblocca = attrezzo;
	};


	/*
	 * @param nome direzione
	 * @return se non è presente attrezzo sbloccante Stanza Corrente
	 * @return se è presente attrezzo sbloccante comportamento usuale 
	 */
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(this.hasAttrezzo(nomeAttrezzoSblocca)) {
			return super.getStanzaAdiacente(direzione);  
		} else {
			return this;
		}
	}

	@Override 
	public String getDescrizione() {
		if(this.hasAttrezzo(nomeAttrezzoSblocca)) {
			return super.getDescrizione();
		} else {
			return super.getDescrizione() + " " + nomeAttrezzoSblocca + " " +nomeDirezioneBloccata;	
		}
	}
}
