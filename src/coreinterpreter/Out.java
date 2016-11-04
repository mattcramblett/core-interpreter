package coreinterpreter;

public class Out {
	//private members
	private IdList il;
	
	//constructor
	public Out(){
		
	}
	
	//public methods
	public void parse(){
		il = new IdList();
		TokenizerSingleton.checkAndSkip(11, "write");
		il.parseOutList();
		TokenizerSingleton.checkAndSkip(12, ";");
	}
	
	public void print(int numSpaces){
		PrintHelp.printSpaces(numSpaces);
		System.out.print("write ");
		il.print();
		System.out.print(";\n");
	}
	
	public void execute(){
		il.writeIdList();
	}
}
