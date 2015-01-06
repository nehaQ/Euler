// Data is loaded into a list
import java.io.File;
import java.util.Scanner;
import java.util.*;
import java.io.IOException;

public class CircularPrime
{
	private static ArrayList<Integer> primes = new ArrayList<Integer>();
	private static ArrayList<Integer> visitedPrimes = new ArrayList<Integer>(); // might be combined with other one

	public static boolean isCirclePrime(int number)
	{
		visitedPrimes.add(number);
		int rotations = (int)Math.log10((double)number);
		int power = rotations;
		int rotatedN = 0;
		int tempCount = 0;
		while(rotations > 0)
		{
			rotatedN = ((number%10) * (int)Math.pow(10, power)) + number/10;
			number = rotatedN;
			visitedPrimes.add(number);
			// Look for rotated number in the file of primes
			if(!primes.contains(number))
				return false;
			tempCount++;
			rotations--;
		}
		count+=tempCount;
		return true;
	}

	static int count = 0;
	public static void main(String[] args) throws IOException{
		// All permutations of a number. Use L/R shift and reflect at each shift

		Scanner scan = new Scanner(new File("Prime-1000000.txt"));
		scan.useDelimiter(",");
		

		// Read the file into a list :(
		while(scan.hasNext())
		{
			int number = Integer.parseInt(scan.next());
			primes.add(number);
		}	

		// Go through list
		for(int number: primes)
		{
			if(!visitedPrimes.contains(number) && isCirclePrime(number))
			{
				//System.out.println(number);
				count++;
			}
		}
		System.out.println(count-1);
	}
}

