package it.uniroma3.diadia.test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.Labirinto;

class TestPartita {
	Partita prova;
	Labirinto labirinto;
	
	@BeforeEach
	void setUp() throws Exception {
		this.labirinto = new Labirinto();
		this.prova = new Partita(labirinto);
		this.prova.setFinita();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.prova = null;
		this.labirinto=null;
	}

	@Test
	void testVinta1() {
		assertFalse(prova.vinta());
	}
	@Test
	void testFinita1() {
		assertTrue(prova.isFinita());
	}
}