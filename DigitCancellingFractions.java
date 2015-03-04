/*The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it 
may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than one in value,
and containing two digits in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find the value of the denominator.

-----------

Numbers will be of the form =  10n + i/10i + d = n/d
*/

public class DigitCancellingFractions
{
	public static void main(String[] args) {
		
		int denproduct = 1;
		int nomproduct = 1;
		 
		for (int i = 1; i < 10; i++) {
		    for (int den = 1; den < i; den++) {
		        for (int nom = 1; nom < den; nom++) {
		            if ((nom * 10 + i) * den == nom * (i * 10 + den)) {
		                denproduct *= den;
		                nomproduct *= nom;
		            }
		        }
		    }
		}

		System.out.println(nomproduct+"/"+denproduct);
	}
}