import java.util.Scanner;

public class String_Quersumme19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner eingabe = new Scanner(System.in);
		System.out.print("Zahl für Quersummen Berechnung");
		String test = eingabe.next();
		char ch1 = test.charAt(0);
		int a = Character.getNumericValue(ch1);
		if (a>9) {
			System.out.print("Keine Zahl: Programm Abbruch");
		} else {
			int test1 = Integer.parseInt(test);
			int quersumme = 0;
			//int test1 = test.length();
			do {
				quersumme = quersumme + (test1 % 10);
				test1 = test1 / 10;
			} while (test1 != 0);
			System.out.print("Quersumme = " + quersumme);
			eingabe.close();
		}
	}
}
