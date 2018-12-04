public class Livelock 
{
    static final Object1 object1 = new Object1();
    static final Object2 object2 = new Object2();
    
 
    public static void main(String[] args) 
    {
    	long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
 
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
    		   System.out.println("TIMEOUT");
    		   System.exit(1);
    	   }
       }while((endTime-startTime)<50000);
    }
 
}
