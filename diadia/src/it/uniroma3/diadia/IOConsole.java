package it.uniroma3.diadia;
import java.util.Scanner;

/**
 *  Questa classe va a occuparsi degli input e output del programma 
 * 
 *  @author Matricole 576601 576633
 *              
 *  @version 1.0
 */

public class IOConsole {
	/**
	 * Output
	 * @param msg
	 */
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	/**
	 * Input
	 * @return stringa input
	 */
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;
	}
}