public class Object2 
{
	private boolean action2 = false;
	
	public void completeAction2(Object1 object1)
	{
		while(!object1.isAction1Completed())
		{
			System.out.println("Object2: waiting for Object1 to complete Action1");
			try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
		}
		System.out.println("Object2: Action2 completed");
		this.action2 = true;
	}
	
	public boolean isAction2Completed()
	{
		return this.action2;
	}
}
