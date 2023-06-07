package it.uniroma3.diadia.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class TestBorsa {
	private Attrezzo a1;
	private Attrezzo a2;
	private Attrezzo attrezzoAdded;
	private Borsa borsa;
	private Borsa borsa2;
	
	@BeforeEach
	void setUp() throws Exception {
		this.borsa = new Borsa(10);
		this.borsa2 = new Borsa(10);
		this.attrezzoAdded = new Attrezzo("a0", 1);
		this.borsa.addAttrezzo(attrezzoAdded);
		a1 = new Attrezzo("a1", 2);
		a2 = new Attrezzo("a2", 2);
		this.borsa2.addAttrezzo(a1);
		this.borsa2.addAttrezzo(a2);
	}

	@AfterEach
	void tearDown() throws Exception {
		attrezzoAdded=null;
		borsa = null;
		borsa2 = null;
		a1 = null;
		a2 = null;
	}

	@Test
	void testAddAttrezzo1() {
		assertTrue(this.borsa.addAttrezzo(new Attrezzo("prova", 1)));
	}
	@Test
	void testAddAttrezzo2() {
		assertFalse(this.borsa.addAttrezzo(new Attrezzo("prova", 11)));
	}
	@Test
	void testAddAttrezzo3() {
		assertTrue(this.borsa.addAttrezzo(new Attrezzo("prova2", -2)));
	}
	@Test
	void testRemoveAttrezzo1() {
		assertNull(borsa.removeAttrezzo("nullo"));
	}
	@Test
	void testRemoveAttrezzo2() {
		borsa.removeAttrezzo("a0"); //più minimale possibile
		assertTrue(borsa.isEmpty());
		
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
	@Test
	void testOrdinamento() {
		assertEquals("[a1 (2kg), a2 (2kg)]", borsa2.getContenutoOrdinatoPerPesoSet().toString());
	}
	@Test
	void testOrdinamento2() {
		assertEquals("[a1 (2kg), a2 (2kg)]", borsa2.getContenutoOrdinatoPerPeso().toString());
	}
	@Test
	void testOrdinamento3() {
		assertEquals("[a1 (2kg), a2 (2kg)]", borsa2.getContenutoOrdinatoPerNome().toString());
	}
	@Test
	void testOrdinamento4() {
		assertEquals("{2=[a1 (2kg), a2 (2kg)]}", borsa2.getContenutoRaggruppatoPerPeso().toString());
	}
}