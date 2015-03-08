/*Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side length 7 is formed.

37 36 35 34 33 32 31
38 17 16 15 14 13 30
39 18  5  4  3 12 29
40 19  6  1  2 11 28
41 20  7  8  9 10 27
42 21 22 23 24 25 26
43 44 45 46 47 48 49

It is interesting to note that the odd squares lie along the bottom right diagonal, but what is more interesting 
is that 8 out of the 13 numbers lying along both diagonals are prime; that is, a ratio of 8/13 ≈ 62%.

If one complete new layer is wrapped around the spiral above, a square spiral with side length 9 will be formed. 
If this process is continued, what is the side length of the square spiral for which the ratio of primes along 
both diagonals first falls below 10%?*/

public class SpiralPrimes{
	public static void main(String[] args) {
		int length = 3;
		int noOfPrimes = 0;
		int total = 1;
		double ratio = 11.0; // random number greater than 10%
 
		while(ratio > 10.0)
		{
			int diagonal = rUp(length);
			if(Prime.isPrime(diagonal))
				noOfPrimes++;
			diagonal = lUp(length);
			if(Prime.isPrime(diagonal))
				noOfPrimes++;
			diagonal = lDown(length);
			if(Prime.isPrime(diagonal))
				noOfPrimes++;
			diagonal = rDown(length);
			if(Prime.isPrime(diagonal))
				noOfPrimes++;
			total += 4;
			
			ratio = ((double)noOfPrimes/total)*100.0;
			length += 2;
		}

		System.out.println(length-2);
	}

	// General form of terms along various diagonals
	private static int rUp(int n)
	{
		return (n*n - 3*n + 3);
	}

	private static int rDown(int n)
	{
		return n*n;
	}

	private static int lUp(int n)
	{
		return n*n - 2*n + 2;
	}

	private static int lDown(int n)
	{
		return n*n - n + 1;
	}
}