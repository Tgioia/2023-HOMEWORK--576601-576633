package it.uniroma3.diadia.giocatore;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe ha la responsabilità di gestire i CFU del giocatore e
 * di memorizzare gli attrezzi in un oggetto istanza della classe borsa 
 * 
 *  @author Matricole 576601 576633
 *              
 *  @version 1.0
 */

public class Giocatore {
	
//	static final private int CFU_INIZIALI = 20;
	private Borsa borsa;
	private int cfu;
	public Properties properties;
	
	//costruttori
	public Giocatore() throws FileNotFoundException, IOException {
		this.properties = new Properties();
		this.cfu = setCfuProperties();
		this.borsa = new Borsa(setPesoBorsaProperties());
	}
	public Giocatore(int pesoMax) {
		this.borsa = new Borsa(pesoMax);
	}
	//getter e setter 
	public int getCfu() {
		return this.cfu;
	}
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	public int setCfuProperties() throws IOException,FileNotFoundException {
		FileInputStream file = new FileInputStream("resources/diadia.properties");
		properties.load(file);
		int CFU_INIZIALI = Integer.parseInt(properties.getProperty("cfu_iniziali"));
		return CFU_INIZIALI;
	}
	public int setPesoBorsaProperties() throws IOException,FileNotFoundException {
		FileInputStream file = new FileInputStream("resources/diadia.properties");
		properties.load(file);
		int peso = Integer.parseInt(properties.getProperty("peso_max_borsa"));
		return peso;
	}
	public Borsa getBorsa() {
		return borsa;
	}

	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}

	public void addCfu(int cfu) {
		this.cfu += cfu;
	}
	//metodi
	public boolean prendiAttrezzo(Attrezzo attrezzo){
		return borsa.addAttrezzo(attrezzo);
	}
	public Attrezzo lasciaAttrezzo(Attrezzo attrezzo){
		return borsa.removeAttrezzo(attrezzo.getNome());
	}
}