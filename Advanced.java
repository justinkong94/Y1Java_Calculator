public class Advanced extends Basic implements AdvancedCalculatorMethods//class Advanced which MainCalculator extends from
{	
	public double exponential(double a,double b)//exponential
	{
		return Math.pow(a,b);
	}

	public String binaryconversion(double a) throws ArithmeticException//convert to binary
	{ 
		if((a % 1) != 0)//check if input is an integer. If input is not an integer, throw exception
		{
			throw new ArithmeticException();
		}
		return Integer.toString((int)a,2);	
	}
	
	public double modulus(double a,double b)//modulus
	{
		return a % b;
	}
	
	public double factorial(double a) throws ArithmeticException//factorial
	{
		double result = 1;
		
		if((a % 1) != 0 || a < 0)//check if input is integer and is a positive number.If not, throw exception
		{
			throw new ArithmeticException();
		}
		
		for(double i = 1; i <= a; i++)
		{
			result = result * i;
		}
		return result;
	}
}