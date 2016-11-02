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
		il = new IdList();
		il.parse();
		TokenizerSingleton.checkAndSkip(12, ";");
	}
	
	public void print(int numSpaces){
		PrintHelp.printSpaces(numSpaces);
		System.out.print("int ");
		il.print();
		System.out.print(";\n");
	}
}
