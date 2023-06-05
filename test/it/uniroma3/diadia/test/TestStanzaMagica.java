package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;


class TestStanzaMagica {
	private StanzaMagica stanzaMagica;
	private Attrezzo attrezzo;
	
	@BeforeEach
	void setUp() throws Exception {
		stanzaMagica = new StanzaMagica("Stanza Magica test");
		stanzaMagica.setcontatoreAttrezziPosati(3);
		attrezzo = new Attrezzo("attrezzotest", 2);
	}

	@AfterEach
	void tearDown() throws Exception {
		stanzaMagica = null;
		attrezzo = null;
	}

	@Test
	void testAddAttrezzo() {
		assertTrue(stanzaMagica.addAttrezzo(attrezzo));
	}
	@Test
	void testModificaAttrezzoPeso() {
		assertTrue(stanzaMagica.modificaAttrezzo(attrezzo).getPeso()==4);
	}
	@Test
	void testModificaAttrezzoNome() {
		assertTrue(stanzaMagica.modificaAttrezzo(attrezzo).getNome().equals("tsetozzertta"));
	}
}
