package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreNome;
import it.uniroma3.diadia.attrezzi.ComparatorePeso;

/**
 *  Questa classe serve a salvare gli attrezzi del giocatore 
 * 
 *  @author Matricole 576601 576633
 *              
 *  @version 1.0
 */

public class Borsa {
	private HashMap<String, Attrezzo> attrezzi;
	private int pesoMax=10;

	//costruttori
	public Borsa(int pesoMax) {
		this.attrezzi = new HashMap<String, Attrezzo>();
		this.pesoMax = pesoMax;
	}

	/**aggiunge un attrezzo
	 * 
	 * @param attrezzo
	 * @return true se aggiunto, false altrimenti
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		return true;
	}

	/**
	 * verifica esistenza universale
	 * @return true se ha almeno un attrezzo
	 * @return false se non ha attrezzi
	 */
	public boolean hasAttrezzi() {
		if(this.attrezzi.size()==0) {
			return false;
		}
		return true;
	}
	
	/**
	 * @param nomeAttrezzo
	 * @return attrezzo eliminato
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.remove(nomeAttrezzo);
	}

	public int getPesoMax() {
		return pesoMax;
	}

	/**Restituisce il riferimento dando il nome dell'attrezzo 
	 * 
	 * @param nomeAttrezzo
	 * @return riferimento all'attrezzo 
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	/**Conta il peso totale degli attrezzi
	 * @return  int peso	
	 */
	public int getPeso() {
		int peso = 0;
		for(Attrezzo a : this.attrezzi.values()) {
			peso += a.getPeso();
		}
		return peso;
	}

	/**
	 * ritorna true se la borsa è vuota
	 * @return boolean
	 */
	public boolean isEmpty() {
		return this.attrezzi.size() == 0;
	}

	/**
	 * ritorna true se possiede l'attrezzo richiesto
	 * @param nomeAttrezzo
	 * @return boolean
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	/**
	 * @return String
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for(Attrezzo a : this.attrezzi.values()) {
				s.append(a.toString()+" ");
			}
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	/**
	 * restituisce la lista degli attrezzi nella borsa ordinati per peso e
	 * quindi, a parità di peso, per nome
	 * @return List<Attrezzo>
	 */
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> lista = new ArrayList<Attrezzo>();
		Comparator<Attrezzo> comparatore = new ComparatorePeso();
		lista.addAll(this.attrezzi.values());
		Collections.sort(lista, comparatore);
		return lista;
	}

	/**
	 * restituisce l'insieme degli attrezzi nella borsa ordinati per nome
	 * @return SortedSet<Attrezzo>
	 */
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> set = new TreeSet<Attrezzo>(new ComparatoreNome());
		set.addAll(this.attrezzi.values());
		return set;
	}
	
	/**
	 * restituisce l'insieme degli attrezzi nella borsa ordinati per peso
	 * @return SortedSet<Attrezzo>
	 */
	public SortedSet<Attrezzo> getContenutoOrdinatoPerPesoSet(){
		SortedSet<Attrezzo> set = new TreeSet<Attrezzo>(new ComparatorePeso());
		set.addAll(this.attrezzi.values());
		return set;
	}
	

	/**
	 * restituisce una mappa che associa un intero (rappresentante un
	 * peso) con l’insieme (comunque non vuoto) degli attrezzi di tale
	 * peso: tutti gli attrezzi dell'insieme che figura come valore hanno
	 * lo stesso peso pari all'intero che figura come chiave
	 * @return Map<Integer,Set<Attrezzo>>
	 */
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
        Map<Integer, Set<Attrezzo>> mappa = new HashMap<>();
        for (Attrezzo attrezzo :this.attrezzi.values()){
            int peso = attrezzo.getPeso();
            if (!mappa.containsKey(peso)) {
                mappa.put(peso, new HashSet<>());
            }
            mappa.get(peso).add(attrezzo);
        }
        return mappa;
    }
}