package coreinterpreter;
import java.util.HashMap;
import java.util.Map;
/**
 * The Id class reprents a variable in Core
 * @author Matthew Cramblett
 *
 */
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

	}
	
	//public methods:
	/**
	 * Parses an Id that hasn't been declared yet.
	 * @return an instance of the Id object for recursively printing and evaluating.
	 * The value of this returned Id doesn't matter - its name will be used to look up
	 * from {@code IdMap} upon execution.
	 */
	public static Id parseNewId(){
		if(IdMap == null){
			IdMap = new HashMap<String, Id>();
		}
		//get the name of the id and add it to the list of all Ids:
		Id newId = new Id();
		newId.name = TokenizerSingleton.Instance().idName();
		
		//Check to see if Id has already been declared:
		if(IdMap.containsKey(newId.name)){
			System.out.println("ERROR - Identifier \'" + newId.name + "\' declared more than once.");
			System.exit(1);
		}
		
		newId.declared = true;
		IdMap.put(newId.name, newId);
		//return the object so the calling function can print with it
		return newId; 
	}
	
	/**
	 * Parses an Id that is already declared
	 * 
	 * @param isReadStatement set to true if this Id is being initialized or given a value
	 * @return an instance of the Id being parsed
	 */
	public static Id parseExistingId(boolean isInStatement){
		String idName =TokenizerSingleton.Instance().idName();
		if(!IdMap.containsKey(idName)){
			System.out.println("ERROR - identifier " + idName + " does not exist.");
			System.exit(1);
		}else if(!IdMap.get(idName).declared){
			System.out.println("ERROR - identifier " + idName + " undeclared.");
			System.exit(1);
		}else{
			if(isInStatement){
				//must only initialize if the value is being set
				IdMap.get(idName).initialized = true;
			}else if(!IdMap.get(idName).initialized){
					System.out.println("ERROR - Id " + idName + " couldn't be "
							+ "used because it's not initialized.");
					System.exit(1);
			}
		}
		return IdMap.get(idName);
	}
	
	/**
	 * The print for Id is an instance method because only the
	 * name of the Id is needed for printing, so having an
	 * accurate value isn't important.
	 * 
	 * @param idName name of the Id to print
	 */
	public void print(String idName){
		System.out.print(idName);
	}
	
	/**
	 * Sets the value of an existing identifier
	 * @param idName the name of the Id to update - must be declared
	 * @param value the value to give the Id
	 */
	public static void setIdValue(String idName, int value){
		if(!IdMap.get(idName).declared){
			System.out.println("ERROR - identifier " + idName + " undeclared.");
			System.exit(1);
		}else{
			IdMap.get(idName).val = value; 
		}
	}
	
	/**
	 * Get the value of a declared and initialized identifier
	 * @param idName the string name of the identifier
	 * @return the current integer value of the identifier
	 */
	public static int getIdValue(String idName){
		if(!IdMap.get(idName).declared){
			System.out.println("ERROR - identifier " + idName + " undeclared.");
			System.exit(1);
		}else if(!IdMap.get(idName).initialized){
			System.out.println("ERROR - identifier " + idName + " unitialized.");
			System.exit(1);
		}
		return IdMap.get(idName).val;
	}

	
}
