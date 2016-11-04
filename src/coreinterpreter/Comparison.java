package coreinterpreter;

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
	public void parse(){
		TokenizerSingleton.checkAndSkip(20, "("); //always begins with (
		o1 = new Operand();
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
	
	public void print(){
		System.out.print("(");
		o1.print();
		switch(operator.intValue()){
			case 25:
				System.out.print(" != ");
			case 26:
				System.out.print(" == ");
			case 27:
				System.out.print(" < ");
			case 28:
				System.out.print(" > ");
			case 29:
				System.out.print(" <= ");
			case 30:
				System.out.print(" >= ");
		}
		o2.print();
		System.out.print(")");
	}
	
	public boolean evalComparison(){
		boolean result = false;
		switch(operator.intValue()){
		case 25:
			result = o1.evalOperand() != o2.evalOperand();
		case 26:
			result = o1.evalOperand() == o2.evalOperand();
		case 27:
			result = o1.evalOperand() < o2.evalOperand();
		case 28:
			result = o1.evalOperand() > o2.evalOperand();
		case 29:
			result = o1.evalOperand() <= o2.evalOperand();
		case 30:
			result = o1.evalOperand() >= o2.evalOperand();
		}
		return result;
	}
}
