package coreinterpreter;

public class Declaration {
	//private members
	//private idList il;
	
	//constructor
	public Declaration(){
		
	}
	
	//public methods
	public void parse(){
		//TODO check first to see if the id list is actually there, and if it is, parse it.
		TokenizerSingleton.checkAndSkip(4, "int");
	}
	
	public void print(int numSpaces){
		
	}
	
	public void execute(){
		
	}
}
