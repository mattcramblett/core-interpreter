package coreinterpreter;

/**
 * The Assign class gives an ID a value, given an expression.
 * 
 * @author Matthew Cramblett
 *
 */
public class Assign {
	//private members
	private Id id;
	private Expression exp;
	
	//constructor
	public Assign(){
		
	}
	
	//public methods
	/**
	 * Parses an Assign object.
	 */
	public void parse(){
		//assume next token is an Id because Statement checks for this
		id = Id.parseExistingId(true);
		TokenizerSingleton.Instance().skipToken(); //skip the id that was just parsed
		TokenizerSingleton.checkAndSkip(14, "=");
		exp = new Expression();
		exp.parse();
		TokenizerSingleton.checkAndSkip(12, ";");
	}
	/**
	 * Prints an Assign object.
	 * @param numSpaces amount of indent
	 */
	public void print(int numSpaces){
		PrintHelp.printSpaces(numSpaces);
		System.out.print(id.name + " = ");
		exp.print();
		System.out.print(";\n");
	}
	
	/**
	 * Executes an Assign statement.
	 */
	public void execute(){
		Id.setIdValue(id.name, exp.evalExpression());
	}
	
}
