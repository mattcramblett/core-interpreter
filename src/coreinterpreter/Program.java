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
 		
 		//check for EOF, just in case the program is empty:
 		if(TokenizerSingleton.Instance().getToken() != 33 
 				&& TokenizerSingleton.Instance().getToken() != 3){
 			ss = new StatementSequence();
 	 		ss.parse();
 		}
 		
 		//token 'end'
 		TokenizerSingleton.checkAndSkip(3, "end");
 	}
 	
 	public void print(){
 		System.out.println("program");
 		if(ds != null){
 			ds.print(0);
 		}
 		System.out.print("begin\n");
 		if(ss != null){
 			ss.print(0);
 		}
 		System.out.print("\nend");
 	}
 	
 	public void execute(){
 		if(ss != null){
 			ss.execute();
 		}
 	}

}

