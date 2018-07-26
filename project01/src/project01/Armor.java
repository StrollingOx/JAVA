package project01;

public class Armor implements Item
{
	private String itemType = "Armor";
	private int armor;
	private int levelRequirement;
	
	public int getArmor()
	{
		return armor;
	}
	
	@Override
	public String getItemType()
	{
		return itemType;
	}
	@Override
	public void specialEffect(){}
}
