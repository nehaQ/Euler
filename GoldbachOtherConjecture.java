public class GoldbachOtherConjecture
{
	public static void main(String[] args) {
		int i = 9;

		while(true)
		{
			if(!conjectureHolds(i))
				break;
			i = nextCompositeOddNumber(i);
		}

		System.out.println(i);
	}

	private static boolean conjectureHolds(int number)
	{
		int square = 1;
		int limitCondition = (int)Math.sqrt(number/2 - 1);

		while(square <= limitCondition)
		{
			int x = number - (2*square*square);
			if(Prime.isPrime(x))
				return true;
			square++;
		}
		return false;
	}

	private static int nextCompositeOddNumber(int number)
	{
		number = number + 2;
		while(Prime.isPrime(number))
			number = number + 2;
		return number;
	}
}