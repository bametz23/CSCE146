
public class Phobia {

	private String name;
	private String description;
	
	public Phobia()
	{
		name = description = "none yet";
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String aName) 
	{
		this.name = aName;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String aDescription) 
	{
		this.description = aDescription;
	}

	
	public String toString()
	{
		return this.name + "\n" + this.description;
	}
	
	public boolean equals(Phobia aPhobia)
	{
		return this.name.equals(aPhobia.getName()) 
				&& this.description.equals(aPhobia.getDescription());
	}
	
	

}

