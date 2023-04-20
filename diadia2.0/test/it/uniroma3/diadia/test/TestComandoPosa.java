package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.giocatore.Giocatore;

class TestComandoPosa {
	Partita partita;
	Comando comando;
	Attrezzo attrezzotest;
	@BeforeEach
	void setUp(){
		partita = new Partita();              //stanza corrente è Atrio
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