/*
 * Deadlock is a situation when two threads are waiting for each other and the waiting is never ends. Here both threads cant completes their tasks.
 * @author pai-59
 *
 */
public class Deadlock
{
    public void launch()
    {
        final String resource1 = "a";
        final String resource2 = "b";

        // t1 tries to lock resource1 then resource2
        Thread t1 = new Thread()
        {
            long startTime = System.currentTimeMillis();
            long endTime = System.currentTimeMillis();
            public void run()
            {
                synchronized (resource1)
                {
                    System.out.println("Thread 1: locked resource 1");
                    try
                    {
                        Thread.sleep(100);
                    } catch (InterruptedException ex)
                    {
                        ex.printStackTrace();
                    }
                    do
                    {
                        endTime = System.currentTimeMillis();
                        if((endTime-startTime)>4000)
                        {
                            System.out.println("Thread 1: TIMEOUT");
                            break;
                        }
                    }while((endTime-startTime)<5000);
                    synchronized (resource2)
                    {
                        System.out.println("Thread 1: locked resource 2");
                    }
                }
            }
        };


        // t2 tries to lock resource2 then resource1
        Thread t2 = new Thread()
        {
            long startTime = System.currentTimeMillis();
            long endTime = System.currentTimeMillis();

            public void run()
            {
                synchronized (resource2)
                {
                    System.out.println("Thread 2: locked resource 2");
                    try
                    {
                        Thread.sleep(100);
                    } catch (InterruptedException ex)
                    {
                        ex.printStackTrace();
                    }
                    do
                    {
                        endTime = System.currentTimeMillis();
                        if((endTime-startTime)>4000)
                        {
                            System.out.println("Thread 2: TIMEOUT");
                            break;
                        }
                    }while((endTime-startTime)<5000);
                    synchronized (resource1)
                    {
                        System.out.println("Thread 2: locked resource 1");
                    }
                }
            }
        };
        t1.start();
        t2.start();
        long start= System.currentTimeMillis();
        long end;
        do
        {
            end = System.currentTimeMillis();
            if((end-start)>6000)
            {
                t1.stop();
                t2.stop();
                t1.interrupt();
                t2.interrupt();
                System.out.println("Terminating DEADLOCK_DEMO...");
                break;
            }
        }while((end-start)<10000);


    }
}  