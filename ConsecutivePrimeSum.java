/*The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?*/

import java.io.*;
import java.util.*;

public class ConsecutivePrimeSum
{
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("C:/Users/Neha/Documents/Code_practice/Prime-1000000.txt"));
		scan.useDelimiter(",");

		int sum = 0;
		int primeSum = 0;

		while(sum < 1000000)
		{
			sum += Integer.parseInt(scan.next());
			if(Prime.isPrime(sum))
				primeSum = sum;
		}

		System.out.println(primeSum);
	}
}