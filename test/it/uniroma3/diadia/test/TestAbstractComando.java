package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

class TestAbstractComando {
	
	private AbstractComando comandoAiuto;
	private AbstractComando comandoVai;
	private AbstractComando comandoPrendi;
	private AbstractComando comandoPosa;
	private AbstractComando comandoFine;
	private AbstractComando comandoGuarda;
	private IOConsole io;

	@BeforeEach
	void setUp() throws Exception {
		io = new IOConsole();
		comandoAiuto = new FabbricaDiComandiRiflessiva().costruisciComando("aiuto", io);
		comandoVai = new FabbricaDiComandiRiflessiva().costruisciComando("vai nord", io);
		comandoPrendi = new FabbricaDiComandiRiflessiva().costruisciComando("prendi osso", io);
		comandoPosa = new FabbricaDiComandiRiflessiva().costruisciComando("posa osso", io);
		comandoFine = new FabbricaDiComandiRiflessiva().costruisciComando("fine", io);
		comandoGuarda = new FabbricaDiComandiRiflessiva().costruisciComando("guarda", io);
	}

	@AfterEach
	void tearDown() throws Exception {
		io = null;
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
