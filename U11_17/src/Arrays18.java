import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Scanner;

public class Arrays18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Verbindung zur Standard-Eingabe resp.zum Keyboard:
		// Scanner eingabe = new Scanner(System.in);
		Scanner eingabe = new Scanner(System.in);

		// Ausgabe des Arrays auf der Konsole
		System.out.print("Ausgabe des Arrays");
		int[] array = { 1, 2, 3, 4, 5, 6 };
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i]);

		}
// Einlesen des Arrays
		int zahl = 0;
		for (int i = 0; i < array.length; i++) {
			zahl = eingabe.nextInt();
			array[i] = zahl;
			System.out.println(" Zahl für Index " + "[" + i + "]" + " " + zahl + zahl);
		}
		eingabe.close();
// Ausgabe des Arrays
		System.out.println("Ausgabe des Arrays:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "" + array[i]+" ");
		}

// Vertauschen
		//System.out.println("Ausgabe des gespiegelten Arrays:");
		for (int i = 0; i < array.length / 2; i++) {
			int buffer = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = buffer;
		}
		System.out.println("");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "" + array[i]+ " ");
		}
		System.out.println("");
	}
}