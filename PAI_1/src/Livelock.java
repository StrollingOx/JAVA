public class Livelock
{
    static final Object1 object1 = new Object1();
    static final Object2 object2 = new Object2();
    private long startTime;
    private long endTime;


    public void launch()
    {
        startTime = System.currentTimeMillis();
        endTime = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable()
        {
            public void run() {
                object1.completeAction1(object2);
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                object2.completeAction2(object1);
            }
        });
        t2.start();

        do
        {
            endTime = System.currentTimeMillis();
            if((endTime-startTime)>5000)
            {

                t1.stop();
                t1.interrupt();
                t2.stop();
                t2.interrupt();
                System.out.println("TIMEOUT");
                break;
            }
        }while((endTime-startTime)<50000);
    }

}