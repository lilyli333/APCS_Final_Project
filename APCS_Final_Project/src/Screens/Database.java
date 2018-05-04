package Screens;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Database {

	public static final  String lineSeparator = System.getProperty ("line.separator");

	public static void writeToDatabase(String outputFilename, String line) 
	{
		FileWriter writer = null;
		BufferedWriter bWriter = null;

		try {
			writer = new FileWriter(outputFilename);
			bWriter = new BufferedWriter(writer);

			bWriter.write(line);
			bWriter.write(lineSeparator);
		}
		catch (IOException e){
			e.printStackTrace();
		}finally {
			try {
				if(bWriter != null)
					bWriter.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}

		}

	}

}
