package coreinterpreter;
/**
 * The Out class represents a Write object in Core.
 * @author Matthew Cramblett
 *
 */
public class Out {
	//private members
	private IdList il;
	
	//constructor
	public Out(){
		
	}
	
	//public methods
	/**
	 * Parses an Out object.
	 */
	public void parse(){
		il = new IdList();
		TokenizerSingleton.checkAndSkip(11, "write");
		il.parseOutList();
		TokenizerSingleton.checkAndSkip(12, ";");
	}
	
	/**
	 * prints an Out object.
	 * @param numSpaces the amount of indent
	 */
	public void print(int numSpaces){
		PrintHelp.printSpaces(numSpaces);
		System.out.print("write ");
		il.print();
		System.out.print(";\n");
	}
	
	/**
	 * Executes an Out object.
	 */
	public void execute(){
		il.writeIdList();
	}
}
