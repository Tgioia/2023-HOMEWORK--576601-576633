package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;

class TestComandoPosa {
	Partita partita;
	Comando comando;
	Attrezzo attrezzotest;
	Labirinto labirinto;
	
	@BeforeEach
	void setUp(){
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
	}

	@Test
	void testComandoPosa() {
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzotest"));
	}

}