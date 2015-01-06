public class DigitFactorials
{
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 10; i<=9999999; i++)
		{
			if( i == sumOf(i))
				sum += i;
		}
		System.out.println(sum);
	}

	private static int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
	private static int sumOf(int i)
	{
		int sum = 0;
		while(i>0)
		{
			int digit = i%10;
			i /= 10;
			sum += factorial[digit];
		}
		return sum;
	}
}