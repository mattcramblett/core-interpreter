package coreinterpreter;

public class Expression {
	//private members
	private Factor f;
	private Expression exp;
	
	/**
	 * 'kind' is the type of expression.
	 * 1 - a factor only
	 * 2 - addition: <fac>-<exp>
	 * 3 - subtraction: <fac>-<exp>
	 */
	private int kind;
	
	//constructor
	public Expression(){
		
	}
	
	//public methods
	public void parse(){
		f = new Factor();
		f.parse();
		this.kind = 1;
		if(TokenizerSingleton.Instance().getToken() == 22){
			TokenizerSingleton.checkAndSkip(22, "+"); //skip addition symbol
			this.kind = 2;
			exp = new Expression();
			exp.parse();
		}else if(TokenizerSingleton.Instance().getToken() == 23){
			TokenizerSingleton.checkAndSkip(23, "-"); //skip subtraction symbol
			this.kind = 3;
			exp = new Expression();
			exp.parse();
		}
	}
	
	public void print(){
		switch(this.kind){
			case 1:
				f.print();
			case 2:
				f.print();
				System.out.print("+");
				exp.print();
			case 3:
				f.print();
				System.out.print("-");
				exp.print();
			default:
				System.out.println("ERROR when printing this expression");
				System.exit(1);
		}
	}
	
	public int evalExpression(){
		int result = 0;
		switch(this.kind){
			case 1:
				result = f.evalFactor();
			case 2:
				result = f.evalFactor() + exp.evalExpression();
			case 3:
				result = f.evalFactor() - exp.evalExpression();
			default:
				System.out.println("ERROR when evaluating this expression");
				System.exit(1);
		}
		return result;
	}
}
