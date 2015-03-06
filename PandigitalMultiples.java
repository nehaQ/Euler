/*Take the number 192 and multiply it by each of 1, 2, and 3:

192 × 1 = 192
192 × 2 = 384
192 × 3 = 576
By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)

The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645,
 which is the concatenated product of 9 and (1,2,3,4,5).

What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?*/

public class PandigitalMultiples
{
	public static void main(String[] args) {
		
		int largest = 0;
		int n = 100;

		while(n < 12000)
		{
			String concat = "";
			outer: for(int i = 1; i<=9; i++)
			{
				concat += n*i;
				if(concat.length() > 9)
					break outer;
				if(isPandigital(Integer.parseInt(concat)))
					if(largest< Integer.parseInt(concat))
						largest = Integer.parseInt(concat);

			}
			n++;
			if(n>987654321)
				break;
		}
		System.out.println(largest);
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