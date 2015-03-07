/*Pentagonal numbers are generated by the formula, Pn=n(3n−1)/2. The first ten pentagonal numbers are:

1, 5, 12, 22, 35, 51, 70, 92, 117, 145, ...

It can be seen that P4 + P7 = 22 + 70 = 92 = P8. However, their difference, 70 − 22 = 48, is not pentagonal.

Find the pair of pentagonal numbers, Pj and Pk, for which their sum and difference are pentagonal and 
D = |Pk − Pj| is minimised; what is the value of D?
*/

public class PentagonalNumbers
{
	private static boolean isPentagonal(int number) {
	    double penTest = (Math.sqrt(1 + 24 * number) + 1.0) / 6.0;
	    return penTest == ((int)penTest);
	}

	public static void main(String[] args) {
		int result = 0;
		boolean notFound = true;
		int i = 1;

		while (notFound) {
			i++;
			int n = (i*(3*i - 1))/2;

			for(int j = i-1; j>0;j--)
			{
				int m = (j*(3*j - 1))/2;
				if(isPentagonal(n-m) && isPentagonal(n+m))
				{
					result = n-m;
					notFound = false;
					break;
				}
			}
		}// end while

		System.out.println(result);
	}
}