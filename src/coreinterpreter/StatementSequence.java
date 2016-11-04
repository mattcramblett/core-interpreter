package coreinterpreter;
/**
 * The StatementSequence class is a recursviely defined chain of Statement objects.
 * @author Matthew Cramblett
 *
 */
public class StatementSequence {
	//private members
	private Statement s;
	private StatementSequence ss;
	
	//constructor
	public StatementSequence(){
		
	}
	
	//public methods
	/**
	 * Parses a StatementSequence object.
	 */
	public void parse(){
		s = new Statement();
		s.parse();
		if(TokenizerSingleton.Instance().getToken() != 33
				&& TokenizerSingleton.Instance().getToken() != 3){
			ss = new StatementSequence();
			ss.parse();
		}
	}
	
	/**
	 * Prints a StatementSequence object.
	 * @param numSpaces the amount of indent
	 */
	public void print(int numSpaces){
		s.print(numSpaces + PrintHelp.INDENT);
		if(ss != null){
			ss.print(numSpaces);
		}
	}

	/**
	 * Executes a StatementSequence object.
	 */
	public void execute(){
		s.execute();
		if(ss != null){
			ss.execute();
		}
	}
}
