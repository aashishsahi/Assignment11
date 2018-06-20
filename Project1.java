
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Project1 {
	
	File abc = new File("C:\\Users\\hp\\eclipse-workspace\\Assignment11\\src\\abc.txt");
	ArrayList<File> Storage = new ArrayList<>();
	public void input() throws IOException
	{
		FileWriter fout = new FileWriter(abc);
		BufferedWriter bwr = new BufferedWriter(fout);
		String path;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter 1st path: ");
		path = sc.nextLine();
		path = path.replace("/", "\\\\");
		
		
		bwr.write(path);
		bwr.newLine();
		
		System.out.print("Enter 2nd path: ");
		path = sc.nextLine();
		path = path.replace("/", "\\\\");
		
		
		bwr.write(path);
		bwr.newLine();
		
		sc.close();
		bwr.flush();
		bwr.close();
	}
	
	public void Recursive(File dir) throws FileNotFoundException
	{
		File[] files = dir.listFiles();
		if(files==null)
			return;
		for(File check : files)
		{
			if(check.isDirectory())
			{
				Recursive(check);
			}
			else
			{
				Storage.add(check);
			}
		}
		
	}
	public void Call() throws IOException
	{
		FileReader fre = new FileReader(abc);
		BufferedReader bre = new BufferedReader(fre);
		String path = bre.readLine();
		while(path!=null)
		{
			File CurrentDir = new File(path);
			Recursive(CurrentDir);
			path = bre.readLine();
		}
		
		bre.close();
	}
	
	public void Display() throws IOException
	{
		File f = new File("C:\\Users\\hp\\eclipse-workspace\\Assignment11\\src\\Final.csv");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bf = new BufferedWriter(fw);
		for(File files : Storage)
		{
			bf.write("Name:  " + files.getName());
			bf.write(",");
			bf.write("Path:  " + files.getPath());
			bf.newLine();
			System.out.println("File Name: " + files.getName() + "    Path: " + files.getPath());
		}
		System.out.println();
		System.out.println();
		System.out.println("Succesfully written to csv file.");
		bf.close();
	}
	

	public static void main(String[] args) throws IOException {
		
		Project1 p = new Project1();
		p.input();
		p.Call();
		p.Display();

	}

}
