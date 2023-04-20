package it.uniroma3.diadia.test;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestComandoVai {
	Partita partita;
	Comando comando;
	
	@BeforeEach
	void setUp() throws Exception {
		partita = new Partita();              //stanza corrente è Atrio
		comando = new ComandoVai();
		comando.setParametro("nord"); 
		comando.esegui(partita);              //deve andare in Biblioteca
	}

	@AfterEach
	void tearDown() throws Exception {
		partita = null;
	}

	@Test
	void testVai1() {
		assertTrue(partita.getStanzaCorrente().getNome().equals("Biblioteca"));
	}
	
}