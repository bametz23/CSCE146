import java.util.Scanner;
import java.util.*;
import java.util.Stack;

public class WellFormed extends Stack {

	
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		boolean quit = false;
		
			while(quit == false)
		{
			Stack<Character> stack = new Stack<Character>();
			
			System.out.println("");
			System.out.println("Enter a string");
			
			String phrase = keyboard.nextLine(); 
			
			System.out.println(isBalanced(phrase, 0, new Stack<Character>()));
			
		}
	}

	public static boolean isBalanced(String phrase, int i, Stack<Character> check) {
		
		if (i == phrase.length())
		{
			return check.isEmpty();
		}

		char c = phrase.charAt(i);
		
		if (c == '}' || c == ')' || c == '>' || c == '"') 
		{
			char e = check.isEmpty() ? '\0' : check.pop();
			if(e != c)
			{
				return false;
			}
		}

		if(c == '{')
		{
			check.push('}');
		}
		else if(c == '(')
		{
			check.push(')');
		}
		
		else if(c == '<')
		{
			check.push('>');
		}
		
		else if(c == '"')
		{
			check.push('"');
		}

	return isBalanced(phrase, i+1, check);

	}

}
