import java.util.*;

public class IntegerRightTriangles
{
	public static void main(String[] args) {
		int[] perimeter = new int[1001];
		for(int a = 3; a<300; a++)
		{
			for(int b = 4; b<300; b++)
			{
				int sumOfSquare = a*a+b*b;
				int sqrt = (int)Math.sqrt(sumOfSquare);
				if(sqrt*sqrt == sumOfSquare && a+b+sqrt<=1000)
					perimeter[a+b+sqrt]++;
			}
		}

		int max = 0;
		int index = 0;
		for(int m = 0; m<perimeter.length;m++)
			if(perimeter[m] >max) {max = perimeter[m]; index =m;}
			//System.out.println(m);
		System.out.println(index);
	}
}