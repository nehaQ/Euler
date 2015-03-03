// 9digit prime no - all digits 1-9 used just once
//We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. 
//For example, 2143 is a 4-digit pandigital and is also prime.
//What is the largest n-digit pandigital prime that exists?
// http://www.mathblog.dk/project-euler-41-pandigital-prime/

public class PandigitalPrime
{
	public static void main(String[] args) {	
		int greatest = 0;
		for(int i = 1234567; i<=7654321;i++)
		{
			if(isPandigital(i))
			{
				if(isPrime(i))
				{
					if(i> greatest)
						greatest = i;
				}
			}
		}
		
		System.out.println(greatest);
	}

	private static boolean isPandigital(long n) {
	    int digits = 0;
	    int count = 0;
	    int tmp;

	    while (n > 0) {
	        tmp = digits;
	        // Shift one by (n%10) - 1 places. Always gives a power of two number
	        digits = digits | 1 << (int)((n % 10) - 1);
	        if (tmp == digits) {
	            return false;
	        }

	        count++;
	        n /= 10;
	    }

	    return digits == (1 << count) - 1;
	}

	private static boolean isPrime(int number)
	{
		for(int i = 2;i<=Math.sqrt(number); i++)
		{
			if(number%i == 0)
				return false;
		}
		return true;
	}
}