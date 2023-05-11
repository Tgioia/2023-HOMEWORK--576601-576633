package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder extends Labirinto{

	private HashMap<String, Stanza> stanze;
	private Stanza lastAdded;
	/**
	 * inizializza la mappa
	 */
	public LabirintoBuilder(){
		stanze = new HashMap<>();
	}
	
	/**
	 * getter del labirinto
	 * @return Labirinto
	 */
	public Labirinto getLabirinto() {
		return this;
	}
	/**
	 * imposta la stanza iniziale
	 * @param nome
	 * @return LabirintoBuilder
	 */
	public LabirintoBuilder addStanzaIniziale(String nome) {
		Stanza stanzaCorrente = new Stanza(nome);
		super.setStanzaCorrente(stanzaCorrente);
		lastAdded = stanzaCorrente;
		stanze.put(nome, stanzaCorrente);
		return this;
	}
	/**
	 * imposta la stanza vincente
	 * @param nome
	 * @return LabirintoBuilder
	 */
	public LabirintoBuilder addStanzaVincente(String nome) {
		Stanza stanzaVincente = new Stanza(nome);
		super.setStanzaVincente(stanzaVincente);
		stanze.put(nome, stanzaVincente);
		lastAdded = stanzaVincente;
		return this;
	}
	
	/**
	 * Aggiunge una stanza
	 * @param nome
	 * @return LabirintoBuilder
	 */
	public LabirintoBuilder addStanza(String nome) {
		Stanza stanza = new Stanza(nome);
		stanze.put(nome, stanza);
		lastAdded = stanza;
		return this;
	}
	
	/**
	 * Aggiunge una stanza magica
	 * @param string nome, int soglia
	 * @return LabirintoBuilder
	 */
	public LabirintoBuilder addStanzaMagica(String nome, int soglia) {
		StanzaMagica stanza = new StanzaMagica(nome, soglia);
		stanze.put(nome, stanza);
		lastAdded = stanza;
		return this;
	}
	
	/**
	 * Aggiunge una stanza bloccata
	 * @param String nome
	 * @param String direzione
	 * @param String attrezzo
	 * @return LabirintoBuilder
	 */
	public LabirintoBuilder addStanzaBloccata(String nome, String direzione, String attrezzo) {
		StanzaBloccata stanza = new StanzaBloccata(nome, direzione, attrezzo);
		stanze.put(nome, stanza);
		lastAdded = stanza;
		return this;
	}
	
	/**
	 * Aggiunge una stanza buia
	 * @param string nome 
	 * @paramS tring nomeAttrezzo
	 * @return LabirintoBuilder
	 */
	public LabirintoBuilder addStanzaBuia(String nome, String nomeAttrezzo) {
		StanzaBuia stanza = new StanzaBuia(nome, nomeAttrezzo);
		stanze.put(nome, stanza);
		lastAdded = stanza;
		return this;
	}
	
	/**
	 * Aggiunge un attrezzo 
	 * @param nome
	 * @param peso
	 * @return LabirintoBuilder
	 */
	public LabirintoBuilder addAttrezzo(String nome, int peso) {
		Attrezzo attrezzo = new Attrezzo(nome, peso);
		lastAdded.addAttrezzo(attrezzo);
		return this;
	}
	/**
	 * Aggiunge l'adiacenza
	 * @param nome1
	 * @param nome2
	 * @param dir
	 * @return LabirintoBuilder
	 */
	public LabirintoBuilder addAdiacenza(String nome1, String nome2, String dir) {
		stanze.get(nome1).impostaStanzaAdiacente(dir, stanze.get(nome2));
		return this;
	}

	public Map<String, Stanza> getListaStanze() {
		return this.stanze;
	}
}