package karatsuba;

import java.math.BigInteger;

public class Karatsuba {
	
	public static BigInteger karatsuba(BigInteger x, BigInteger y) {
		int n = Math.max(x.bitLength(), y.bitLength());
		if (n <= 100) return x.multiply(y);
		n = (n/2) + (n%2);
		
		BigInteger b = x.shiftRight(n);
		BigInteger a = x.subtract(b.shiftLeft(n));
		BigInteger d = y.shiftRight(n);
		BigInteger c = y.subtract(d.shiftLeft(n));
		
		BigInteger ac = karatsuba(a, c);
		BigInteger bd = karatsuba(b, d);
		BigInteger abcd = karatsuba(a.add(b), c.add(d));
		
		return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(n)).add(bd.shiftLeft(2*n));
	}

}
