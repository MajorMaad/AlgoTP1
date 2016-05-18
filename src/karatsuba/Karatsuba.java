package karatsuba;

import java.math.BigInteger;

/**
 * Classe contenant l'algorithme de Karatsuba permettant de multiplier
 * deux BigInteger
 * @author Quentin Audinot
 *
 */
public class Karatsuba {
	
	public static BigInteger karatsuba(BigInteger x, BigInteger y) {
		int k = Math.max(x.bitLength(), y.bitLength());
		if (k <= 2000) return x.multiply(y);
		k = (k/2) + (k%2);
		
		// x = a*2^k + b
		BigInteger a = x.shiftRight(k);
		BigInteger b= x.subtract(a.shiftLeft(k));
		// y = c*2^k + d
		BigInteger c = y.shiftRight(k);
		BigInteger d = y.subtract(c.shiftLeft(k));
		
		BigInteger ac = karatsuba(a, c);
		BigInteger bd = karatsuba(b, d);
		BigInteger abcd = karatsuba(a.subtract(b), c.subtract(d)); // (a-b)(c-d)
		
		// 	   ac * 2^2k         + (ac + bd - (a-b)(c-d)) * 2^k              + bd        
		return ac.shiftLeft(2*k).add(ac.add(bd.subtract(abcd)).shiftLeft(k)).add(bd);
	}

}
