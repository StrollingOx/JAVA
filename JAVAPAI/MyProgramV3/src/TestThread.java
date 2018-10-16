public class TestThread {

   public static void main(String args[]) 
   {	
	   RunnableDemo R1, R2, R3, R4, R5;
	   long start_time = System.nanoTime();
	   //for(int i=0;i<args.length;i++) 
	   //{
		  // switch(i%5)
		   //{
		   //case 0: 
			   R1 = new RunnableDemo("T1", args[0], start_time); R1.start();
			   //break;
		   //case 1: 
			   R2 = new RunnableDemo("T2", args[1], start_time); R2.start();
			  //break;
		   //case 2: 
			   R3 = new RunnableDemo("T3", args[2], start_time); R3.start();
			   //break;
		   //case 3: 
			   R4 = new RunnableDemo("T4", args[3], start_time); R4.start();
			   //break;
		   //case 4: 
			   R5 = new RunnableDemo("T5", args[4], start_time); R5.start();
			   //break;
		   //}
	   //}
			   
	   //long end_time = System.nanoTime();
	   //double timeElapsed = (end_time - start_time) / 1e6;
	   //System.out.printf("Amount of time needed: %.3f nanoseconds\n", timeElapsed);
   }   
}