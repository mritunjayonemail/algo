package com.mj.algo.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOperations {
	
	private void createFile(String fileName){
		try {
			FileWriter fileWriter = new FileWriter(new File(fileName));
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("ABCDEF");
			bufferedWriter.write("\n");
			bufferedWriter.write("GHIJKL");
			bufferedWriter.flush();
			bufferedWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void readFile(String fileName){
		try {
			FileReader fileReader = new FileReader(new File(fileName));
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = null;
			while((line = bufferedReader.readLine())!=null){
				System.out.println(line);
			}	
		
			bufferedReader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void reverseFile(String inputFile, String outputFile){
		try {
			PrintWriter printWriter = new PrintWriter(outputFile);
			FileReader fileReader = new FileReader(new File(inputFile));
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = null;
			while((line = bufferedReader.readLine())!=null){
				StringBuffer buffer = new StringBuffer(line);
			    buffer=buffer.reverse();
			    String rs=buffer.toString();
			    printWriter.write(rs);
			    printWriter.write("\n");
			}	
		
			bufferedReader.close();
			printWriter.flush();
			printWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOperations fileOperations = new FileOperations();
		fileOperations.createFile("filereversal.txt");
		fileOperations.readFile("filereversal.txt");
		
		fileOperations.reverseFile("filereversal.txt", "filereversal1.txt");
		fileOperations.readFile("filereversal1.txt");
	}

}
