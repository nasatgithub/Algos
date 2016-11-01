package code.nasir.generalpractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileOperations {
public static void main(String args[]) throws Exception{
	
	FileOperations fo=new FileOperations();
	String file="fileTest";
	fo.readFile(file);
	fo.writeFile(file);
	fo.readFile(file);
	
	
}
public void readFile (String filename) throws Exception{
	FileReader fr=new FileReader(filename);
	BufferedReader b=new BufferedReader(fr);
	String line;
	while((line=b.readLine())!=null)
		System.out.println(line);
	b.close();
	fr.close();
}
public void writeFile (String filename) throws Exception{
	FileWriter fw=new FileWriter(filename, true);
	BufferedWriter bw=new BufferedWriter(fw);
	bw.write("\nSuper");
	bw.close();
	fw.close();
}
}
