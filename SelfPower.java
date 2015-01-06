public class SelfPower
{
	public static void main(String[] args) {
		long last = 10000000000L;
		long sum = 0;

		for(int i =1; i<=1000;i++)
		{
			long temp = 1;
			for(int j =1;j<=i;j++)
			{
				temp *= i;
				if(temp >= Long.MAX_VALUE /1000)
					temp %= last; 
			}
			sum += temp;
			sum %= last;
		}
		System.out.println(sum);
	}
}