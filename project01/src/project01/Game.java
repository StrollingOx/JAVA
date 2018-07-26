package project01;

public class Game 
{
	public static void main(String [] args)
	{
		Weapon a = new Weapon();
		System.out.println(a.getArmor());
		fun(a);
	}
	
	public static void fun(Item abc)
	{
		System.out.println(abc.getItemType());
	}
}
