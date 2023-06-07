package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class TestStanzaBloccata {
	private StanzaBloccata bloccata;
	private StanzaBloccata sbloccata;
	private Stanza adiacente;
	private Attrezzo sblocca;
	
	@BeforeEach
	void setUp() throws Exception {
		adiacente = new Stanza("adiacente");
		bloccata = new StanzaBloccata("bloccata", "nord", "chiave");
		bloccata.impostaStanzaAdiacente("nord", adiacente);
		sbloccata = new StanzaBloccata("sbloccata", "nord", "chiave");
		sbloccata.impostaStanzaAdiacente("sud", adiacente);
		sblocca = new Attrezzo("chiave", 1);
		sbloccata.addAttrezzo(sblocca);
	}

	@AfterEach
	void tearDown() throws Exception {
		bloccata = null;
		sbloccata = null;
		adiacente = null;
		sblocca = null;
	}

	@Test
	void testBloccata() {
		assertEquals(bloccata.getStanzaAdiacente("nord").getNome(), "bloccata");
	}
	@Test
	void testSbloccata() {
		assertEquals(sbloccata.getStanzaAdiacente("sud").getNome(), "adiacente");
	}
}