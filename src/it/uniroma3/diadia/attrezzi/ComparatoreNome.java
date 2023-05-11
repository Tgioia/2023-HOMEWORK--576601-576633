package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparatoreNome implements Comparator<Attrezzo>{
	
	@Override
	public int compare(Attrezzo uno, Attrezzo due) {
		return uno.getNome().compareTo(due.getNome());
	}
}