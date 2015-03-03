/*The first two consecutive numbers to have two distinct prime factors are:

14 = 2 × 7
15 = 3 × 5

The first three consecutive numbers to have three distinct prime factors are:

644 = 2² × 7 × 23
645 = 3 × 5 × 43
646 = 2 × 17 × 19.

Find the first four consecutive integers to have four distinct prime factors. 
What is the first of these numbers?*/

import java.util.Scanner;
import java.util.*;
import java.io.*;

public class DistinctPrimeFactors
{
	private static int[] primeArray = new int[300];
	public static void main(String[] args)throws IOException {
		

		Scanner scan = new Scanner(new File("../../Code_Practice/Prime-1000000.txt"));
		scan.useDelimiter(",");

		// Load a 300 primes
		for(int i = 0; i<300; i++)
		{
			if(scan.hasNext())
				primeArray[i] = Integer.parseInt(scan.next());
		}

		int number = 209;
		int consecutive = 0;
		while(consecutive < 3)
		{
			if(fourFactors(number+1)==fourFactors(number)+1)
			{
				number += 1;
				consecutive++;
				System.out.println(number);
			}
			else {
				number = fourFactors(number+1);
				consecutive=0;
			}
		}

	}

	// Finds next integer from 'number' which has four distinct prime factors
	private static int fourFactors(int number)
	{
		ArrayList<Integer> primeFactor = new ArrayList<Integer>();
		while(true)
		{
			primeFactor.clear();
			for(int prime: primeArray)
			{
				if(number%prime == 0 && !primeFactor.contains(prime))
					primeFactor.add(prime);
			}
			if(primeFactor.size()<4)
				number++;
			else
				break;
		}// end while
		return number;
	}
}

