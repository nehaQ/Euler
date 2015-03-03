import java.io.*;
import java.util.*;

public class MaximumPathSum1
{
	public static void main(String[] args) throws IOException {
		// write some code to invert the input
		File triangle = new File ("Triangle100.txt");
		Scanner scan = new Scanner(triangle);
		ArrayList<String> reverse = new ArrayList<String>();
		int lines = 0;

		while(scan.hasNext())
		{
			reverse.add(scan.nextLine());
			lines++;
		}

		PrintWriter invertedFile = new PrintWriter(triangle);
		Collections.reverse(reverse);

		for(String s: reverse)
			invertedFile.println(s);

		invertedFile.close();

		Scanner scanTriangle = new Scanner(triangle);
		int penultimateArray[] = new int[lines-1];
		int ultimateArray[] = new int[lines];

		String line = scanTriangle.nextLine();
		int j = 0;
		String tokens[] = line.split(" ");
		for(String token : tokens)
			ultimateArray[j++] = Integer.parseInt(token);

		line = scanTriangle.nextLine();
		int k =0;
		tokens = line.split(" ");
		for(String token : tokens)
			penultimateArray[k++] = Integer.parseInt(token);

		int penLength = penultimateArray.length;
		int ulLength = ultimateArray.length;

		while(scanTriangle.hasNext())
		{
			for(int i =0; i< penLength; i++)
				penultimateArray[i] += (int)Math.max(ultimateArray[i], ultimateArray[i+1]);

			// bring the penultimate row to the last one
			for (int i = 0;i<penLength ; i++) 
				ultimateArray[i] = penultimateArray[i];	
			ulLength--;
			
			// read next line in file
			line = scanTriangle.nextLine();
			tokens = line.split(" ");

			try
			{for(int p = 0;p<tokens.length;p++)
							penultimateArray[p] = Integer.parseInt(tokens[p]);}
			catch (Exception e){
				// this line throws an exception alternatively for an array out of bound of penarray :/
			}
			penLength--;
		}

		for(int i =0; i< penLength; i++)
				penultimateArray[i] += (int)Math.max(ultimateArray[i], ultimateArray[i+1]);

		System.out.println(penultimateArray[0]);	
	}
}