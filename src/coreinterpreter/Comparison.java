package coreinterpreter;

/**
 * The comparison class compares two operands.
 * 
 * @author Matthew Cramblett
 *
 */
public class Comparison {
	//private members
	private Operand o1;
	private Operand o2;
	/**
	 * operator is not it's own class,
	 * it's just the token number of the operator since
	 * <comp op> is only used in <comp>
	 */
	Integer operator;
	
	//constructor
	public Comparison(){
		
	}
	
	//public methods
	/**
	 * Parses a comparison object.
	 */
	public void parse(){
		TokenizerSingleton.checkAndSkip(20, "("); //always begins with (
		o1 = new Operand();
		o1.parse();
		operator = new Integer(TokenizerSingleton.Instance().getToken());
		//operator error: (no pun intended)
		if(operator < 25 || operator > 30){
			System.out.println("ERROR - illegal operator. Found token " + operator);
		}
		TokenizerSingleton.Instance().skipToken();
		o2 = new Operand();
		o2.parse();
		TokenizerSingleton.checkAndSkip(21, ")"); //always ends with )
	}
	/**
	 * Prints a Comparison object.
	 */
	public void print(){
		System.out.print("(");
		o1.print();
		int op = operator.intValue();
		if(op == 25){
			System.out.print(" != ");
		}else if(op == 26){
			System.out.print(" == ");
		}else if(op == 27){
			System.out.print(" < ");
		}else if(op == 28){
			System.out.print(" > ");
		}else if(op == 29){
			System.out.print(" <= ");
		}else if(op == 30){
			System.out.print(" >= ");
		}else{
			System.out.println("ERROR when printing this operator.");
			System.exit(1);
		}
		o2.print();
		System.out.print(")");
	}
	/**
	 * Evaluates a Comparison object.
	 * @return the resulting value of the condition.
	 */
	public boolean evalComparison(){
		boolean result = false;
		int op = operator.intValue();
		if(op == 25){
			result = o1.evalOperand() != o2.evalOperand();
		}else if(op == 26){
			result = o1.evalOperand() == o2.evalOperand();
		}else if(op == 27){
			result = o1.evalOperand() < o2.evalOperand();
		}else if(op == 28){
			result = o1.evalOperand() > o2.evalOperand();
		}else if(op == 29){
			result = o1.evalOperand() <= o2.evalOperand();
		}else if(op == 30){
			result = o1.evalOperand() >= o2.evalOperand();
		}else{
			System.out.println("ERROR when executing comparison with this operator.");
			System.exit(1);
		}
		return result;
	}
}
