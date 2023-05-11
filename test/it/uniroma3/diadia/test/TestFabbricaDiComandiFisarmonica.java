package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.comandi.*;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

class TestFabbricaDiComandiFisarmonica {
	Comando comandoAiuto;
	Comando comandoVai;
	Comando comandoPrendi;
	Comando comandoPosa;
	Comando comandoFine;
	Comando comandoGuarda;

	@BeforeEach
	void setUp() throws Exception {
		comandoAiuto = new FabbricaDiComandiFisarmonica().costruisciComando("aiuto");
		comandoVai = new FabbricaDiComandiFisarmonica().costruisciComando("vai nord");
		comandoPrendi = new FabbricaDiComandiFisarmonica().costruisciComando("prendi osso");
		comandoPosa = new FabbricaDiComandiFisarmonica().costruisciComando("posa osso");
		comandoFine = new FabbricaDiComandiFisarmonica().costruisciComando("fine");
		comandoGuarda = new FabbricaDiComandiFisarmonica().costruisciComando("guarda");
	}

	@AfterEach
	void tearDown() throws Exception {
		comandoAiuto = null;
		comandoVai = null;
		comandoPrendi = null;
		comandoPosa = null;
		comandoFine = null;
		comandoGuarda = null;
	}

	@Test
	void testAiuto() {
		assertTrue(comandoAiuto.getNome().equals("aiuto"));
	}
	@Test
	void testVai() {
		assertTrue(comandoVai.getNome().equals("vai"));
	}
	@Test
	void testVai2() {
		assertTrue(comandoVai.getParametro().equals("nord"));
	}
	@Test
	void testPrendi() {
		assertTrue(comandoPrendi.getNome().equals("prendi"));
	}
	@Test
	void testPrendi2() {
		assertTrue(comandoPrendi.getParametro().equals("osso"));
	}
	@Test
	void testPosa() {
		assertTrue(comandoPosa.getNome().equals("posa"));
	}
	@Test
	void testPosa2() {
		assertTrue(comandoPosa.getParametro().equals("osso"));
	}
	@Test
	void testFine() {
		assertTrue(comandoFine.getNome().equals("fine"));
	}
	@Test
	void testGuarda() {
		assertTrue(comandoGuarda.getNome().equals("guarda"));
	}
}