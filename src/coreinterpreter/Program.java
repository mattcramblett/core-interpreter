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
 		
 		//checking for int token to parse declaration sequence:
 		if(TokenizerSingleton.Instance().getToken() == 4){
 			ds = new DeclarationSequence();
 	 		ds.parse();
 		}
 		
 		TokenizerSingleton.checkAndSkip(2, "begin");
 		ss = new StatementSequence();
 		ss.parse();
 	}
 	
 	public void print(){
 		System.out.println("program");
 		ds.print(PrintHelp.INDENT);
 		System.out.print("begin\n");
 		ss.print(PrintHelp.INDENT);
 		System.out.print("\nend");
 	}
 	
 	public void execute(){
 		ss.execute();
 	}

}

