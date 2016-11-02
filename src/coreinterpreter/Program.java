package coreinterpreter;

public class Program {
    //private members
	private DeclarationSequence ds;
 	private StatementSequence ss;

    //constructor
 	public Program(){
 		
 	}
 	
    //public methods
 	public void parse(){
 		TokenizerSingleton.checkAndSkip(1, "program");
 		ds = new DeclarationSequence();
 		ds.parse();
 		TokenizerSingleton.checkAndSkip(2, "begin");
 		ss = new StatementSequence();
 		ss.parse();
 	}
 	
 	public void print(){
 		System.out.println("program");
 		ds.print(PrintHelp.INDENT);
 		System.out.println("begin");
 		ss.print(PrintHelp.INDENT);
 		System.out.println("end");
 	}
 	
 	public void execute(){
 		ds.execute();
 		ss.execute();
 	}

}

