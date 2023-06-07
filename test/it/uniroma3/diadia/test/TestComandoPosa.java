package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.ComandoPosa;

class TestComandoPosa {
	private Partita partita;
	private AbstractComando comando;
	private Labirinto labirinto;
	
	@BeforeEach
	void setUp()throws FileNotFoundException, IOException{
		labirinto = new Labirinto();
		partita = new Partita(labirinto);
		partita.getGiocatore().prendiAttrezzo(new Attrezzo("attrezzotest", 1)); //il giocatore ha attrezzotest nella borsa
		comando = new ComandoPosa();
		comando.setParametro("attrezzotest");
		comando.esegui(partita); //il giocatore lascia attrezzotest
	}

	@AfterEach
	void tearDown(){
		partita = null;
		labirinto = null;
		comando = null;
	}

	@Test
	void testComandoPosa() {
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzotest"));
	}

}