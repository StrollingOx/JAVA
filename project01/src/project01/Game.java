package project01;

public class Game 
{
	public static void main(String [] args)
	{
		Item sampleWeapon = new Weapon();
		Item sampleArmor = new Armor();
		
		System.out.println(sampleArmor.getItemType());
		System.out.println(sampleWeapon.getItemType());
	}
}
