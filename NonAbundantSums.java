public class NonAbundantSums
{
	
	public static void main(String[] args)
	{
		long sum = 0;
		for(int i = 1; i<=20161; i++)
			if(check(i))
				sum += i;
		System.out.println(sum);
	}

	static boolean check(int num)
	{
		int sum = 0;
		for (int i =1; i<=(num/2);i++)
			if(num%i == 0)
				sum += i;
		if(sum < num)
			return true;
		else return false;
	}
}