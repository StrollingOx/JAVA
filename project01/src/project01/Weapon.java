package project01;

public class Weapon extends Armor implements Item 
{
	private String itemType = "Weapon";
	private int minAtt;
	private int maxAtt;
	private int levelRequirement;
	
	@Override
	public String getItemType()
	{
		return itemType;
	}
	@Override
	public void specialEffect(){}
}
