import java.util.*;
import java.util.Scanner;

public class PhobiaHashTable {
	
Scanner keyboard = new Scanner(System.in);
//Making the array list of Phobias
private ArrayList<Phobia>[] table;

	
	public PhobiaHashTable()
	{
		table = new ArrayList[10];
		for(int i=0; i<table.length; i++)
		{				
			table[i] = new ArrayList<Phobia>();
		}
		
	}
	
	//Hash function
	private int calculateIndex(Phobia aPhobia)
	{
		int index = 0;
		String nameAndDescription = aPhobia.getName() + aPhobia.getDescription();
		for(int i=0; i<nameAndDescription.length(); i++)
		{
			index += nameAndDescription.charAt(i);
		}
		index %= 10;
		return index;
	}
	
	//Adding a FEAR
	public void addPhobia(Phobia aPhobia)
	{
		
		System.out.println("What is the fear's name?");
		String fearName = keyboard.nextLine();
		System.out.println("Describe the fear");
		String fearDescription = keyboard.nextLine();
		aPhobia.setName(fearName);
		aPhobia.setDescription(fearDescription);
		int index = calculateIndex(aPhobia);
		table[index].add(aPhobia);

	}
	
	//Removing a Fear from the list
	public void remove(Phobia aPhobia)
	{
		System.out.println("Enter the index");
		int index = keyboard.nextInt();
		keyboard.nextLine();
		if(table[index].contains(aPhobia))
		{
			System.out.println(aPhobia.toString());
			System.out.println("Are you sure you want to delete this fear?");
			String answer = keyboard.nextLine();
			if(answer.equalsIgnoreCase("Yes"))
			{
				table[index].remove(aPhobia);
			}
			else
			{
				System.out.println("Fear not conquered (not deleted)!");
				return;
			}
			
		}
		else
		{
			System.out.println("Phobia not found!");
		}
		index = calculateIndex(aPhobia);
	}
	//Query
	public String lookUp(String aName)
	{
		/**Phobia tempPhobia = new Phobia();
		tempPhobia.setName(aName);
		int index = calculateIndex(tempPhobia);
		for(int i=0; i<table[index].size(); i++)
		{
			if(table[index].get(i).getName().equals(aName))
			{
				return table[index].get(i).toString();
			}
		}
		return "Phobia not found";
		
		*/
		
		System.out.println("Enter the index of the fear");
		int index = keyboard.nextInt();
		keyboard.nextLine();
		if(table[index].contains(aName))
		{
			System.out.println(table[index].get(index).toString());
		}
		else
		{
			System.out.println("Phobia not found!");
		}
		index = calculateIndex(aName);
		
	}
	
	//Method that prints the entire Hash Table
	public void printHashTable()
	{
		for(int i=0; i<table.length; i++)
		{				
			for(int j=0; j<table[i].size(); j++)
			{
				System.out.println(table[i].get(j).toString());
			}
		}
		
	}

}
