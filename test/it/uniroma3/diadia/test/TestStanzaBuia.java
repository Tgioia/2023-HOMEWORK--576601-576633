package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class TestStanzaBuia {
	private StanzaBuia buia;
	private StanzaBuia illuminata;
	private Attrezzo luce;

	@BeforeEach
	void setUp() throws Exception {
		illuminata = new StanzaBuia("testbuia", "lanterna");
		buia = new StanzaBuia("testbuia", "lanterna");
		luce = new Attrezzo("lanterna", 1);
		illuminata.addAttrezzo(luce);
	}

	@AfterEach
	void tearDown() throws Exception {
		buia = null;
		luce = null;
	}

	@Test
	void testIlluminata() {
		assertFalse(illuminata.getDescrizione().equals("qui c'è un buio pesto"));
	}
	
	@Test
	void testBuia() {
		assertTrue(buia.getDescrizione().equals("qui c'è un buio pesto"));
	}

}
