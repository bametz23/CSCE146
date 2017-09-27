
public class Player {
	
	//Instance variables
	private String name;
	private int wins;
	private int losses;
	private int ties;
	
	//Default constructor
	public Player()
	{
		name = "no name yet";
		wins = 0;
		losses = 0;
		ties = 0;
	}
	
	//Parameterized constructor
	public Player(String aName, int Wins, int Losses, int Ties)
	{
		this.name = aName;
		this.wins = Wins;
		this.losses = Losses;
		this.ties = Ties;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String aName) 
	{
		this.name = aName;
	}

	public int getWins() 
	{
		return wins;
	}

	public void setWins(int Wins) 
	{
		this.wins = Wins;
	}

	public int getLosses() 
	{
		return losses;
	}

	public void setLosses(int Losses) 
	{
		this.losses = Losses;
	}

	public int getTies() 
	{
		return ties;
	}

	public void setTies(int Ties) 
	{
		this.ties = Ties;
	}
	
	
	

}
