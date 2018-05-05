package Screens;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author lilili
 *
 */
public class Database {

	public static final  String lineSeparator = System.getProperty ("line.separator");

	public static String name; 
	public static double GPA;
	public static int SAT;

	public static void writeToDatabase(String[] userLines) 
	{
		FileWriter writer = null;
		BufferedWriter bWriter = null;

		try {
			writer = new FileWriter("Database.txt");
			bWriter = new BufferedWriter(writer);
			for(String line : userLines) {
				bWriter.write(line);
				bWriter.write(lineSeparator);
			}
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
		getDatabase();

	}

	private static void getDatabase() {
		Scanner scan = null;
		String line;
		ArrayList<String> str = new ArrayList<String>();
;

		try {
			FileReader reader = new FileReader("Database.txt");
			BufferedReader bReader = new BufferedReader(reader);
			scan = new Scanner(bReader);

			while(scan.hasNextLine()) {
				line = new String(scan.nextLine());

				str.add(line);
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		finally {
			if(scan != null)
				scan.close();
		}
		
		name = str.get(0);
		GPA = Double.parseDouble(str.get(1));
		SAT = Integer.parseInt(str.get(2));
		
		System.out.println("name is " + name);
		System.out.println("GPA is " + GPA);
		System.out.println("SAT is " + SAT);

	} 

}
