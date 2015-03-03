// A number is palindrom in decimal and binary

public class DoubleBase
{
	public static void main(String[] args) {
		int sum = 0;
		for(int i =1; i<1000000;i++)
		{
			if(i == mirror(i))
			{
				// binary of i as string
				String binaryI = Integer.toBinaryString(i);
				// reverse this string
				String mirrorBin = mirrorB(binaryI);
				if(binaryI.equals(mirrorBin))
					sum += i;
			}
		}
		System.out.println(sum);
	}

	private static String mirrorB(String s)
	{
		String t = "";
		int n = s.length() - 1;
		while(n>=0)
		{
			t = t+s.charAt(n);
			n--;
		}
		return t;
	}

	private static int mirror(int number)
	{
		int t = 0;
		while(number>0)
		{
			int digit = number%10;
			t = t*10 + digit;
			number /= 10;
		}
		return t;
	}
}