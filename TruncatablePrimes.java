/*The number 3797 has an interesting property. Being prime itself, it is possible to continuously 
remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. 
Similarly we can work from right to left: 3797, 379, 37, and 3.
Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.*/
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class TruncatablePrimes
{
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("../../Code_Practice/Prime-1000000.txt"));
		scan.useDelimiter(",");

		int eleven = 11;
		int prime = 0;
		int sum = 0;
		while(eleven >0)
		{
			// keep looking for trunctable primes.
			if(scan.hasNext())
			{
				prime = Integer.parseInt(scan.next());
				if(prime != 2 && prime != 3 && prime != 5 && prime != 7 && truncatablePrime(prime))
				{
					eleven--;
					sum += prime;
				}
			}
		}//end while
		System.out.println(sum);
	}

	private static boolean truncatablePrime(int prime)
	{
		return left(prime)&&right(prime);
	}

	// use %
	private static boolean right(int prime)
	{
		if(prime == 0)
			return true;
		else if(!isPrime(prime))
			return false;
		else
		{
			int power10 = (int)Math.log10(prime);
			return right(prime%((int)Math.pow(10, power10)));
		}
	}

	//use /
	private static boolean left(int prime)
	{
		if(prime == 0)
			return true;
		else if(!isPrime(prime))
			return false;
		else
			return left(prime/10);
	}

	private static boolean isPrime(int number)
	{
		if(number == 1)
			return false;
		for(int i = 2;i<=Math.sqrt(number); i++)
		{
			if(number%i == 0)
				return false;
		}
		return true;
	}
}