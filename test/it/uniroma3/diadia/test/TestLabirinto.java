package it.uniroma3.diadia.test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

class TestLabirinto {
	private Labirinto labirinto;
	
	@BeforeEach
	void setUp() throws Exception {
		labirinto = new Labirinto();
	}

	@AfterEach
	void tearDown() throws Exception {
		labirinto = null;
	}

	@Test
	void testStanzaVincente() {
		assertTrue(labirinto.getStanzaVincente().getNome().equals("Biblioteca"));
	}
	@Test
	void testStanzaIniziale() {
		assertTrue(labirinto.getStanzaIniziale().getNome().equals("Atrio"));
	}
	@Test
	void testCollegamentoStanza1() {
		assertTrue(labirinto.getStanzaIniziale().getStanzaAdiacente("nord").getNome().equals("Biblioteca"));
	}
	@Test
	void testCollegamentoStanza2() {
		assertTrue(labirinto.getStanzaIniziale().getStanzaAdiacente("est").getNome().equals("Aula N11"));
	}
	@Test
	void testCollegamentoStanza3() {
		assertTrue(labirinto.getStanzaIniziale().getStanzaAdiacente("sud").getNome().equals("Aula N10"));
	}
}
