import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class RunnableDemo implements Runnable {
   private Thread t;
   private String threadName;
   private String fileName;
   private long start_time;
   
   public RunnableDemo(String name, String fileName, long start_time) {
      threadName = name;
      this.fileName = fileName;
      this.start_time = start_time;
      System.out.println("Creating " +  threadName );
   }
   
   public void run() {
      System.out.println("Running " +  threadName + " on file " + fileName  );
      System.out.printf("The file %s contains %d rows.\n", fileName, countRows(fileName));
      System.out.println("Thread " +  threadName + " exiting.");
      long end_time = System.nanoTime();
	  double timeElapsed = (end_time - start_time) / 1e6;
	  System.out.printf(threadName + " Finished. Time: %.3f nanoseconds\n", timeElapsed);
      
   }
   
   public void start () 
   {
      System.out.println("Starting " +  threadName );
      if (t == null)
      {
         t = new Thread (this, threadName);
         System.out.println("*beep* " +  threadName );
         t.start ();
      }
   }
   
   public static int countRows(String fileName)
	{
       FileReader fileReader = null;
       BufferedReader bufferedReader = null;
       StringBuffer stringBuffer = null;
       int counter=0;
       try 
       {
	            fileReader = new FileReader(fileName);
	            bufferedReader = new BufferedReader(fileReader);
	            stringBuffer = new StringBuffer();
	            String line;
	            while ((line = bufferedReader.readLine()) != null) 
	            {
	            	stringBuffer.append(line);
	            	stringBuffer.append("\n");
	            	counter++;
	            }
       	fileReader.close();
       } catch (IOException e)
       {
       	e.printStackTrace();
       }
       
       return counter;
	    
	}
}

/*
for(int i = 4; i > 0; i--) 
System.out.println("Thread: " + threadName + ", " + i);
// Let the thread sleep for a while.
Thread.sleep(50);
*/