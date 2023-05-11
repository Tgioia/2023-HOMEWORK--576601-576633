package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 *  Questa classe crea le stanze per il gioco, definisce stanza corrente e vincente 
 * 
 *  @author Matricole 576601 576633
 *              
 *  @version 1.0
 */

public class Labirinto {
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;

	//costruttore se invocato costruisce labirinto standard
	//sennò dobbiamo usare labirinto builder
	public Labirinto() {
		labirintoDefault();
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
	//compone il labirinto standard della versione 1.0 e 2.0
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
}