package coreinterpreter;
/**
 * The IdList class is a recursively defined grouping of one or more Ids.
 * @author Matthew Cramblett
 *
 */
public class IdList {
	//private members
	private Id id;
	private IdList il;

	//constructor
	public IdList(){
		
	}
	
	//public methods
	
	/**
	 * Parses an idList from a declaration statement
	 */
	public void parseDeclIdList(){
		//check that there's an identifier:
		if(TokenizerSingleton.Instance().getToken() != 32){
			System.out.println("Error - Identifier expected. Got token #" 
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
			il.parseDeclIdList();
		}
	}
	
	/**
	 * Parses an idList from a read statement
	 */
	public void parseInList(){
		//check that there's an identifier:
		if(TokenizerSingleton.Instance().getToken() != 32){
			System.out.println("Error - Identifier expected. Got token #" 
					+ TokenizerSingleton.Instance().getToken());
			System.exit(1);
		}else{
			id = Id.parseExistingId(true); //parse the new Id (add it to idMap, save instance for printing)
			TokenizerSingleton.Instance().skipToken(); //skip id that was just parsed
		}
		//if there's a comma, create and parse the next idList
		if(TokenizerSingleton.Instance().getToken() == 13){
			TokenizerSingleton.Instance().skipToken(); // skip comma
			il = new IdList();
			il.parseInList();
		}
	}
	
	/**
	 * This method parses an idList from a write statement.
	 * An idList for an Out needs a separate method because
	 * there it is not a declaration, initialization, or assignment
	 * but the Id object must be given to this instance of IdList
	 */
	public void parseOutList(){
		//check that there's an identifier:
		if(TokenizerSingleton.Instance().getToken() != 32){
			System.out.println("Error - Identifier expected. Got token #" 
					+ TokenizerSingleton.Instance().getToken());
			System.exit(1);
		}else{
			id = Id.parseExistingId(false); //parse the new Id (add it to idMap, save instance for printing)
			TokenizerSingleton.Instance().skipToken(); //skip id that was just parsed
		}
		//if there's a comma, create and parse the next idList
		if(TokenizerSingleton.Instance().getToken() == 13){
			TokenizerSingleton.Instance().skipToken(); // skip comma
			il = new IdList();
			il.parseOutList();
		}
	}
	
	/**
	 * Prints an IdList object.
	 */
	public void print(){
		id.print(id.name);
		if(il != null){
			System.out.print(", ");
			il.print();
		}
	}
	
	/**
	 * Reads in an IdList upon execution from the file scanner
	 * set up by the CoreInterpreterBootstrap class. The Id values 
	 * are updated in {@code IdMap}
	 */
	public void readIdList(){
		if(CoreInterpreterBootstrap.reader.hasNextInt()){
			Id.setIdValue(id.name, CoreInterpreterBootstrap.reader.nextInt());
		}else{
			System.out.println("ERROR reading integer data from file.");
			System.exit(1);
		}
		if(il != null){
			il.readIdList();
		}
	}
	
	/**
	 * Writes an IdList upon execution. The Ids' values are looked up in
	 * {@code IdMap}
	 */
	public void writeIdList(){
		System.out.print(id.name + " = " + Id.getIdValue(id.name) + "\n");
		if(il != null){
			System.out.print(", ");
			il.writeIdList();
		}
	}
}
