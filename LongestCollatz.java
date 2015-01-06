// Had a overflow error with variable 'number' when it was of datatype 'int'
public class LongestCollatz
{
	public static void main(String[] args) {
		int[] lengths = new int[1000000];
		lengths[13] = 10;
		lengths[2] =2;
		long number;
		int longestLength = 0;

		for(int i=3;i<=999999;i++)
		{
			number = i;
			int thisLength = 0;
			outer: while(number>1)
			{
				if(number<=999999 && lengths[(int)number] > 0)
				{
					thisLength = thisLength + lengths[(int)number];
					break outer;
				}
				if(number%2 == 0)
					number  /= 2;
				else
					number = number*3 + 1;
				thisLength++;
			}

			lengths[i] = thisLength;

			if(lengths[i] > longestLength)
				longestLength = lengths[i];
		}
		System.out.println(longestLength);
	}
}