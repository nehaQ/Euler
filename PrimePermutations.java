/*The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330,
 is unusual in two ways: (i) each of the three terms are prime, and, 
 (ii) each of the 4-digit numbers are permutations of one another.

There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, 
exhibiting this property, but there is one other 4-digit increasing sequence.

What 12-digit number do you form by concatenating the three terms in this sequence?*/

import java.util.*;

public class PrimePermutations
{
	public static void main(String[] args) 
	{
		// Multimap - collision resolution
		Map<Long, List<Long>> primes = new HashMap<Long, List<Long>>();

		for(long i = 1000; i<9999;i++)
		{
			if(Prime.isPrime((int)i))
			{
				long hashValue = hash(i);
				List<Long> list = primes.get(hashValue);
				if(list == null)
					primes.put(hashValue, list = new ArrayList<Long>());
				list.add(i);
			}
		}

		// Find out the collision lists
		for (List<Long> list : primes.values())
            if (list.size() >= 3)
				System.out.println(list);
	}

	private static long hash(long number)
	{
		long hashValue = 0;
		while(number > 0)
		{
			long digit = number%10;
			hashValue += Math.pow(10, digit);
			number  /= 10;
		}
		return hashValue;
	}
}