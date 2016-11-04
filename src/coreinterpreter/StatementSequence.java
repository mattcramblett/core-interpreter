package coreinterpreter;

public class StatementSequence {
	//private members
	private Statement s;
	private StatementSequence ss;
	
	//constructor
	public StatementSequence(){
		
	}
	
	//public methods
	public void parse(){
		s = new Statement();
		s.parse();
		if(TokenizerSingleton.Instance().getToken() != 33
				&& TokenizerSingleton.Instance().getToken() != 3){
			ss = new StatementSequence();
			ss.parse();
		}
	}
	
	public void print(int numSpaces){
		s.print(numSpaces + PrintHelp.INDENT);
		if(ss != null){
			ss.print(numSpaces);
		}
	}

	public void execute(){
		s.execute();
		if(ss != null){
			ss.execute();
		}
	}
}
