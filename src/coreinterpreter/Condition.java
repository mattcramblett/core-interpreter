package coreinterpreter;

public class Condition {
	//private members
	private Comparison comp;
	/**
	 * compState is true if the comparison is normal,
	 * false if it is negated with !
	 */
	private Boolean compState;
	private Condition c1;
	private Condition c2;
	/**
	 * isAnd is true if the Condition has && between two
	 * nested conditions, otherwise it's false
	 */
	private Boolean isAnd;
	
	//constructor
	public Condition(){
		
	}
	
	//public methods
	public void parse(){
		if(TokenizerSingleton.Instance().getToken() == 20){ //open parentheses means comparison
			comp = new Comparison();
			comp.parse();
		}else if(TokenizerSingleton.Instance().getToken() == 15){ // check for !
			c1 = new Condition();
			compState = new Boolean(false); //an inverted condition
			TokenizerSingleton.checkAndSkip(15, "!");
			c1.parse();
		}else{
			TokenizerSingleton.checkAndSkip(16, "[");
			c1 = new Condition();
			c1.parse();
			if(TokenizerSingleton.Instance().getToken() == 18){ // &&
				isAnd = new Boolean(true);
				TokenizerSingleton.checkAndSkip(18, "&&");
				c2 = new Condition();
				c2.parse();
			}else if(TokenizerSingleton.Instance().getToken() == 19){ // ||
				isAnd = new Boolean(false);
				TokenizerSingleton.checkAndSkip(19, "||");
				c2 = new Condition();
				c2.parse();
			}else{
				System.out.println("ERROR - parsing error on this condition.");
				System.exit(1);
			}
			TokenizerSingleton.checkAndSkip(17, "]");
		}
	}
	
	public void print(){
		if(compState == null && isAnd == null && comp != null){ //means that this <cond> is a lone <comp> 
			comp.print();
		}else if(isAnd == null && compState == false){ //means that this is a negated condition
			System.out.print("!");
			c1.print();
		}else if(isAnd == true){// &&
			System.out.print("[");
			c1.print();
			System.out.print(" && ");
			c2.print();
			System.out.print("]");
		}else if(isAnd == false){ // ||
			System.out.print("[");
			c1.print();
			System.out.println(" || ");
			c2.print();
			System.out.print("]");
		}else{
			System.out.println("ERROR - error printitng this condition.");
			System.exit(1);
		}
	}
	
	public boolean evalCondition(){
		boolean result = false;
		if(compState == null && isAnd == null && comp != null){ //means that this <cond> is a lone <comp> 
			result = comp.evalComparison();
		}else if(isAnd == null && compState == false){ //means that this is a negated condition
			result = !c1.evalCondition();
		}else if(isAnd == true){// &&
			result = c1.evalCondition() && c2.evalCondition();
		}else if(isAnd == false){ // ||
			result = c1.evalCondition() || c2.evalCondition();
		}else{
			System.out.println("ERROR - error printitng this condition.");
			System.exit(1);
		}
		return result;
	}
}
