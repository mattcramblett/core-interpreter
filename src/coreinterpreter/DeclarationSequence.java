package coreinterpreter;

public class DeclarationSequence {
	//private members
	private Declaration d;
	private DeclarationSequence ds;
	
	//constructor
	public DeclarationSequence(){
		
	}
	
	//public methods
	public void parse(){
		d.parse();
		ds.parse();
	}
	
	public void print(int numSpaces){
		d.print(numSpaces);
		ds.print(numSpaces);
	}
	
	public void execute(){
		d.execute();
		ds.execute();
	}
}
