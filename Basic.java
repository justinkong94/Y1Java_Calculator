public abstract class Basic implements BasicCalculatorMethods//abstract class Basic
{
	private double previousnumber = 0;//store previous result
	private double savednumber = 0;//store result that user wants to save
	
	public void setpreviousresult(double a)//modify private variable previousnumber
	{
		previousnumber = a;
	}
	
	public double getpreviousresult()//return private variable previousnumber
	{
		return previousnumber;
	}
	
	public void storeresult(double a)//modify private variable savednumber
	{
		savednumber = a;
	}
	
	public double getstoredresult()//return private variable savednumber
	{
		return savednumber;
	}

	public double addition(double a,double b)//add
	{
		return a + b;
	}
	
	public double subtraction(double a,double b)//subtract
	{
		return a - b;
	}
	
	public double multiplication(double a,double b)//multiply
	{
		return a * b;
	}
	
	public double division(double a,double b) throws ArithmeticException//divide
	{
		if(b == 0)//throws exception if user tries to divide by 0
		{
			throw new ArithmeticException();
		}
		return a/b;
	}

}