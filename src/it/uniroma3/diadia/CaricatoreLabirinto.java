package it.uniroma3.diadia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class CaricatoreLabirinto {

	/* prefisso di una singola riga di testo contenente tutti i nomi delle stanze */
	private static final String STANZE_MARKER = "Stanze: ";             

	/* prefisso di una singola riga contenente il nome della stanza iniziale */
	private static final String STANZA_INIZIALE_MARKER = "Inizio: ";    

	/* prefisso della riga contenente il nome stanza vincente */
	private static final String STANZA_VINCENTE_MARKER = "Vincente: ";  

	/* prefisso della riga contenente le specifiche degli attrezzi da collocare nel formato <nomeAttrezzo> <peso> <nomeStanza> */
	private static final String ATTREZZI_MARKER = "Attrezzi: ";

	/* prefisso della riga contenente le specifiche dei collegamenti tra stanza nel formato <nomeStanzaDa> <direzione> <nomeStanzaA> */
	private static final String USCITE_MARKER = "Uscite: ";

	/* prefisso della riga contenente i personaggi nel formato <> <> <> */
	private static final String PERSONAGGI_MARKER = "Personaggi: ";
	
	/* prefisso della riga contenente stanza buia nel formato <nomeStanzaDa> <> */
	private static final String STANZA_BUIA_MARKER = "Buia: ";

	/* prefisso della riga contenente stanza magica nel formato <nomeStanzaDa> <> */
	private static final String STANZA_MAGICA_MARKER = "Magica: ";
	
	/* prefisso della riga contenente stanza bloccata nel formato <nomeStanzaDa> <> */
	private static final String STANZA_BLOCCATA_MARKER = "Bloccata: ";
	
	/*
		Stanze:
		Inizio:
		Vincente:
		Bloccata:
		Magica:
		Buia:
		Attrezzi:
		Uscite:
		Personaggi: 
	 */
	private LineNumberReader reader;
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	private Labirinto.LabirintoBuilder builder;

	public CaricatoreLabirinto(String nomeFile) throws FileNotFoundException {
		this.builder = Labirinto.newBuilder();
		this.reader = new LineNumberReader(new FileReader(nomeFile));
	}

	public Labirinto carica() throws FormatoFileNonValidoException {
		try {
			this.leggiECreaStanze();
			this.leggiInizialeEvincente();
			this.leggiEImpostaBloccate();
			this.leggiEImpostaMagiche();
			this.leggiEImpostaBuie();
			this.leggiECollocaAttrezzi();
			this.leggiEImpostaUscite();
			this.leggiECollocaPersonaggi();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return this.builder.getLabirinto();
	}

	private void leggiECollocaPersonaggi() throws FormatoFileNonValidoException {
		String specifichePersonaggi = this.leggiRigaCheCominciaPer(PERSONAGGI_MARKER);
		for(String specificaPersonaggio : separaStringheAlleVirgole(specifichePersonaggi)) {
			String nomePersonaggio = null;
			String nomeStanza = null;
			String nomeAttrezzoMago = null;
			String pesoAttrezzoMago = null;
			try(Scanner scannerLinea = new Scanner(specificaPersonaggio)){
				nomePersonaggio = scannerLinea.next();
				nomeStanza = scannerLinea.next();
				if(nomePersonaggio.equals("mago")) {
					nomeAttrezzoMago = scannerLinea.next();
					pesoAttrezzoMago = scannerLinea.next();
					this.builder.addMagoInStanza(nomePersonaggio, nomeAttrezzoMago, Integer.parseInt(pesoAttrezzoMago), nomeStanza);
				}
				if(nomePersonaggio.equals("strega")) {
					this.builder.addStregaInStanza(nomePersonaggio, nomeStanza);
				} else if(nomePersonaggio.equals("cane")) {
					this.builder.addCaneInStanza(nomePersonaggio, nomeStanza);
				}
			}
		}
	}

	private void leggiEImpostaBuie() throws FormatoFileNonValidoException {
		String specificheBuia = this.leggiRigaCheCominciaPer(STANZA_BUIA_MARKER);
		for(String specificaBuia : separaStringheAlleVirgole(specificheBuia)) {
			String nomeStanza = null;
			String attrezzo = null;
			try(Scanner scannerLinea = new Scanner(specificaBuia)){
				nomeStanza = scannerLinea.next();
				attrezzo = scannerLinea.next();
			}
			this.builder.addStanzaBuia(nomeStanza, attrezzo);
		}
	}

	private void leggiEImpostaMagiche() throws FormatoFileNonValidoException {
		String specificheMagica = this.leggiRigaCheCominciaPer(STANZA_MAGICA_MARKER);
		for(String specificaMagica : separaStringheAlleVirgole(specificheMagica)) {
			String nomeStanza = null;
			String sogliaMagica = null; 
			try(Scanner scannerLinea = new Scanner(specificaMagica)){
				nomeStanza = scannerLinea.next();
				sogliaMagica = scannerLinea.next();
			}
			int i = Integer.parseInt(sogliaMagica);
			this.builder.addStanzaMagica(nomeStanza, i);
		}
		
	}

	private void leggiEImpostaBloccate() throws FormatoFileNonValidoException {
		String specificheBloccata = this.leggiRigaCheCominciaPer(STANZA_BLOCCATA_MARKER);
		for(String specificaBloccata : separaStringheAlleVirgole(specificheBloccata)) {
			String nomeStanza = null;
			String direzione = null;
			String attrezzo = null; 
			try(Scanner scannerLinea = new Scanner(specificaBloccata)){
				nomeStanza = scannerLinea.next();
				direzione = scannerLinea.next();
				attrezzo = scannerLinea.next();
			}
			this.builder.addStanzaBloccata(nomeStanza, direzione, attrezzo);
		}
	}

	private String leggiRigaCheCominciaPer(String marker) throws FormatoFileNonValidoException {
		try {
			String riga = this.reader.readLine();
			return riga.substring(marker.length());
		} catch (IOException e) {
			throw new FormatoFileNonValidoException(e.getMessage());
		}
	}

	private void leggiECreaStanze() throws FormatoFileNonValidoException  {
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZE_MARKER);
		List<String> result = separaStringheAlleVirgole(nomiStanze);
		for(String nomeStanza : result) {
			builder.addStanza(nomeStanza);
		}
	}

	private List<String> separaStringheAlleVirgole(String string) {
		List<String> result = new LinkedList<>();
		String[] risultato = string.split(",");
		for(String a : risultato) {
			result.add(a.trim());
		}
		return result;
	}

	private void leggiInizialeEvincente() throws FormatoFileNonValidoException {
		String nomeStanzaIniziale = this.leggiRigaCheCominciaPer(STANZA_INIZIALE_MARKER);
		String nomeStanzaVincente = this.leggiRigaCheCominciaPer(STANZA_VINCENTE_MARKER);
		this.builder.addStanzaIniziale(nomeStanzaIniziale);
		this.builder.addStanzaVincente(nomeStanzaVincente);
		this.stanzaIniziale = this.builder.getLabirinto().getStanzaIniziale();
		this.stanzaVincente = this.builder.getLabirinto().getStanzaVincente();
	}

	private void leggiECollocaAttrezzi() throws FormatoFileNonValidoException {
		String specificheAttrezzi = this.leggiRigaCheCominciaPer(ATTREZZI_MARKER);
		for(String specificaAttrezzo : separaStringheAlleVirgole(specificheAttrezzi)) {
			String nomeAttrezzo = null;
			String pesoAttrezzo = null;
			String nomeStanza = null; 
			try (Scanner scannerLinea = new Scanner(specificaAttrezzo)) {
				nomeAttrezzo = scannerLinea.next();
				pesoAttrezzo = scannerLinea.next();
				nomeStanza = scannerLinea.next();
			}				
			int i = Integer.parseInt(pesoAttrezzo);
			this.builder.addAttrezzoInStanza(nomeAttrezzo, i, nomeStanza);
		}
	}

	private void leggiEImpostaUscite() throws FormatoFileNonValidoException {
		String specificheUscite = this.leggiRigaCheCominciaPer(USCITE_MARKER);
		for(String uscite : separaStringheAlleVirgole(specificheUscite)) {
			try (Scanner scannerDiLinea = new Scanner(uscite)) {
				String stanzaPartenza = scannerDiLinea.next();
				String dir = scannerDiLinea.next();
				String stanzaDestinazione = scannerDiLinea.next();
				impostaUscita(stanzaPartenza, dir, stanzaDestinazione);
			}
		}
	}


private void impostaUscita(String stanzaDa, String dir, String nomeA) {
	this.builder.addAdiacenza(stanzaDa, nomeA, dir);
}

public Stanza getStanzaIniziale() {
	return this.stanzaIniziale;
}

public Stanza getStanzaVincente() {
	return this.stanzaVincente;
}
}