package coreinterpreter;
/**
 * The Statement class represents either an Assign, an If,
 * a Loop, an In, or an Out in Core. 
 * @author Matthew Cramblett
 *
 */
public class Statement {
	//private members
	//assign, if, loop, in, out
	private Assign a;
	private If i;
	private Loop l;
	private In in;
	private Out out;
	
	//constructor
	public Statement(){
		
	}
	
	//public methods
	/**
	 * Parses a Statement object.
	 */
	public void parse(){
		//current token to decide which parse to call:
		int token = TokenizerSingleton.Instance().getToken();
		if(token == 32){
			a = new Assign();
			a.parse();
		}else if(token == 5){
			i = new If();
			i.parse();
		}else if(token == 8){
			l = new Loop();
			l.parse();
		}else if(token == 10){
			in = new In();
			in.parse();
		}else if(token == 11){
			out = new Out();
			out.parse();
		}else{
			System.out.println("ERROR - not a valid statement to parse.");
			System.exit(1);
		}
	}
	
	/**
	 * Returns true if the token is a valid first token in a Statement.
	 * @param token the token to check
	 * @return true iff {@code token} is a possible first token in a Statement
	 */
	public static boolean isStatementToken(int token){
		return token == 32 || token == 5 || token == 8
				|| token == 10 || token == 11;
	}
	
	/**
	 * Prints a Statement object.
	 * @param numSpaces the amount of indent
	 */
	public void print(int numSpaces){
		if(a != null){
			a.print(numSpaces);
		}else if(i != null){
			i.print(numSpaces);
		}else if(l != null){
			l.print(numSpaces);
		}else if(in != null){
			in.print(numSpaces);
		}else if(out != null){
			out.print(numSpaces);
		}else{
			System.out.println("ERROR - Something went wrong when printing this statement");
			System.exit(1);
		}
	}
	
	/**
	 * Executes a Statement object.
	 */
	public void execute(){
		if(a != null){
			a.execute();
		}else if(i != null){
			i.execute();
		}else if(l != null){
			l.execute();
		}else if(in != null){
			in.execute();
		}else if(out != null){
			out.execute();
		}else{
			System.out.println("ERROR - Something went wrong when executing this statement");
			System.exit(1);
		}
	}
}
