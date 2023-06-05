package it.uniroma3.diadia.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.ComandoVai;

class TestComandoVai {
	private Partita partita;
	private AbstractComando comando;
	private Labirinto labirinto;
	private Labirinto.LabirintoBuilder builder;
	
	@BeforeEach
	void setUp() throws Exception {
		this.builder = Labirinto.newBuilder();
		labirinto = builder.addStanzaIniziale("stanza1").addStanza("stanza2").addAdiacenza("stanza1", "stanza2", "nord")
				.addStanzaVincente("stanza3").addAdiacenza("stanza2", "stanza3", "est").getLabirinto();
		partita = new Partita(labirinto);              //stanza corrente è stanza1
		
	}

	@AfterEach
	void tearDown() throws Exception {
		partita = null;
		builder = null;
		labirinto = null;
		comando = null;
	}

	@Test
	void testVai1() {
		comando = new ComandoVai();
		comando.setParametro("nord"); 
		comando.esegui(partita);              //deve andare in stanza2
		assertEquals(partita.getStanzaCorrente().getNome(), "stanza2");
	}
	@Test
	void testVai2() {
		comando = new ComandoVai();
		comando.setParametro("nord"); 
		comando.esegui(partita);              //deve andare in stanza2
		comando.setParametro("est"); 
		comando.esegui(partita);              //deve andare in stanza3
		assertEquals(partita.getStanzaCorrente().getNome(), partita.getStanzaVincente().getNome());
	}
}