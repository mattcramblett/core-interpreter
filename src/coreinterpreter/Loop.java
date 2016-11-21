package coreinterpreter;
/**
 * The Loop class is the representation of a while loop in Core.
 * @author Matthew Cramblett
 *
 */
public class Loop {
	//private members
	private Condition cond;
	private StatementSequence ss;
	
	//constructor
	public Loop(){
		
	}
	
	//public methods
	/**
	 * Parses a Loop object.
	 */
	public void parse(){
		cond = new Condition();
		ss = new StatementSequence();
		TokenizerSingleton.checkAndSkip(8, "while");
		cond.parse();
		TokenizerSingleton.checkAndSkip(9, "loop");
		ss.parse();
		TokenizerSingleton.checkAndSkip(3, "end");
		TokenizerSingleton.checkAndSkip(12, ";");
	}
	
	/**
	 * Prints a Loop object.
	 * @param numSpaces the amount of indent
	 */
	public void print(int numSpaces){
		PrintHelp.printSpaces(numSpaces);
		System.out.print("while ");
		cond.print();
		System.out.print(" loop\n");
		ss.print(numSpaces + PrintHelp.INDENT);
		PrintHelp.printSpaces(numSpaces);
		System.out.println("end;");
	}
	
	/**
	 * Executes a Loop object.
	 */
	public void execute(){
		while(cond.evalCondition()){
			ss.execute();
		}
	}
}
