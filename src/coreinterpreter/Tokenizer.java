package coreinterpreter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Tokenizer{
	private ArrayList<String> inputList; //program from file
	private int index; //index of where tokenizer is
	private HashMap<String, Integer> words; //reserved words and their token values
	private HashMap<String, Integer> symbols; //special symbols and their token values
	private ArrayList<Character> specialChars; //special characters to tokenize

	/*
	** TOKENIZER CONSTRUCTOR
	** fileName = name of file to a valid CORE program 
	*/
	public Tokenizer(String fileName) throws IOException {
		//Initialize arrays of keywords and special symbols
		index = 0;
		words = new HashMap<String, Integer>();
		words.put("program", 1); words.put("begin", 2); words.put("end", 3); words.put("int", 4);
		words.put("if", 5); words.put("then", 6); words.put("else", 7); words.put("while", 8);
		words.put("loop", 9); words.put("read", 10);  words.put("write", 11);
		symbols = new HashMap<String, Integer>();
		symbols.put(";", 12); symbols.put(",", 13); symbols.put("=", 14); symbols.put("!", 15); 
		symbols.put("[", 16); symbols.put("]", 17); symbols.put("&&", 18); symbols.put("||", 19);
		symbols.put("(", 20); symbols.put(")", 21); symbols.put("+", 22); symbols.put("-", 23);
		symbols.put("*", 24); symbols.put("!=", 25); symbols.put("==", 26); symbols.put("<", 27); 
		symbols.put(">", 28); symbols.put("<=", 29); symbols.put(">=", 30);
		specialChars = new ArrayList<Character>(Arrays.asList(';', ',', '=', '!', '[', ']', '&', '|', '(',
				')', '+', '-', '*', '!', '=', '<', '>'));
		//Open the file:
		try{		
			String strInput = readFile(fileName);
			ArrayList<String> inputListTemp = new ArrayList<String>(Arrays.asList(strInput.split("\\s+")));
			inputList = splitUp(inputListTemp);
		}catch(IOException ex){
        System.out.println (ex.toString());
        System.out.println("Could not find file " + fileName);
		}
	}

	/*
	** PRIVATE HELPER METHODS:
	**
	*/

	//reads input file to a String and returns it
	private String readFile(String fileName) throws IOException {
    	BufferedReader br = new BufferedReader(new FileReader(fileName));
    	try {
      	  StringBuilder sb = new StringBuilder();
      	  String line = br.readLine();

      	  while (line != null) {
      		  sb.append(line);
     	      sb.append(" "); //blank space after each line
     	      line = br.readLine();
  	      }

  	      return sb.toString();
  	  } finally {
  	      br.close();
  	  }
	}

		//"normalizes" a string of characters that doesn't include whitespace
		//In other words it modifies the string and separates tokens and returns a list
		private ArrayList<String> normalize(String str){
			ArrayList<String> result = new ArrayList<String>();
			int i = 0;
			while(i<str.length()){
				StringBuilder temp = new StringBuilder();
				if(Character.isLowerCase(str.charAt(i))){ //case: reserved word
					while(i<str.length() && Character.isLowerCase(str.charAt(i))){ //append uppercase letters
						temp.append(str.charAt(i));
						i++;
					}
						result.add(temp.toString());
				}else if(Character.isUpperCase(str.charAt(i))){ //case: an ID token
					while(i<str.length() && Character.isUpperCase(str.charAt(i))){ //append uppercase letters
						temp.append(str.charAt(i));
						i++;
					}
					while(i<str.length() && Character.isDigit(str.charAt(i))){
						temp.append(str.charAt(i));
						i++;
					}	
						result.add(temp.toString()); //add ID to resulting list of tokens
				}else if(Character.isDigit(str.charAt(i))){ //Integer token
					while(i<str.length() && Character.isDigit(str.charAt(i))){
						temp.append(str.charAt(i));
						i++; 
					}	
						result.add(temp.toString());
				}else if(specialChars.contains(str.charAt(i))){ //special character token
					boolean possibleTwoChars = false; //flag for symbol having two characters
					if(i<str.length() && specialChars.contains(str.charAt(i))){
						possibleTwoChars = ((str.charAt(i) == '<') || (str.charAt(i) == '>') || (str.charAt(i) == '=') || 
							(str.charAt(i) == '!') || (str.charAt(i) == '&') || (str.charAt(i) == '|')); //flag if this symbol can have two characters
						temp.append(str.charAt(i));
						i++;
					}	
					if(i<str.length() && possibleTwoChars && ((str.charAt(i) == '=') || (str.charAt(i) == '&') || (str.charAt(i) == '|'))){
						temp.append(str.charAt(i)); //special chars of length 2, like <=, >=, ==, !=, &&, ||
						i++;
					}	
						result.add(temp.toString());
				}else{ //Error -invalid token
					System.out.println("ERROR - invalid character " + str.charAt(i));
					System.exit(1);
				}
			}
			return result;		
		}


		/*helper method for getToken, splits up chunks without whitespace
		**input parameter is a list of strings that have been separated just by whitespace
		*/
		
		private ArrayList<String> splitUp(ArrayList<String> list){
			int pos = 0;
			ArrayList<String> result = new ArrayList<String>();
			while(pos < list.size()){
				String current = list.get(pos);
				if(words.containsKey(current) || symbols.containsKey(current)){
					result.add(current);//if it's just a keyword or symbol, add to result and move along
				}else{
					result.addAll(normalize(current)); //add resulting strings that were normalized
				}
				pos++;		
			}
			return result;
		}


	/*
	** PUBLIC TOKENIZER METHODS:
	**
	*/

	//returns (info about) current  token; Repeated calls to getToken() return same  token.
	public int getToken() {
		int result = 0; //0 default value, will trigger error
		if(index >= inputList.size()){
			result = 33;
		}else if(words.containsKey(inputList.get(index))){
			result = words.get(inputList.get(index)); //WORD (1-11)
		} else if(symbols.containsKey(inputList.get(index))){ 
			result = symbols.get(inputList.get(index)); //SYMBOL (12-30)
		} else if(Character.isDigit(inputList.get(index).charAt(0))){ //only integer values start with a digit
			result = 31; //INTEGER (31)
		}else if(Character.isUpperCase(inputList.get(index).charAt(0))){ //only ids should start with cap. letter
			result = 32; //IDENTIFIER (32)
		}
		if(result == 0){
			System.out.println("ERROR - invalid token: " + inputList.get(index));
			System.exit(1);
		}
		return result;
	}

	//skips current token; next token becomes current token; so next call to getToken() will return new token.
	public void skipToken() {
		index++;
	}

	//returns the value of the current (integer) token	(what if current token is not  an integer? -- error!)
	public int intVal() {
		return Integer.parseInt(inputList.get(index));
	}

	//returns the name (string) of the current (id) token.	(what if current token is not an id? -- error!)
	public String idName() {
		return inputList.get(index);
	}

	/*
	public static void main(String[] args){
			try {
				Tokenizer t = new Tokenizer(args[0]); //name of input file is command line arg

				while(t.getToken() != 33){ //print tokens until EOF is reached
					System.out.print(t.getToken()); //print token's corresponding value
					//**Testing some methods:
					if(t.getToken() == 31){
						System.out.print(" INT = " + t.intVal()); //show int value
					}else if(t.getToken() == 32){
						System.out.print(" ID = " + t.idName()); //show id name
					}
					System.out.println();//new line
					t.skipToken(); //skip to next next token
				}
			System.out.println(t.getToken()); //print EOF (33) after all other tokens

			}catch(IOException ex) {
        System.out.println (ex.toString());
        System.out.println("Could not find file " + args[0]);
    	}
	}	
	*/
}
