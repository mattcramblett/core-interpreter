package coreinterpreter;
/**
 * The If class represents an If-Then or If-Then-Else statement in Core.
 * @author Matthew Cramblett
 *
 */
public class If {
	//private members
	private Condition cond;
	private StatementSequence ss1;
	private StatementSequence ss2;
	
	
	//constructor
	public If(){
		
	}
	
	//public methods
	/**
	 * Parses an If object.
	 */
	public void parse(){
		TokenizerSingleton.checkAndSkip(5, "if");
		cond = new Condition();
		cond.parse();
		TokenizerSingleton.checkAndSkip(6, "then");
		ss1 = new StatementSequence();
		ss1.parse();
		if(TokenizerSingleton.Instance().getToken() == 7){ //else
			TokenizerSingleton.checkAndSkip(7, "else");
			ss2 = new StatementSequence();
			ss2.parse();
		}
		TokenizerSingleton.checkAndSkip(3, "end");
		TokenizerSingleton.checkAndSkip(12, ";");
	}
	
	/**
	 * Prints an If object.
	 * @param numSpaces the amount of indent
	 */
	public void print(int numSpaces){
		PrintHelp.printSpaces(numSpaces);
		System.out.print("if");
		cond.print();
		System.out.print(" then\n");
		ss1.print(numSpaces + PrintHelp.INDENT);
		if(ss2 != null){
			PrintHelp.printSpaces(numSpaces);
			System.out.print("else\n");
			ss2.print(numSpaces + PrintHelp.INDENT);
		}
		PrintHelp.printSpaces(numSpaces);
		System.out.print("end;\n");
		
	}
	
	/**
	 * Executes an If object.
	 */
	public void execute(){
		boolean c = cond.evalCondition();
		if(c){
			ss1.execute();
		}else if(ss2 != null){
			ss2.execute();
		}
	}
}
