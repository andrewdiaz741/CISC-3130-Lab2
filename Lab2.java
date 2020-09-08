import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import  java.io.PrintWriter;

public class Lab_1 
{
	static double [][] myCSVArray;
	
	public static void main(String[] args) throws IOException
	{
		setUpMyCSVArray();
		printMyCSVArray();
		outputMyCSVArray();
	
	}
	
	static void setUpMyCSVArray()
	{
		
		myCSVArray = new double [200][5];
		
		Scanner scanIn = null;
		int Row = 0;
		int Col = 0;
		String InputLine = "";
		String CSVFile;
		
		CSVFile = "C:\\Users\\Andrew Diaz\\Desktop\\Spotify_CSVFile.txt";
		
		try
		{
			@SuppressWarnings("resource")
			BufferedReader bufferedreader = new BufferedReader(new FileReader(CSVFile));
			
			while((InputLine = bufferedreader.readLine()) != null) 
			{
				System.out.println(InputLine);
			}

			 // Row = Integer.parseInt(InputLine);

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
				for (Col = 0; Col < InArray.length; Col++)
				{
					myCSVArray [Row][Col] = Double.parseDouble(InArray[Col]);
				}
				//Increment the row in the array
				Row++;
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
	
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}

	}

	static void printMyCSVArray()
	{
		
		//print the array
		for (int Row = 0; Row < 201; Row++)
		{
			
			for (int Col = 0; Col < 5; Col++)
			{
				System.out.print(myCSVArray[Row][Col] + " ");
			}
		}
		System.out.println();
	
	}

	static void outputMyCSVArray() throws IOException
	{
		File output = new File("Output.txt");
		FileWriter fileWriter = new FileWriter(output);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		
		printWriter.print(myCSVArray);
		
		printWriter.close();
		
	}

}

