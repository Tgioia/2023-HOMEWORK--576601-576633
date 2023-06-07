package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Direzioni;
import it.uniroma3.diadia.ambienti.Labirinto;

class TestCaricatoreLabirinto {
	
	private Labirinto labirinto;
	private Scanner scanner;
	@BeforeEach
	void setUp() {
		this.scanner = new Scanner(System.in); 
		this.labirinto = Labirinto.newBuilder("resources/labirinto1", scanner);
	}

	@AfterEach
	void tearDown() {
		this.labirinto = null;
	}

	@Test
	void testLoader1() {
		assertEquals("N10", this.labirinto.getStanzaIniziale().getNome());
	}
	
	@Test
	void testLoader2() {
		assertEquals("N11", this.labirinto.getStanzaVincente().getNome());
	}
	
	@Test
	void testLoader3() {
		assertEquals("pinza", this.labirinto.getStanzaIniziale().getAttrezzo("pinza").getNome());
	}
	
	@Test
	void testLoader4() {
		assertEquals("buia", this.labirinto.getStanzaIniziale().getMapStanzeAdiacenti().get(Direzioni.valueOf("sud"))
				.getMapStanzeAdiacenti().get(Direzioni.valueOf("ovest")).getNome());
	}
	
	@Test
	void testLoader5() {
		assertEquals("bloccata", this.labirinto.getStanzaIniziale().getMapStanzeAdiacenti().get(Direzioni.valueOf("sud"))
				.getMapStanzeAdiacenti().get(Direzioni.valueOf("ovest"))
				.getMapStanzeAdiacenti().get(Direzioni.valueOf("sud")).getNome());
	}
	
	@Test
	void testLoader6() {
		assertEquals("magica", this.labirinto.getStanzaIniziale()
				.getMapStanzeAdiacenti().get(Direzioni.valueOf("sud"))
				.getMapStanzeAdiacenti().get(Direzioni.valueOf("ovest"))
				.getMapStanzeAdiacenti().get(Direzioni.valueOf("sud"))
				.getMapStanzeAdiacenti().get(Direzioni.valueOf("sud")).getNome());
	}
	
	@Test 
	void testLoader7() {
		assertEquals("mago", this.labirinto.getStanzaIniziale().getPersonaggio().getNome());
	}
	
	@Test 
	void testLoader8() {
		assertEquals("cane", this.labirinto.getStanzaVincente().getPersonaggio().getNome());
	}
	
	@Test 
	void testLoader9() {
		assertEquals("strega", this.labirinto.getStanzaIniziale()
				.getMapStanzeAdiacenti().get(Direzioni.valueOf("sud"))
				.getPersonaggio().getNome());
	}
}