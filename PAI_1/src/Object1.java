public class Object1
{
    private boolean action1 = false;

    public void completeAction1(Object2 object2)
    {
        while(!object2.isAction2Completed())
        {
            System.out.println("Object1: waiting for Object2 to complete Action2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Object1: Action1 completed");
        this.action1 = true;
    }

    public boolean isAction1Completed()
    {
        return this.action1;
    }
}