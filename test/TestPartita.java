package it.diadia.test;
import it.diadia.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPartita {
	Partita prova;
	
	@BeforeEach
	void setUp() throws Exception {
		this.prova= new Partita();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.prova = null;
	}

	@Test
	void testVinta1() {
		assertFalse(prova.vinta());
	}
	@Test
	void testFinita1() {
		assertFalse(prova.isFinita());
	}
}