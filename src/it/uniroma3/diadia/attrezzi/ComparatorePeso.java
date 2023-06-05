package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparatorePeso implements Comparator<Attrezzo>{
	
	@Override
	public int compare(Attrezzo uno, Attrezzo due) {
		if(uno.getPeso()<due.getPeso()) {
			return -1;
		}
		if(uno.getPeso()>due.getPeso()) {
			return 1;
		}
		return uno.getNome().compareTo(due.getNome());
	}
}