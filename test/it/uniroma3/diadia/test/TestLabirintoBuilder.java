package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

class TestLabirintoBuilder {
	private Labirinto.LabirintoBuilder builder;
	private Labirinto lab;
	
	@BeforeEach
	void setUp() throws Exception {
		this.builder = Labirinto.newBuilder();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.builder = null;
		this.lab = null;
	}
	//stanza iniziale
	@Test
	void testStanzaIniziale() {
		lab = builder.addStanzaIniziale("prova").getLabirinto();
		assertEquals("prova", lab.getStanzaIniziale().getNome());
	}
	//stanza vincente
	@Test
	void testStanzaVincente() {
		lab = builder.addStanzaIniziale("iniziale").addStanzaVincente("vincente")
				.addAdiacenza("iniziale", "vincente", "nord").getLabirinto();
		assertEquals("vincente", lab.getStanzaVincente().getNome());
	}
	//stanza normale
	@Test
	void testStanza() {
		lab = builder.addStanzaIniziale("iniziale").addStanzaVincente("vincente")
				.addStanza("mezzo").addAdiacenza("mezzo", "vincente", "nord")
				.addAdiacenza("iniziale", "mezzo", "nord").getLabirinto();
		assertEquals("mezzo", lab.getStanzaIniziale().getStanzaAdiacente("nord").getNome());
	}
	//magica senza attrezzi
	@Test
	void testStanzaMagica() {
		lab = builder.addStanzaIniziale("iniziale").addStanzaMagica("magica", 3)
				.addAdiacenza("iniziale","magica", "nord").getLabirinto();
		assertEquals("magica", lab.getStanzaIniziale().getStanzaAdiacente("nord").getNome());
	}
	//magica con attrezzo di nome invertito perché supera la soglia
	@Test
	void testStanzaMagica2() {
		lab = builder.addStanzaIniziale("iniziale").addStanzaMagica("magica", 0).addAttrezzo("ciao", 1)
				.addAdiacenza("iniziale","magica", "nord").getLabirinto();
		assertTrue(lab.getStanzaIniziale().getStanzaAdiacente("nord").getAttrezzi().containsKey("oaic"));
	}
	//bloccata sbloccata quindi ritorna nome altra stanza
	@Test
	void testStanzaBloccata() {
		lab = builder.addStanzaIniziale("iniziale").addStanzaBloccata("bloccata", "nord", "chiave")
				.addAttrezzo("chiave", 1).addAdiacenza("iniziale","bloccata", "nord").addStanza("test")
				.addAdiacenza("bloccata", "test", "nord").getLabirinto();
		assertEquals("test", lab.getStanzaIniziale().getStanzaAdiacente("nord").getStanzaAdiacente("nord").getNome());
	}
	//bloccata effettivamente bloccata ritorna nome stanza stessa
	@Test
	void testStanzaBloccata2() {
		lab = builder.addStanzaIniziale("iniziale").addStanzaBloccata("bloccata2", "nord", "chiave")
				.addAdiacenza("iniziale","bloccata2", "nord").addStanza("mezzo").addAdiacenza("bloccata2", "mezzo", "nord").getLabirinto();
		assertEquals("bloccata2", lab.getStanzaIniziale().getStanzaAdiacente("nord").getStanzaAdiacente("nord").getNome());
	}
	//assertFalse perché essendo illuminata restituisce descrizione
	@Test
	void testStanzaBuia() {
		lab = builder.addStanzaIniziale("iniziale").addStanzaBuia("buia", "luce").addAdiacenza("iniziale", "buia", "nord")
				.addAttrezzo("luce", 1).getLabirinto();
		assertFalse(lab.getStanzaIniziale().getStanzaAdiacente("nord").getDescrizione().equals("qui c'è un buio pesto"));
	}
	//buia effettivamente buia ritorna descrizione standard delle stanze buie
	@Test
	void testStanzaBuia2() {
		lab = builder.addStanzaIniziale("iniziale").addStanzaBuia("buia", "luce")
				.addAdiacenza("iniziale", "buia", "nord").getLabirinto();
		assertEquals("qui c'è un buio pesto", lab.getStanzaIniziale().getStanzaAdiacente("nord").getDescrizione());
	}
	//addAttrezzo e addAdiacenza sono inseriti nei test precedenti
}
