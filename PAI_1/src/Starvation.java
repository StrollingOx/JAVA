public class Starvation
{
    public void launch() {
        Thread t1 = new Thread()
        {

            public void run()
            {
                for (;;)
                {
                    System.out.printf("THREAD 1: Im doing something!\n");
                    /*
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    */
                }
            }
        };
        t1.setPriority(10);

        Thread t2 = new Thread()
        {

            public void run() {
                for (;;)
                {
                    System.out.printf("THREAD 2: Now im doing something!\n");
                    /*
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    */
                }
            }
        };
        t2.setPriority(1);

        t1.start();
        t2.start();
        long start = System.currentTimeMillis();
        long end;
        do
        {
            end = System.currentTimeMillis();
            if((end-start)>3)
            {
                t1.stop();
                t2.stop();
                t1.interrupt();
                t2.interrupt();
                System.out.println("Terminating STARVATION_DEMO...");
                break;
            }
        }while((end-start)<5);
    }
}
