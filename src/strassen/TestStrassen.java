package strassen;

import java.util.Scanner;

/**
 * 
 * @author Quentin Audinot
 * Classe qui va nous permettre de tester notre classe Matrice
 */
public class TestStrassen {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Taille de matrice : ");
		int n = sc.nextInt();
		System.out.println("LEAF_SIZE : ");
		int ls = sc.nextInt();
		
		Matrice A = new Matrice(n);
		A.remplissageAleatoire();
		Matrice B = new Matrice(n);
		B.remplissageAleatoire();
		
		System.out.println("Multiplication classique : ");
		long start1 = System.currentTimeMillis();
		Matrice C = Matrice.multiplier(A, B);
		long end1 = System.currentTimeMillis();
		System.out.println("Temps : " + (end1 - start1) + "ms");
		
		System.out.println("Multiplication Strassen : ");
		long start2 = System.currentTimeMillis();
		Matrice D = Matrice.strassen(A, B, ls);
		long end2 = System.currentTimeMillis();
		System.out.println("Temps : " + (end2 - start2) + "ms");
		
	}
}
