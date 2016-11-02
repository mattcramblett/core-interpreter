package coreinterpreter;
import coreinterpreter.TokenizerSingleton;

public class CoreInterpreterBootstrap {

	/*
	 * File name of CORE Program to be read in
	 */
	public static String fileName; 
	
	/*
	 * File name of CORE data to be read in
	 */
	public static String dataName;
	
	public static void main(String[] args) {
		//set up file name for the TokenizerSingleton to initialize with:
		fileName  = args[0];
		//set up file name for the data:
		dataName = args[1];
		//create a new program, then parse, print, and execute:
		Program p = new Program();
		p.parse();
		p.print();
		p.execute();
	}

}
