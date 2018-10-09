import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
