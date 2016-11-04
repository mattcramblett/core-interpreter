package coreinterpreter;
/**
 * The Factor class is either an operand or an Operand times another Factor.
 * @author Matthew Cramblett
 *
 */
public class Factor {
	//private members
	private Operand op;
	private Factor f;
	
	//constructor
	public Factor(){
		
	}
	
	//public methods
	/**
	 * Parses a Factor object.
	 */
	public void parse(){
		op = new Operand();
		op.parse();
		if(TokenizerSingleton.Instance().getToken() == 24){
			TokenizerSingleton.checkAndSkip(24, "*"); // asterisk
			f = new Factor();
			f.parse();
		}
	}
	
	/**
	 * Prints a Factor object.
	 */
	public void print(){
		op.print();
		if(f != null){
			System.out.print(" * ");
			f.print();
		}
	}

	/**
	 * Evaluates a Factor object.
	 * @return the resulting integer value of the Factor
	 */
	public int evalFactor(){
		int result = 0;
		int operand = op.evalOperand();
		if(f != null){
			result = f.evalFactor() * operand;
		}else{
			result = operand;
		}
		return result;
	}
}
