public class Fibonacci1000
{
	public static void main(String[] args) {
		int a = 1, b=1, c=1, t=2;
		while((int)Math.log10(c) < 10)
		{
			c = a+b;
			a = b;
			b = c;
			t++;
		}
		System.out.println(t);
	}
}