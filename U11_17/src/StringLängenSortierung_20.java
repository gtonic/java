import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class StringLängenSortierung_20 {
	
	private static class StringLengthComparator implements Comparator<String> {

		@Override
		public int compare(String s0, String s1) {
			return s0.length() - s1.length();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		String[] name1 = name.split(" ");
		//char [] stringsort = name.toCharArray();
		
		//System.out.println(Arrays.toString(name1));
		for (int i = 0; i < name1.length; i++) {
			System.out.println("Neuer String:" + " " + name1[i]);
		}
		Arrays.sort(name1, new StringLengthComparator());
		System.out.println("Ausgabe");
		for (int i = 0; i < name1.length; i++) {
		System.out.println("Neuer String:" + " " +name1[i]);
		}
	}
}
