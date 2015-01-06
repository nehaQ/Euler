// 9digit prime no - all digits 1-9 used just once
public class PandigitalPrime
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(new File("Prime-1000000.txt"));
		scan.useDelimiter(",");
		

		// Read the file into a list :(
		while(scan.hasNext())
		{
			int number = Integer.parseInt(scan.next());
			primes.add(number);
		}	
	}
}