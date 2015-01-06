// calculate the sum of digits in X!
public class sumOfFactorial
{
	
	public static void main(String[] args)
	{
		int PRIME = Integer.parseInt(args[0]);
		int primes[] = new int [PRIME+1];
		// sum of digits of 100!
		int p=0;
		for(int i=2;i<=PRIME;i++)
		{
			if(primes[i] != -1)
			{
				p = i+i;
				while(p<=PRIME)
				{
					primes[p] = -1;
					//primes[i]++;
					p += i;
					
				}
			}
		}// end for loop

		int tens[]= new int[200];
		int lastPrime = 2;
		for(int prime = 2; prime <=PRIME; prime++)
		{
			if(primes[prime] != -1)
			{
				int power = 1;
				int x = (int)Math.pow(prime, power);
				while(x<=PRIME)
				{
					primes[prime] += PRIME/x;
					power++;
					x = (int)Math.pow(prime, power);
				}// end while
				lastPrime = prime;
			}// end if prime
		}// end for


		for(int x:primes)
				System.out.print(x+"...");
			System.out.println("\n\n");
			

		int i =0;
		int power = (int)Math.pow(lastPrime, primes[lastPrime]);
		while(power>0)
		{
			tens[i] = power%10;
			power /= 10;
			i++;
		}

		for(int x:tens)
				System.out.print(x+"__");
			System.out.println("\n\n");

		for(int prime = lastPrime - 1; prime >= 2; prime--)
		{
			while(primes[prime] >0)
			{
				
				multi(prime, tens);
				primes[prime]--;
				for(int k: tens)
					System.out.print(k+"__");
				System.out.println();
			}
			
		}


		int sum = 0;
		for(int k = 0;k<tens.length;k++)
		{
			sum += tens[k];
		}
		System.out.println("sum" +sum);
	}

	public static void multi(int prime, int[] scaled)
	{
		for(int i =0;i<scaled.length;i++)
			scaled[i] *= prime;
		for(int i=0;i<scaled.length;i++)
		{
			if(scaled[i]>=10)
			{
				int temp = scaled[i];
				scaled[i] = temp%10;
				scaled[i+1] +=temp/10;
			}
		}
		
	}
}