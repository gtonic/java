import java.util.Scanner;

public class Methoden2_26 {
	
	public static int printArray(int[] array) {
		
		int ret = 100;
		
		// Ausgabe des Arrays
				//int [] array = {0};
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
				ret = 1;
				return ret;
			}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner eingabe = new Scanner(System.in);
		int [] array = new int [5];
		int zahl = 0;
		for (int i = 0; i < array.length; i++) {
			zahl = eingabe.nextInt();
			array[i] = zahl;
			System.out.println(" Zahl für Index " + "[" + i + "]" + " " + zahl + zahl);
		}
		eingabe.close();
		int test = printArray(array);
		System.out.print("Returncode: " + test);
	

	}

}
