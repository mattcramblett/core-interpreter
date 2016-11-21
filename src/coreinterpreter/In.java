package coreinterpreter;
/**
 * An In object represents a Read statement in Core.
 * @author Matthew Cramblett
 *
 */
public class In {
	//private members
	private IdList il;
	
	//constructor
	public In(){
		
	}
	
	//public methods
	/**
	 * Parses an In object.
	 */
	public void parse(){
		TokenizerSingleton.checkAndSkip(10, "read");
		il = new IdList();
		il.parseInList();
		TokenizerSingleton.checkAndSkip(12, ";");
	}
	
	/**
	 * Prints an In object.
	 * @param numSpaces the amount of indent
	 */
	public void print(int numSpaces){
		PrintHelp.printSpaces(numSpaces);
		System.out.print("read ");
		il.print();
		System.out.print(";\n");
	}
	
	/**
	 * Executes an In object.
	 */
	public void execute(){
		il.readIdList();
	}
}
