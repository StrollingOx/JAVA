import java.util.Scanner;

public class RowRowRow 
{
	public static void main (String[] args)
	{
		int rowsAmount;
		long start_time = System.nanoTime();
		for(String arg: args)
		{
            rowsAmount = countRows(arg);
            System.out.printf("The file %s contains %d rows.\n", arg, rowsAmount);
        }
		long end_time = System.nanoTime();
		double timeElapsed = (end_time - start_time) / 1e6;
		System.out.printf("Amount of time needed: %.3f nanoseconds\n", timeElapsed);
	}
	
	public static int countRows(String fileName)
	{
        Scanner file = null;
        int counter = 0;
        try 
        {
	            file = new Scanner(fileName);
	            while (file.hasNextLine()) 
	            {
	            	file.nextLine();
	            	counter++;
	            	
	            }
        } 
        finally 
        {
        	//if (file != null)
        		file.close();
        }
        return counter;
	    
	}
}
