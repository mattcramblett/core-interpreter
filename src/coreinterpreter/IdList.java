package coreinterpreter;

public class IdList {
	//private members
	private IdList il;
	private Id id;
	
	//constructor
	public IdList(){
		
	}
	
	//public methods
	public void parse(){
		//check that there's an identifier:
		if(TokenizerSingleton.Instance().getToken() != 32){
			System.out.println("Error - Identifier expected. Got token " 
					+ TokenizerSingleton.Instance().getToken());
			System.exit(1);
		}else{
			id = Id.parseNewId(); //parse the new Id (add it to idMap, save instance for printing)
			TokenizerSingleton.Instance().skipToken(); //skip id that was just parsed
		}
		//if there's a comma, create and parse the next idList
		if(TokenizerSingleton.Instance().getToken() == 13){
			TokenizerSingleton.Instance().skipToken(); // skip comma
			il = new IdList();
			il.parse();
		}
	}
	
	public void print(){
		id.print();
		if(il != null){
			System.out.print(", ");
			il.print();
		}
	}
}
