package coreinterpreter;

public class In {
	//private members
	private IdList il;
	
	//constructor
	public In(){
		
	}
	
	//public methods
	public void parse(){
		TokenizerSingleton.checkAndSkip(10, "read");
		il = new IdList();
		il.parseInList();
		TokenizerSingleton.checkAndSkip(12, ";");
	}
	
	public void print(int numSpaces){
		PrintHelp.printSpaces(numSpaces);
		System.out.print("read ");
		il.print();
		System.out.print(";\n");
	}
	
	public void execute(){
		il.readIdList();
	}
}
