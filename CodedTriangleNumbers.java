/*The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we
form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle 
number then we shall call the word a triangle word.

How many are triangle words?
*/

import java.io.*;
import java.util.*;

public class CodedTriangleNumbers
{
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("words.txt"));
		scan.useDelimiter(",");

		int count = 0;
		int wordValue = 0;

		while(scan.hasNext())
		{
			String word = scan.next();
			wordValue = wordVal(word);
			if(isTriangleNumber(wordValue))
				count++;
		}
		System.out.println(count);
	}

	private static int wordVal(String word)
	{
		int value = 0;

		for(int i = 1; i<word.length()-1; i++)
			value = value + ((int)word.charAt(i) - 64);

		return value; // remove the two quotes
	}

	private static boolean isTriangleNumber(int number)
	{
		int i = 1;
		int triangle = ((i*(i+1))/2);
		while(triangle <= number)
		{
			if(triangle == number)
				return true;
			i++;
			triangle = ((i*(i+1))/2);
		}
		return false;
	}
}