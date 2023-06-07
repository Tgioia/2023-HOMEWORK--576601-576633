package it.uniroma3.diadia.test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

class TestGiocatore {
	private Giocatore giocatore;
	private Attrezzo attrezzo;
	
	@BeforeEach
	void setUp() throws Exception {
		giocatore = new Giocatore();
		attrezzo = new Attrezzo("attrezzo", 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		giocatore = null;
		attrezzo = null;
	}

	@Test
	void testPrendiAttrezzo1() {
		assertTrue(giocatore.prendiAttrezzo(attrezzo));
	}
	@Test
	void testPrendiAttrezzo2() {
		assertTrue(giocatore.prendiAttrezzo(new Attrezzo("", 1)));
	}
	@Test
	void testPrendiAttrezzo3() {
		assertTrue(giocatore.prendiAttrezzo(new Attrezzo("attrezzo", 1)));
	}
}
