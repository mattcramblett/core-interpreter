package coreinterpreter;

/**
 * The Declaration object is a list of Identifiers to be used for the program.
 * @author Matthew Cramblett
 *
 */

public class Declaration {
	//private members
	private IdList il;
	
	//constructor
	public Declaration(){
		
	}
	
	//public methods
	/**
	 * Parses a Declaration.
	 */
	public void parse(){
		TokenizerSingleton.checkAndSkip(4, "int");
		if(TokenizerSingleton.Instance().getToken() != 32){
			System.out.println("ERROR - invalid identifier name declared.");
			System.exit(1);
		}else{
			il = new IdList();
			il.parseDeclIdList();
			TokenizerSingleton.checkAndSkip(12, ";");
		}
	}
	
	/**
	 * Prints a Declaration object.
	 * @param numSpaces amount of indent
	 */
	public void print(int numSpaces){
		PrintHelp.printSpaces(numSpaces);
		System.out.print("int ");
		il.print();
		System.out.print(";\n");
	}
}
