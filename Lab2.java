import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Lab_1 
{
	static double [][] myArray;

	static void setUpMyCSVArray()
	{
		
		
		myArray = new double [201][5];
		
		Scanner scanIn = null;
		int Rowc = 0;
		int Colc = 0;
		String InputLine = "";
		String CSVFile;
		
		CSVFile = "C:\\Users\\Andrew Diaz\\Desktop\\Spotify_CSVFile.txt";
		
		
		try
		{
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(CSVFile));
			
			while((InputLine = br.readLine()) != null) 
			{
				System.out.println(InputLine);
			}

			
			//setup a scanner
			scanIn = new Scanner(new BufferedReader(new FileReader(CSVFile)));
			
			//while ((InputLine = scanIn.nextLine()) != null)
			while (scanIn.hasNextLine())
			{
				//Read line in from file
				InputLine = scanIn.nextLine();
				
				//split the Imputline into an array at the commas
				String [] InArray = InputLine.split(",");
				
				//copy the content of the inArray to the myArray
				for (Colc = 0; Colc < InArray.length; Colc++)
				{
					myArray [Rowc][Colc] = Double.parseDouble(InArray[Colc]);
				}
				//Increment the row in the array
				Rowc++;
			}
			
			
		}
	
		
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}


	
	
	public static void main(String[] args)
	{
		
		
		

	
	}
}
