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
		s.parse();
		ss.parse();
	}
	
	public void print(int numSpaces){
		s.print(numSpaces);
		ss.print(numSpaces);
	}

	public void execute(){
		s.execute();
		ss.execute();
	}
}
