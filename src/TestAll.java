import java.util.Scanner;

import karatsuba.TestKaratsuba;
import strassen.TestStrassen;
import tri.TestTri;

public class TestAll {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choix = -1;
		
		System.out.println("Veuillez choisir une partie à traiter : ");
		
		while (choix != 0) {
			System.out.println();
			System.out.println("\t1 - Algorithme de Strassen");
			System.out.println("\t2 - Algorithmes de tri");
			System.out.println("\t3 - Algorithme de Karatsuba");
			System.out.println("\t0 - Quitter");
			
			choix = sc.nextInt();
			
			switch (choix) {
			case 1:
				TestStrassen.main(null);
				break;
			case 2:
				TestTri.main(null);
			case 3:
				TestKaratsuba.main(null);

			default:
				break;
			}
		}
	}

}
