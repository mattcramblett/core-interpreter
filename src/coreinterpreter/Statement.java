package coreinterpreter;

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
	public void parse(){
		//current token to decide which parse to call:
		int token = TokenizerSingleton.Instance().getToken();
		switch(token){
			case 32:
				a = new Assign();
				a.parse();
			case 5:
				i = new If();
				i.parse();
			case 8:
				l = new Loop();
				l.parse();
			case 10:
				in = new In();
				in.parse();
			case 11:
				out = new Out();
				out.parse();
			default:
				System.out.println("ERROR - not a valid statement");
				System.exit(1);
		}
	}
	
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
