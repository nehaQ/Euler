import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PrimeGenerator
{
	public static void main(String[] args) throws IOException {
		int mode = Integer.parseInt(args[0]); // 1- noofPrimes, 2 - primesbelow
		int modeLimit = Integer.parseInt(args[1]);
		String fileName = args[2];
		
		File writeTo = new File(fileName);
		if(!writeTo.exists())
			writeTo.createNewFile();
		FileWriter fw = new FileWriter(writeTo);
		
		int number = 2;
		fw.write(number + ",");
		number++;
		
		if(mode == 1)
		{
			for(int i=0;i<modeLimit;)
			{
				if(isPrime(number))
				{
					i++;
					fw.write(number + ",");
				}
				number+=2;
			}
		}
		else
		{
			for(int no=3;no<=modeLimit;no=no+2)
			{
				if(isPrime(no))
					fw.write(no + ",");
			}
		}
		
		fw.close(); // fw should handle creation, opening and closing of file
	}

	private static boolean isPrime(int number)
	{
		for(int i = 2;i<=Math.sqrt(number); i++)
		{
			if(number%i == 0)
				return false;
		}
		return true;
	}
}