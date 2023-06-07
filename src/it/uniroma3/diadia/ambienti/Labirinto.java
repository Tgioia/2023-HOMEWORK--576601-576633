package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

/**
 *  Questa classe crea le stanze per il gioco, definisce stanza corrente e vincente 
 * 
 *  @author Matricole 576601 576633
 *              
 *  @version 1.0
 */

public class Labirinto {
	private IO console;
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;

	/**
	 * Costruttore con stringa che apre il labirinto dal file
	 * @param nomeFile
	 * @param partita
	 */
	private Labirinto(String nomeFile, Scanner scanner) {
		CaricatoreLabirinto c;
		this.console = new IOConsole();
		try {
			c = new CaricatoreLabirinto(nomeFile);
			c.carica();
			this.stanzaCorrente = c.getStanzaIniziale();
			this.stanzaVincente = c.getStanzaVincente();
		} catch (FileNotFoundException e) {
			console.mostraMessaggio("file non trovato");
		} catch (FormatoFileNonValidoException e) {
			console.mostraMessaggio("formato file non valido");
		}
	}
	
	public Labirinto() {
		labirintoDefault();
	}
	//nuovo labirinto builder
	public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder();
	}
	//nuovo labirinto con nome file
	public static Labirinto newBuilder(String nomeFile, Scanner scanner) {
		return new Labirinto(nomeFile, scanner);
	}
	//getter e setter
	public Stanza getStanzaIniziale() {
		return stanzaCorrente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}
	
	public void labirintoDefault() {
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");         
		Stanza aulaN10 = new Stanza("Aula N10");         
		Stanza laboratorio = new Stanza("Laboratorio Campus");         
		Stanza biblioteca = new Stanza("Biblioteca");
		atrio.impostaStanzaAdiacente("nord", biblioteca);         
		atrio.impostaStanzaAdiacente("est", aulaN11);         
		atrio.impostaStanzaAdiacente("sud", aulaN10);         
		atrio.impostaStanzaAdiacente("ovest", laboratorio);         
		aulaN11.impostaStanzaAdiacente("est", laboratorio);         
		aulaN11.impostaStanzaAdiacente("ovest", atrio);         
		aulaN10.impostaStanzaAdiacente("nord", atrio);         
		aulaN10.impostaStanzaAdiacente("est", aulaN11);         
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);         
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso); 
		this.setStanzaCorrente(atrio);
		this.setStanzaVincente(biblioteca);
	}    
	
	//altra classe statica nidificata
	public static class LabirintoBuilder {

		private HashMap<String, Stanza> stanze;
		private Stanza lastAdded;
		private Labirinto labirinto;
		
		/**
		 * inizializza la mappa
		 */
		private LabirintoBuilder(){
			this.stanze = new HashMap<>();
			this.labirinto = new Labirinto();
		}
		
		/**
		 * getter del labirinto
		 * @return Labirinto
		 */
		public Labirinto getLabirinto() {
			return this.labirinto;
		}
		/**
		 * imposta la stanza iniziale
		 * @param nome
		 * @return LabirintoBuilder
		 */
		public LabirintoBuilder addStanzaIniziale(String nome) {
			Stanza stanzaCorrente = new Stanza(nome);
			this.labirinto.setStanzaCorrente(stanzaCorrente);
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
			this.labirinto.setStanzaVincente(stanzaVincente);
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
		 * @param Partita partita
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
		 * Aggiunge un Mago 
		 * @param nome
		 * @param Attrezzo
		 * @return LabirintoBuilder
		 */
		public LabirintoBuilder addMago(String nome, String nomeAttrezzo, int peso) {
			AbstractPersonaggio m = new Mago(nome, nomeAttrezzo, peso);
			lastAdded.setPersonaggio(m);
			return this;
		}
			
		/**
		 * Aggiunge una Strega
		 * @param nome
		 * @return LabirintoBuilder
		 */
		public LabirintoBuilder addStrega(String nome) {
			AbstractPersonaggio s = new Strega(nome);
			lastAdded.setPersonaggio(s);
			return this;
		}
		
		/**
		 * Aggiunge un Cane
		 * @param nome
		 * @return LabirintoBuilder
		 */
		public LabirintoBuilder addCane(String nome) {
			AbstractPersonaggio s = new Cane(nome);
			lastAdded.setPersonaggio(s);
			return this;
		}
		
		/**
		 * Aggiunge un Mago 
		 * @param nome
		 * @param Attrezzo
		 * @return LabirintoBuilder
		 */
		public LabirintoBuilder addMagoInStanza(String nome, String nomeAttrezzo, int peso, String nomeStanza) {
			AbstractPersonaggio m = new Mago(nome, nomeAttrezzo, peso);
			Stanza stanza = this.stanze.get(nomeStanza);
			stanza.setPersonaggio(m);
			return this;
		}
			
		/**
		 * Aggiunge una Strega
		 * @param nome
		 * @return LabirintoBuilder
		 */
		public LabirintoBuilder addStregaInStanza(String nome, String nomeStanza) {
			AbstractPersonaggio s = new Strega(nome);
			Stanza stanza = this.stanze.get(nomeStanza);
			stanza.setPersonaggio(s);
			return this;
		}
		
		/**
		 * Aggiunge un Cane
		 * @param nome
		 * @return LabirintoBuilder
		 */
		public LabirintoBuilder addCaneInStanza(String nome, String nomeStanza) {
			AbstractPersonaggio s = new Cane(nome);
			Stanza stanza = this.stanze.get(nomeStanza);
			stanza.setPersonaggio(s);
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
		 * Aggiunge un attrezzo in una stanza specifica 
		 * @param nome
		 * @param peso
		 * @param string nome stanza
		 * @return LabirintoBuilder
		 */
		public LabirintoBuilder addAttrezzoInStanza(String nome, int peso, String nomeStanza) {
			Attrezzo attrezzo = new Attrezzo(nome, peso);
			Stanza stanza = this.stanze.get(nomeStanza);
			stanza.addAttrezzo(attrezzo);
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
}