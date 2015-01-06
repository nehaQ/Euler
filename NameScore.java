import java.io.*;
import java.util.*;

public class NameScores
{
	
	public static void main(String[] args)throws IOException
	{
		FileReader file = new FileReader("p022_names.txt");
		String content = new Scanner(file).useDelimiter("\\Z").next();
		String names [] = content.split(",");
		Arrays.sort(names);
		int sum = 0;
		int i = 1;
		for(String name:names)
			sum += value(name)*(i++);
		System.out.print(sum);
	}
	public static int value(String name)
	{
		int sum = 0;
		for(int i = 1; i<name.length()-1;i++)
			sum += (int)(name.charAt(i)) - 64;
		return sum;
	}
}