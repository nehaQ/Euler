/*Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. 
The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
*/

public class AmicableNumbers
{
	public static void main(String[] args) {
		//ArrayList<Integer> amicable = new ArrayList<Integer>();
		int amicable[] = new int[10000];
		int sum = 0;

		for(int i = 1; i< amicable.length; i++)
		{
			amicable[i] = sumOfDivisors(i);
			// System.out.println(i+ " "+ amicable[i]);
		}

		for(int i = 1; i< amicable.length;i++)
		{
			if(amicable[i] < amicable.length && i == amicable[amicable[i]] && amicable[i] != i)
				sum += i;
		}
		System.out.println(sum);
	}

	private static int sumOfDivisors(int number)
	{
		int sum = 0;
		for(int i = 1; i<= number/2; i++)
		{
			if(number%i == 0)
				sum += i;
		}
		return sum;
	}
}