import java.util.Scanner;

public class Wörtertauschen_23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner eingabe = new Scanner(System.in);
		String Satz = eingabe.nextLine();
		String[] Test = Satz.split(" ");
		for (int i = Test.length-1; i >= 0; i--) {
		System.out.print(Test[i]+" ");
		}
	}
}