package karatsuba;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class TestKaratsuba {
	
	public static void main(String[] args) {
		long debut, fin;
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Combien de bits pour a et b ? (tests réalisé avec 1 000 000)");
		int nbBits = sc.nextInt();
		
		BigInteger a = new BigInteger(nbBits, r);
		BigInteger b = new BigInteger(nbBits, r);
		
		System.out.println("Nombre de chiffres de a et b : " + a.toString().length());

		long tpsKara = 0;
		long tpsNorm = 0;
		for (int i=0; i<10; i++) {
	        debut = System.currentTimeMillis(); 
	        BigInteger c = Karatsuba.karatsuba(a, b);
	        fin = System.currentTimeMillis();
	        tpsKara += (fin - debut);
	
	        debut = System.currentTimeMillis(); 
	        BigInteger d = a.multiply(b);
	        fin = System.currentTimeMillis();
	        tpsNorm += (fin - debut);
		}
		System.out.println("Temps Karatsuba : " + tpsKara/10 + "ms");
        System.out.println("Temps multiplication classique : " + tpsNorm/10 + "ms");
	}
	
}
