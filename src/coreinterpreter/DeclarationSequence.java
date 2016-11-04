package coreinterpreter;
/**
 * The DeclarationSequence class is a recursively defined group of 0 or more Declaration objects.
 * @author Matthew Cramblett
 *
 */
public class DeclarationSequence {
	//private members
	private Declaration d;
	private DeclarationSequence ds;
	
	//constructor
	public DeclarationSequence(){
		
	}
	
	//public methods
	/**
	 * Parses a DeclarationSequence object.
	 */
	public void parse(){
		d = new Declaration();
		d.parse();
		
		//check for int token, then parse another declaration sequence:
		if(TokenizerSingleton.Instance().getToken() == 4){
			ds = new DeclarationSequence();
			ds.parse();
		}
	}
	
	/**
	 * Prints a DeclarationSequence object.
	 * @param numSpaces the amount of indent
	 */
	public void print(int numSpaces){
		d.print(numSpaces + PrintHelp.INDENT);
		if(ds != null){
			ds.print(numSpaces);
		}
	}
}
