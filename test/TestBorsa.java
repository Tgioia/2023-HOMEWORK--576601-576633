package it.diadia.test;
import it.diadia.attrezzi.*;
import it.diadia.giocatore.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBorsa {
	private Attrezzo attrezzo;
	private Borsa borsa;
	@BeforeEach
	void setUp() throws Exception {
		this.borsa = new Borsa();
		this.attrezzo = new Attrezzo("prova", 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		attrezzo=null;
	}

	@Test
	void testAddAttrezzo1() {
		assertTrue(borsa.addAttrezzo(attrezzo));
	}
	@Test
	void testAddAttrezzo2() {
		assertFalse(borsa.addAttrezzo(new Attrezzo("prova", 11)));
	}
	@Test
	void testAddAttrezzo3() {
		assertTrue(borsa.addAttrezzo(new Attrezzo("prova2", -2)));
	}
	@Test
	void testHasAttrezzo1() {
		assertFalse(borsa.hasAttrezzo("prova3"));
	}
	@Test
	void testHasAttrezzo2() {
		assertFalse(borsa.hasAttrezzo("prova1"));
	}
	@Test
	void testHasAttrezzo3() {
		assertFalse(borsa.hasAttrezzo(null));
	}
}
