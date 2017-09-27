import java.util.Scanner;
public class PhobiaDriver {

	public static void main(String[] args) {

				Scanner keyboard = new Scanner(System.in);
				//Create a new instance of a Hash Table
				PhobiaHashTable a = new PhobiaHashTable();
				//prompt the user
				System.out.println("");
				System.out.println("Welcome to the fear hash table!");
				boolean quit = false;
				int input = 0;
				while(quit == false)
				{
					//Prompt the user
					System.out.println("Enter:");
					System.out.println("1. To add a fear");
					System.out.println("2. To remove a fear");
					System.out.println("3. Look up a fear");
					System.out.println("4. Print all fears");
					System.out.println("5. Quit");
					Phobia b = new Phobia();
					//Get the input
					input = keyboard.nextInt();
					keyboard.nextLine();
					switch(input)
					{
					
					case 1:
						a.addPhobia(b);	
						break;
					case 2:
						a.remove(b);
						break;
					case 3:
						a.lookUp(b);
						break;
					case 4:
						a.printHashTable();
						break;
					case 5:
						System.out.println("Goodbye Fears!");
						quit = true;
						break;
					default:
						System.out.println("Invalid input");
						break;
					}
				}

			}

	}
