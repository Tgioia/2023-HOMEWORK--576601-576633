package it.uniroma3.diadia;
import java.util.Scanner;

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