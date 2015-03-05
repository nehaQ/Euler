/*We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; 
for example, the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand,
 multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.*/
public class PandigitalProducts
{
	public static void main(String[] args) {
		int sum = 0;

		for(int a = 1; a<= 9876; a++)
		{
			for(int b = a+1; b <= 9876; b++)
			{
				String s = a + "" + b + "" + (a*b);
				if(s.length() > 9 || s.length() < 9)
					continue;
				int pan = Integer.parseInt(s);
				if(isPandigital(pan))
					sum += (a*b);
			}
		}

		System.out.println(sum);
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
}