package project01;

public class Weapon implements Item
{
	private String itemType = "Weapon";
	
	@Override
	public String getItemType()
	{
		return itemType;
	}
}
