/**
 * This program executes a game where a user plays a series of games 
 * of Tic Tac Toe against the computer, and tries to remains 
 * undefeated for as long as possible.
 * 
 * NOTE: THE WAY THIS PROGRAM IS WRITTEN, IT IS NOT POSSIBLE FOR THE PLAYER 
 * OR THE COMPUTER TO WIN ON THE LAST MOVE OF THE GAME. A TIE (CAT) WILL OCCUR 
 */

/**
 * Written by Bailey Metz
 */

import java.util.Scanner;
import java.util.Random;

public class TicTacToe
{
  public static Scanner sc = new Scanner(System.in);
  
  
//MAIN METHOD WHICH RUNS THE PROGRAM
  public static void main(String[] args)
  {
	  Scanner keyboard = new Scanner(System.in);
	  Random r = new Random();
	// First, welcome message and display the board.
	    System.out.println("===== WELCOME TO THE TIC-TAC-TOE GAME!! =====");
	    System.out.println("\nIf you enter a negative number, the game will "
	    		+ "\nimmediately end and the computer wins by default.");
	  boolean imDone = false;
	  int gameWins = 0;
	  while(imDone == false)
	{
		  
	  
    final int SIZE = 3;
  //GAME BOARD
    char[][] board = new char[SIZE][SIZE]; 
 // initialize the board (with blanks for all possible spaces)
    resetBoard(board);
    showBoard(board);

    //Then ask the user which symbol (x or o) he/she wants to play.
    /**
     * NOTE: ANY LETTER SYMBOL CAN BE ENTERED INTO THE KEYBOARD, AND THE GAME WILL CONTINUE TO PLAY
     * WITHOUT ANY PROBLEMS. IT IS PROGRAMMED TO JUST SEARCH FOR 3 OF A KIND OF ANY SET OF LETTERS/NUMBERS/SYMBOLS
     */
    System.out.print(" Which symbol do you want to play, \"x\" or \"o\"? ");
    char userSymbol = sc.next().toLowerCase().charAt(0);
    char compSymbol = (userSymbol == 'x') ? 'o' : 'x';

    //Also ask whether or not the user wants to go first.
    System.out.println();
    System.out.print("  Do you want to go first (y/n)? ");
    char ans = sc.next().toLowerCase().charAt(0);

 // 0 -- the user, 1 -- the computer
    int turn;  
    int remainCount = SIZE * SIZE; // empty space count

    // THE VERY FIRST MOVE in game.
    if (ans == 'y') 
    {
      turn = 0;
      userPlay(board, userSymbol); //user puts his/her first tic on the board
    }
    else 
    {
      turn = 1;
      compPlay(board, compSymbol); //computer puts its first tic on the board
    }
    // Show the board, and decrement the count of remaining cells for the player and computer to choose from
    showBoard(board);
    remainCount--;

    // Play the game until either one wins.
    boolean done = false;
    int winner = -1;   // 0 -- the user, 1 -- the computer, -1 -- draw

    while (!done && remainCount > 0) 
    {
      // If there is a winner at this time, set the winner and the done flag to true.
      done = isGameWon(board, turn, userSymbol, compSymbol); // Did the turn win?

      if (done)
        winner = turn; // the one who made the last move won the game
      else 
      {
        // No winner yet.  Find the next turn and play.
        turn = (turn + 1 ) % 2;

        if (turn == 0)
          userPlay(board, userSymbol);
        else
          compPlay(board, compSymbol);

        // Show the board after one tic, and decrement the rem count.
        showBoard(board);
        remainCount--;
      }
    }

    // Winner is found.  Declare the winner.
    if (winner == 0)
    {
      System.out.println("YOU WIN.  The computer demands a rematch!");
      gameWins++;
      imDone = false;
    }
    else if (winner == 1)
    {
    	//LOSING TO THE COMPUTER... DECISIONS FOLLOW....
      System.out.println("\n** THE COMPUTER WINS!..  Your winning streak is over! :) **");
      System.out.println("You won a total of "+gameWins +" game(s)");
      System.out.println("");
      System.out.println("Enter your name to record your score!");
      String winningName = keyboard.nextLine();
      System.out.println("");
      System.out.println("Name: "+winningName +"\nGames won: "+gameWins);
      System.out.println("Would you like to play again? (y/n)");
      String gameAgain = keyboard.nextLine();
	      
      //IF ELSE STATEMENT TO DETERMINE TO PLAY AGAIN OR QUIT
      	if(gameAgain.equalsIgnoreCase("y"))
	      {
      			System.out.println("THE TOURNAMENT RESTARTS!!!");
      			gameWins = 0;
      			imDone = false;
	      }
	      else
	      {
	    	  //QUITTING THE GAME
	    	  System.out.println("GOODBYE!");
	    	  imDone = true;
	    	  
	      }
    }
    else
    {
    	//"CAT" or "draw" occurred 
    	System.out.println("\n** It's a CAT... Keep playing! **");
    	imDone = false;
    }

	  }
  }

  //METHOD WHICH RESETS THE BOARD
  public static void resetBoard(char[][] brd)
  {
    for (int i = 0; i < brd.length; i++)
      for (int j = 0; j < brd[0].length; j++)
        brd[i][j] = ' ';
  }

  //METHOD WHICH DISPLAYS THE BOARD
  public static void showBoard(char[][] brd)
  {
    int numRow = brd.length;
    int numCol = brd[0].length;

    System.out.println();

    // WRITING THE COLUMN HEADER
    System.out.print("    ");
    for (int i = 0; i < numCol; i++)
      System.out.print(i + "   ");
    System.out.print('\n');

    System.out.println(); //blank line after the header

    // WRITING THE TABLE
    for (int i = 0; i < numRow; i++) 
    {
      System.out.print(i + "  ");
      for (int j = 0; j < numCol; j++) 
      {
        if (j != 0)
          System.out.print("|");
        System.out.print(" " + brd[i][j] + " ");
      }
      
      //BLANK SPACE
      System.out.println();

      if (i != (numRow - 1)) 
      {
        //SEPARATING LINES FOR THE TIC TAC TOE BOARD
        System.out.print("   ");
        for (int j = 0; j < numCol; j++) 
        {
          if (j != 0)
            System.out.print("+");
          System.out.print("---");
        }
        System.out.println();
      }
    }
    System.out.println();
  }
  
  
  //METHOD WHICH ALLOWS THE USER TO PLAY THE GAME (MAKE MOVES)
  public static void userPlay(char[][] brd, char usym)
  {
    System.out.print("\nEnter the row and column indices: ");
    int rowIndex = sc.nextInt();
    int colIndex = sc.nextInt();
    if(rowIndex < 0 || colIndex < 0)
    {
    	System.out.println("GAME OVER. Computer Wins by default.");
    	System.exit(0);
    }
    
    while (brd[rowIndex][colIndex] != ' ') 
    {
      System.out.print("\n!! The SPACE is already taken.\nEnter the ROW and COLUMN indices: ");
      rowIndex = sc.nextInt();
      colIndex = sc.nextInt();
    }

    brd[rowIndex][colIndex] = usym;
  }

  //METHOD WHICH MAKES THE COMPUTER PLAY (MAKE MOVES)
  public static void compPlay(char[][] brd, char csym)
  {
    // Find the first empty cell and put a tic there.
    for (int i = 0; i < brd.length; i++) 
    {
    	
      for (int j = 0; j < brd[0].length; j++) 
      {
        if (brd[i][j] == ' ') 
        { // empty cell
          brd[i][j] = csym;
          return;
        }
      }
    }
  }

  //CHECKING THE GAME FOR WINNERS BY COMP OR PLAYER
  public static boolean isGameWon(char[][] brd, int turn, char usym, char csym)
  {
    char sym;
    if (turn == 0)
      sym = usym;
    else
      sym = csym;

    int i, j;
    boolean win = false;

    //CHECK FOR WIN BY ROW
    for (i = 0; i < brd.length && !win; i++) {
      for (j = 0; j < brd[0].length; j++) {
        if (brd[i][j] != sym)
          break;
      }
      if (j == brd[0].length)
        win = true;
    }

    //CHECKING FOR WIN BY COLUMN
    for (j = 0; j < brd[0].length && !win; j++) {
      for (i = 0; i < brd.length; i++) {
        if (brd[i][j] != sym)
          break;
      }
      if (i == brd.length)
        win = true;
    }

    // CHECK WIN BY DIAGONAL (1)
    if (!win) 
    {
      for (i = 0; i < brd.length; i++) 
      {
        if (brd[i][i] != sym)
          break;
      }
      if (i == brd.length)
        win = true;
    }

    // CHECK WIN BY DIAGONAL (2)
    if (!win) {
      for (i = 0; i < brd.length; i++) {
        if (brd[i][brd.length - 1 - i] != sym)
          break;
      }
      if (i == brd.length)
        win = true;
    }

    // RETURN WIN FOR THE GAME
    return win;
  }
  
  
}