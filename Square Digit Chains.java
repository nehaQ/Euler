class hello
{
	public static void main(String[] args) {
		int limit = 10000000;
		int counter = 0;
		for(int i = 1; i<=limit;i++)
		{
			if(its89(i))
				counter++;
		}
		System.out.println(counter);
	}

	public static boolean its89(int number)
	{
		if(number == 89)
			return true;
		else if(number == 1)
			return false;
		else
		{
			int digit;
			int sum = 0;
			while(number>0)
			{
				digit = number%10;
				number /= 10;
				sum += digit*digit;
			}
			return its89(sum);
		}
	}
}

