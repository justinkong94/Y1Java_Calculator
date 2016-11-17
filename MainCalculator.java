import java.util.*;// self explanatory

public class MainCalculator extends Advanced //extends Advanced.java
{
	public static void main(String [] args)
	{
		Scanner console = new Scanner(System.in);//create new scanner to read input from console 
		Advanced calculator = new Advanced();// create new object of Advanced
		
		double firstnumber = 0;//first operand
		String operator = "reset";//operator to read signs(default is "reset")
		double secondnumber = 0;//second operand
		boolean isFirstNumberZero = true;//to check if the previous operand is 0
		
		System.out.println("Welcome To Java Calculator!\n");
		System.out.println("Core functions: ");
		System.out.println("'store' to store results, 'get' to retrieve results\n");
		System.out.println("Basic functions: ");
		System.out.println("'+' for addition, '-' for subtraction, '*' for multiplication, '/' for division\n");
		System.out.println("Advanced functions: ");
		System.out.println("'^' for exponential, 'binary' for binary, '%' for modulus, '!' for factorial\n");
		System.out.println("(Enter 0 to exit)");
		
		while(firstnumber != 0 || isFirstNumberZero == true)//if first operand entered is not 0, go into while loop
		{
		
			if(operator.equals("+"))//compare the equals sign
			{
				System.out.println(calculator.addition(firstnumber,secondnumber));//call addition method from Basic.java
				calculator.setpreviousresult(calculator.addition(firstnumber,secondnumber));//store answer using setpreviousresult method in Basic.java into private variable previousnumber as new first operand
			}
			else if(operator.equals("-"))//compare the minus sign
			{
				System.out.println(calculator.subtraction(firstnumber,secondnumber));//call subtraction method from Basic.java
				calculator.setpreviousresult(calculator.subtraction(firstnumber,secondnumber));//store answer as new first operand
			}
			else if(operator.equals("*"))//compare the multiply sign
			{
				System.out.println(calculator.multiplication(firstnumber,secondnumber));//call multiplication method from Basic.java
				calculator.setpreviousresult(calculator.multiplication(firstnumber,secondnumber));//store answer as new first operand
			}
			else if(operator.equals("/"))//compare the divide sign
			{
				try
				{
					System.out.println(calculator.division(firstnumber,secondnumber));//call division method from Basic.java
					calculator.setpreviousresult(calculator.division(firstnumber,secondnumber));//store answer as new first operand
				}
				catch(ArithmeticException ex)//if user tried to divide by 0,this exception is thrown from Basic.java and caught here
				{
					System.out.println("Error: You can't divide " + firstnumber + " by " + secondnumber);
				}
			}
			else if(operator.equals("^"))//compare the power sign
			{
				System.out.println(calculator.exponential(firstnumber,secondnumber));//call exponential method from Advanced.java
				calculator.setpreviousresult(calculator.exponential(firstnumber,secondnumber));//store answer as new first operand
			}
			else if(operator.equals("binary")) //compare the binary sign
			{
				try
				{
					System.out.println(calculator.binaryconversion(firstnumber));//call binaryconversion method from Advanced.java
					calculator.setpreviousresult(firstnumber);//store answer as new first operand
				}
				catch(ArithmeticException ex)//if input is not an integer or input is not a positive integer, this exception is thrown from Advanced.java and caught here
				{
					System.out.println("Error: You can only convert integers to binary.");
				}
			}
			else if(operator.equals("%"))//compare the modulus sign
			{
				System.out.println(calculator.modulus(firstnumber,secondnumber));//call modulus method from Advanced.java
				calculator.setpreviousresult(calculator.modulus(firstnumber,secondnumber));//store answer as new first operand
			}
			else if(operator.equals("!"))//Im assuming that factorial only takes integers because fractional factorials require the use of gamma function of which I can't even understand the function
			{
				try
				{
					System.out.println(calculator.factorial(firstnumber));//call factorial method from Advanced.java
					calculator.setpreviousresult(calculator.factorial(firstnumber));//store answer as new first operand
				}
				catch(ArithmeticException ex)//must be non-negative number and integer,exception thrown from Advanced.java
				{
					System.out.println("Error: You can only get factorials of integers which are also positive.");
				}
			}
			else if(operator.equals("store"))//compare the store sign
			{
				calculator.storeresult(calculator.getpreviousresult());//stores the previous result into private variable savednumber in Basic.java
				System.out.println(calculator.getpreviousresult() + " was stored.");
			}
			else if(operator.equals("get"))//compare the get sign
			{
				System.out.println(calculator.getstoredresult() + " was retrieved.Current value is " + calculator.getstoredresult());//retrieve value of private variable savednumber in Basic.java
				calculator.setpreviousresult(calculator.getstoredresult());//store retrieved answer as new first operand
			}
			else if(operator.equals("reset"))//default sign with no message
			{
			}
			else//any other invalid operator entered by user comes here
			{
					System.out.println("Error: You entered an invalid operator.");
			}
				
			System.out.printf(">>");
			isFirstNumberZero = false;//set false to prevent infinite loop
			
			if(console.hasNextLine())//wait for user to type one line of input
			{
				String line = console.nextLine();//store entered input into string variable
				Scanner linescan = new Scanner(line);//create a scanner to read the string
				
				try
				{
					if(linescan.hasNextDouble())//if first data is a number,enter this
					{
						firstnumber = linescan.nextDouble();//read first number as double
						
						if(firstnumber != 0)//if first number is 0,exit program
						{
							operator = linescan.next();//next data should be the operator

							if(operator.equals("binary"))
							{	
								if(linescan.hasNext())//if there are more data after the operator,throw exception
										throw new InputMismatchException();
							}
							else if(operator.equals("!"))
							{
								if(linescan.hasNext())//if there are more data after the operator,throw exception
										throw new InputMismatchException();
							}
							else//if operator is not binary or factorial enter here
							{
								try
								{
									secondnumber = linescan.nextDouble();//try reading the next data as a number
									
									if(linescan.hasNext())//if there are more data after the number,throw exception
										throw new InputMismatchException();
								}
								catch(InputMismatchException ex)//if secondnumber cannot be read as type double,enter here. As with all the other InputMismatchException
								{
									System.out.println("Error: You entered invalid data.");
									operator = "reset";//switch the operator to default state
								}
							}
						}
					}
					else if(linescan.hasNext())//if first data is not a number,enter here
					{
						firstnumber = calculator.getpreviousresult();//assume user wants to use previous result as first operand
						operator = linescan.next();//next data should be read as operator
						
						if(operator.equals("binary"))//all same as above:
						{	
							if(linescan.hasNext())
										throw new InputMismatchException();
						}
						else if(operator.equals("!"))
						{
							if(linescan.hasNext())
										throw new InputMismatchException();
						}
						else if(operator.equals("store"))//store can only be used if there is no number in front of it
						{
							if(linescan.hasNext())
										throw new InputMismatchException();
						}
						else if(operator.equals("get"))//get can only be used if there is no number in front of it
						{
							if(linescan.hasNext())
										throw new InputMismatchException();
						}
						else
						{
							try//same as above: 
							{
								secondnumber = linescan.nextDouble();
								
								if(linescan.hasNext())
										throw new InputMismatchException();
							}
							catch(InputMismatchException ex)
							{
								System.out.println("Error: You entered invalid data.");
								operator = "reset";
							}
						}
						
						if(firstnumber == 0)//if previousresult is 0, enter here. This causes the while loop to continue
						{
							isFirstNumberZero = true;
						}
					}
				}
				catch(NoSuchElementException ex)//all other errors come here
				{
					System.out.println("Error: You entered invalid data.");
					operator = "reset";
					isFirstNumberZero = true;//ensure that the while loop continues.
				}
			}
		}

		System.out.println("Thank you for using this calculator.");
	}
}