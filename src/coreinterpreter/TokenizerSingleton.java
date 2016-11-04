package coreinterpreter;
import java.io.IOException;

/*
 * Tokenizer Singleton class to ensure only one instance of the Tokenizer for parsing.
 * NOTE: this class is to be used throughout parsing.
 */
public class TokenizerSingleton {
	//private members
	private static Tokenizer instance;
	
	/**
	 * Private constructor so this class can't be instantiated
	 */
	private TokenizerSingleton(){
		
	}
	
	/**
	 * Provides the instance of the Tokenizer for parsing
	 */
	public static Tokenizer Instance(){
		if(instance == null){
			try {
				instance = new Tokenizer(CoreInterpreterBootstrap.fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	/**
	 * 
	 * Checks that tokenNum is the current token. If it's good, the token is skipped and 
	 * the Tokenizer moves forward. If not, an error message is printed
	 * and the program exits.
	 * 
	 * @param tokenNum the number of the token to check
	 * @param tokenName the token in string form for error message
	 */
	public static void checkAndSkip(int tokenNum, String tokenName){
 		if(TokenizerSingleton.Instance().getToken() != tokenNum){
 			System.out.println("ERROR - Expected token '" + tokenName + "'");
 			System.exit(1);
 		}else{
 			//skip token if there's no error
 			TokenizerSingleton.Instance().skipToken();
 		}
	}
}

