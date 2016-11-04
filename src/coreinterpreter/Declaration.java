package coreinterpreter;

public class Declaration {
	//private members
	private IdList il;
	
	//constructor
	public Declaration(){
		
	}
	
	//public methods
	public void parse(){
		TokenizerSingleton.checkAndSkip(4, "int");
		if(TokenizerSingleton.Instance().getToken() != 32){
			System.out.println("ERROR - invalid identifier name declared.");
			System.exit(1);
		}else{
			il = new IdList();
			il.parseDeclIdList();
			TokenizerSingleton.checkAndSkip(12, ";");
		}
	}
	
	public void print(int numSpaces){
		PrintHelp.printSpaces(numSpaces);
		System.out.print("int ");
		il.print();
		System.out.print(";\n");
	}
}
