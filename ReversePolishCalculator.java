/**
 * Written by Bailey Metz
 */
import java.util.Scanner;

public class ReversePolishCalculator {
	
	//The Calculating method
	public static void ReversePolishCalc(String calcData) {
		
		String cleanExpr = clearSigns(calcData);
		Stack<Integer> stack = new Stack<Integer>();
		
		
		//For each loop that cycles through the string
		for(String token:cleanExpr.split("\\s"))
		{

			Integer theToken = null;
			try
			{

				theToken = Integer.parseInt(token);
			}
			
			catch(NumberFormatException e)
			{
				//Exception
			}
			/**Storing the number entered and 
			 * adding a space between each entered in the string
			 */
			if(theToken != null)
			{
				//Push the stack if the token entered is not null
				stack.Push(Integer.parseInt(token+""));
			}
			//When a multiplication sign is detected
			else if(token.equals("*"))
			{
			
				int secondOperand = stack.Pop();
				int firstOperand = stack.Pop();
				stack.Push(firstOperand * secondOperand);
			}
			//When a division sign is detected
			else if(token.equals("/"))
			{
			
				int secondOperand = stack.Pop();
				int firstOperand = stack.Pop();
				
				//DIVIDE BY ZERO ERROR
				if(secondOperand == 0)
				{
					System.out.println("Cannot divide by 0!");
					return;
				}
				
				stack.Push(firstOperand / secondOperand);
				
			}
			//When a subtraction sign is detected
			else if(token.equals("-"))
			{
			
				int secondOperand = stack.Pop();
				int firstOperand = stack.Pop();
				stack.Push(firstOperand - secondOperand);
			}
			//When an addition sign is detected
			else if(token.equals("+"))
			{
				int secondOperand = stack.Pop();
				int firstOperand = stack.Pop();
				stack.Push(firstOperand + secondOperand);
			}
			//Improperly formatted equation
			else
			{
				System.out.println("Improperly formatted!");
				System.out.println("0");
				return;
			}
			
		}
		int data = stack.Pop();
		
		//Error Checking
		if(stack.Pop() != null)
		{
			System.out.println("Improperly formatted!");
			System.out.println("0");
		}
		else
		{
			//Printing the result of the computation
			System.out.println(data);
		}
	}
 
	private static String clearSigns(String calcData)
	{
		//remove all non-operators, non-whitespace, and non digit chars
		return calcData.replaceAll("[^\\^\\*\\+\\-\\d/\\s]", "");
	}
 
	//Main method
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		boolean quit = false;
		
		//Keeping the program running until it is exited by the user
		while(quit != true)
		{
			//User prompt
			System.out.println("Enter a reverse polish expression or 'quit' to quit");
			
			//Storing the response 
			String chars = keyboard.nextLine();
			if(chars.equalsIgnoreCase("quit"))
			{
				System.out.println("GOODBYE");
				quit = true;
				System.exit(0);
			}
			/**Calling the ReversePolishCalculator Method
			 * with the parameters of the entered numbers/operating
			 * signs from above
			 */
			ReversePolishCalc(chars);
		}
		
	}
}
	