package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.ComandoPrendi;

class TestComandoPrendi {
	private Partita partita;
	private AbstractComando comando;
	private Labirinto labirinto;
	
	@BeforeEach
	void setUp()throws FileNotFoundException, IOException{
		this.labirinto = new Labirinto();
		partita = new Partita(labirinto);
		comando = new ComandoPrendi();
		comando.setParametro("osso");
		comando.esegui(partita); //il giocatore prende attrezzotest
	}

	@AfterEach
	void tearDown() throws Exception {
		partita = null;
		comando = null;
		labirinto = null;
	}

	@Test
	void test() {
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
	}
}