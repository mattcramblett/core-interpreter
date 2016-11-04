package coreinterpreter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * This is the entry point for the core interpreter.
 * The first command line argument is the CORE program
 * The second command line argument is the input data
 * 
 * @author Matthew Cramblett
 *
 */
public class CoreInterpreterBootstrap {

	/*
	 * File name of CORE Program to be read in
	 */
	public static String fileName; 
	
	/*
	 * File name of CORE data to be read in
	 */
	public static Scanner reader;
	
	public static void main(String[] args) {
		//set up file name for the TokenizerSingleton to initialize with:
		fileName  = args[0];
		//set up file name for the data:
		try {
			reader = new Scanner(new File(args[1]));
			
			//create a new program, then parse, print, and execute:
			Program p = new Program();
			p.parse();
			p.print();
			System.out.println("--PROGRAM OUTPUT:--");
			p.execute();
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR reading data file " + args[1]);
			e.printStackTrace();
		} finally{
			reader.close();
		}
	}

}
