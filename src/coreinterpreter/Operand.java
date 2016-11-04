package coreinterpreter;
/**
 * The operand class represents either an Integer value, 
 * an Id or an Expression.
 * @author Matthew Cramblett
 *
 */
public class Operand {
	//private members
	private Integer i;
	private Id id;
	private Expression exp;
	
	//constructor
	public Operand(){
		
	}
	
	//public methods
	/**
	 * Parses an Operand object.
	 */
	public void parse(){
		if(TokenizerSingleton.Instance().getToken() == 31){ //integer
			i = new Integer(TokenizerSingleton.Instance().intVal());
			TokenizerSingleton.checkAndSkip(31, "-integer value-");
		}else if(TokenizerSingleton.Instance().getToken() == 32){ //identifier
			id = Id.parseExistingId(false); //false because we're not assigning value to the Id
			TokenizerSingleton.checkAndSkip(32, id.name);
		}else{
			TokenizerSingleton.checkAndSkip(20, "("); //only other case is open parentheses with exp
			exp = new Expression();
			exp.parse();
			TokenizerSingleton.checkAndSkip(21, ")");
		}
	}
	
	/**
	 * Prints an Operand object.
	 */
	public void print(){
		if(i != null){
			System.out.print(i.toString());
		}else if(id != null){
			id.print(id.name);
		}else if(exp != null){
			System.out.print("(");
			exp.print();
			System.out.print(")");
		}
	}
	
	/**
	 * Evaluates an Operand object.
	 * @return the resulting integer value of the Operand
	 */
	public int evalOperand(){
		int result = 0;
		if(i != null){
			result = (int) i;
		}else if(id != null){
			result = Id.getIdValue(id.name);
		}else if(exp != null){
			result = exp.evalExpression();
		}else{
			System.out.println("ERROR when evaluating this operand");
			System.exit(1);
		}
		return result;
	}
}
