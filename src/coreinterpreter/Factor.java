package coreinterpreter;

public class Factor {
	//private members
	private Operand op;
	private Factor f;
	
	//constructor
	public Factor(){
		
	}
	
	//public methods
	public void parse(){
		op = new Operand();
		op.parse();
		if(TokenizerSingleton.Instance().getToken() == 24){
			TokenizerSingleton.checkAndSkip(24, "*"); // asterisk
			f = new Factor();
			f.parse();
		}
	}
	
	public void print(){
		op.print();
		if(f != null){
			System.out.print(" * ");
			f.print();
		}
	}

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
