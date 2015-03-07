/*The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits
0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.

Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

d2d3d4=406 is divisible by 2
d3d4d5=063 is divisible by 3
d4d5d6=635 is divisible by 5
d5d6d7=357 is divisible by 7
d6d7d8=572 is divisible by 11
d7d8d9=728 is divisible by 13
d8d9d10=289 is divisible by 17
Find the sum of all 0 to 9 pandigital numbers with this property.*/

public class SubstringDivisibility
{
	public static void main(String[] args) {
		long sum = 0; 

		for(long i = 1023456789L; i<= 4160357289L; i++)
		{
			if(((i/10000)%10) == 5 && i%9 == 0 && isPandigital(i) && isDivisible(i))
				sum += i; 
			
		}// end pan for

		System.out.println(sum);	
	}

	private static int primeArray[] = new int[]{2, 3, 5, 7, 11, 13, 17};

	private static boolean isDivisible(long number_)
	{
		String number = number_ + "";
		for(int j = 0; j<primeArray.length; j++)
		{
			String subNumber = number.substring(j+1, j+4);
			if(Integer.parseInt(subNumber)%(primeArray[j]) != 0)
				return false;
		}// end primearray
		return true;
	}

	private static boolean isPandigital(long n) {
		long checkPan = 0;

		while(n > 0)
		{
			long digit = (long)n%10L;
			checkPan += (long)Math.pow(10, digit);
			n = n/10;
		}

		if(checkPan == 1111111111L)
			return true;
		return false;
	}
}