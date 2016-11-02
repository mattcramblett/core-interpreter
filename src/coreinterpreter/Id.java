package coreinterpreter;
import java.util.Map;

public class Id {
	//private members:
	/**
	 * Map of all Ids. The name of the Id is the key and the value is the Id object.
	 */
	private static Map<String, Id> IdMap;
	
	//public members:
	public String name;
	public int val;
	public boolean declared = false;
	public boolean initialized = false;

	//private constructor
	private Id(){
		declared = true;
	}
	
	//public methods:
	public static Id parseNewId(){
		//get the name of the id and add it to the list of all Ids:
		Id newId = new Id();
		newId.name = TokenizerSingleton.Instance().idName();
		IdMap.put(newId.name, newId);
		//return the object so the calling function can print with it
		return newId; 
	}
	
	public void parseExistingId(int idVal){
		//TODO:
		//Check if idMap has this Id -throw error if not
		//check that the Id is declared - throw error if not
		//set value.val to idVal and value.initialized to true

	}
	
	public void print(){
		System.out.println();
	}
	
}
