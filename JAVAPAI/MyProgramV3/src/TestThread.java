public class TestThread {

   public static void main(String args[]) 
   {	
	   RunnableDemo R1, R2;/*, R3;*/
	   for(int i=0;i<args.length;i++) {
		   switch(i%2)
		   {
		   case 0: 
			   R1 = new RunnableDemo("T1", args[i]); R1.start();
			   break;
		   case 1: 
			   R2 = new RunnableDemo("T2", args[i]); R2.start();
			   break;
		   /*case 2: 
			   R3 = new RunnableDemo("T3", args[i]); R3.start();
			   break;*/
	   }
	   }
   }   
}