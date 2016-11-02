package coreinterpreter;

/**
 * Helper class for pretty printing programs
 *
 */
public class PrintHelp {
	
	/**
	 * Length of indentation when printing a CORE program
	 */
	public static final int INDENT = 2;
	
	/**
	 * Prints blank spaces
	 * @param numSpaces the number of blank spaces to print
	 */
	public static void printSpaces(int numSpaces){
		for(int i=0; i<numSpaces; i++){
			System.out.print(" ");
		}
	}
}
