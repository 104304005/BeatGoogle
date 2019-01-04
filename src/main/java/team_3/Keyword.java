package team_3;

public class Keyword
{
	public String name;
	public Double weight;

	public Keyword(String name, Double weight)
	{
		this.name = name;
		this.weight = weight;
	}

	@Override
	public String toString()
	{
		return "[" + name + "," + weight + "]";
	}
}
