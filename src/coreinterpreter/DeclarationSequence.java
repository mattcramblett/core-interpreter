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
		d = new Declaration();
		d.parse();
		
		//check for int token, then parse another declaration sequence:
		if(TokenizerSingleton.Instance().getToken() == 4){
			ds = new DeclarationSequence();
			ds.parse();
		}
	}
	
	public void print(int numSpaces){
		d.print(numSpaces + PrintHelp.INDENT);
		if(ds != null){
			ds.print(numSpaces);
		}
	}
}
