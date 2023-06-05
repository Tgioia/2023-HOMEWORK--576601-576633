package it.uniroma3.diadia.test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class TestStanza {
	private Stanza stanza;
	//minimali o meno -> 1 sola riga + cose possibili - oggetti 
	@BeforeEach
	void setUp() throws Exception {
		this.stanza = new Stanza("prova");
		Attrezzo prova0 = new Attrezzo("prova0", 3);
		stanza.addAttrezzo(prova0);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.stanza = null;
	}

	@Test
	void testStanzaaddAttrezzo1(){
		assertTrue(this.stanza.addAttrezzo(new Attrezzo("prova1", 1)));
	}
	@Test
	void testStanzaaddAttrezzo2() {
		assertTrue(this.stanza.addAttrezzo(new Attrezzo("prova2", 0)));
	}
	@Test
	void testStanzaaddAttrezzo3() {
		assertTrue(this.stanza.addAttrezzo(new Attrezzo("", 12)));
	}
	@Test
	void testStanzahasAttrezzo1() {
		assertTrue(this.stanza.hasAttrezzo("prova0"));
	}
	@Test
	void testStanzahasAttrezzo2() {
		assertFalse(this.stanza.hasAttrezzo("prova1"));
	}
	@Test
	void testStanzahasAttrezzo3() {
		assertFalse(this.stanza.hasAttrezzo(null));
	}
}