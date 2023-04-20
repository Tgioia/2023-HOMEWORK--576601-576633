package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;

class TestComandoPrendi {
	Partita partita;
	Comando comando;
	
	@BeforeEach
	void setUp(){
		partita = new Partita();
		comando = new ComandoPrendi();
		comando.setParametro("osso");
		comando.esegui(partita); //il giocatore prende attrezzotest
	}

	@AfterEach
	void tearDown() throws Exception {
		partita = null;
	}

	@Test
	void test() {
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
	}
}