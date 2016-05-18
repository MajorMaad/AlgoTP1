package karatsuba;

import java.math.BigInteger;
import java.util.Random;

public class TestKaratsuba {
	
	public static void main(String[] args) {
		long start, stop;
		Random r = new Random();
		BigInteger a = new BigInteger(1000000, r);
		BigInteger b = new BigInteger(1000000, r);
		
		System.out.println("Nombre de chiffres de a et b : 301 030");
		
        start = System.currentTimeMillis(); 
        BigInteger c = Karatsuba.karatsuba(a, b);
        stop = System.currentTimeMillis();
        System.out.println("Temps Karatsuba : " + (stop - start) + "ms");

        start = System.currentTimeMillis(); 
        BigInteger d = a.multiply(b);
        stop = System.currentTimeMillis();
        System.out.println("Temps multiplication classique : " + (stop - start) + "ms");
	}
	
}
