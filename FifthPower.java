public class FifthPower
{
	private static int[] powers = new int[10];
	public static void main(String[] args) {
		for(int i=0;i<powers.length; i++)
			powers[i] = (int)Math.pow(i, 5);
		int sum = 0;
		for(int i=10; i<=336294;i++)
		{
			if(i == sumOf(i))
				sum += i;
		}
		System.out.println(sum);
	}

	private static int sumOf(int i)
	{
		int sum = 0;
		while(i>0)
		{
			int digit = i%10;
			i /= 10;
			sum += powers[digit];
		}
		return sum;
	}
}