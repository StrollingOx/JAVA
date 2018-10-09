import java.util.Scanner;

public class RowRowRow 
{
	public static void main (String[] args)
	{
		int rowsAmount;
		for(String arg: args)
		{
            rowsAmount = countRows(arg);
            System.out.printf("The file %s contains %d rows.\n", arg, rowsAmount);
        }
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
 	