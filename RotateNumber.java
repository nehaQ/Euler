public class RotateNumber
{
	public static void main(String[] args) {
		int number = 1234;
		int rotations = (int)Math.log10((double)number);
		int power = rotations;
		int rotatedN = 0;
		while(rotations > 0)
		{
			rotatedN = ((number%10) * (int)Math.pow(10, power)) + number/10;
			number = rotatedN;
			rotations--;
		}
	}
}