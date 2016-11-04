package coreinterpreter;

public class Loop {
	//private members
	private Condition cond;
	private StatementSequence ss;
	
	//constructor
	public Loop(){
		
	}
	
	//public methods
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
	
	public void print(int numSpaces){
		PrintHelp.printSpaces(numSpaces);
		System.out.print("while");
		cond.print();
		System.out.print(" loop\n");
		ss.print(numSpaces + PrintHelp.INDENT);
		PrintHelp.printSpaces(numSpaces);
		System.out.println("end;\n");
	}
	
	public void execute(){
		while(cond.evalCondition()){
			ss.execute();
		}
	}
}
