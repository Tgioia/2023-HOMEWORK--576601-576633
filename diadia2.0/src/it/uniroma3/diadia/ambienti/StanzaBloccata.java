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
			Stanza stanza = null;
			for(int i=0; i<this.numeroStanzeAdiacenti; i++)
				if (this.direzioni[i].equals(direzione))
					stanza = this.stanzeAdiacenti[i];
			return stanza;
		} else {
			return this;  
		}
	}

	@Override 
	public String getDescrizione() {
		return this.toString();
	}
	
	@Override 
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		for (String direzione : this.direzioni) {
			if (direzione!=null) {
				risultato.append(" " + direzione);
				if(direzione.equals(nomeDirezioneBloccata)) {
					risultato.append("bloccata, attrezzo necessario: " + nomeAttrezzoSblocca);
				}
			}
		}
		risultato.append("\nAttrezzi nella stanza: ");
		for (int i=0; i<numeroAttrezzi ;i++){	
			risultato.append(this.attrezzi[i].toString()+" ");
		}
		return risultato.toString();
	}
}
