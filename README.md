#Core Interpreter#
####Implementation of a language called CORE####

###FILES:###
	>src
		>coreinterpreter
			**Assign.java**-The Assign class, corresponds to the <assign> production in the BNF for Core.
			**Comparison.java**-The Comparison class, corresponds to the <comp> production in the BNF for Core.
			**Condition.java**-The Condition class, corresponds to the <cond> production in the BNF for Core.
			**CoreInterpreterBootstrap.java**-The entry point for this project - execute from here. Sets up a few other things.
			**Declaration.java**-The Declaration class, corresponds to the <decl> production in the BNF for Core.
			**DeclarationSequence.java**-The DeclarationSequence class, corresponds to the <decl seq> production in the BNF for Core.
			**Expression.java**-The Expression class, corresponds to the <exp> production in the BNF for Core.
			**Factor.java**-The Factor class, corresponds to the <fac> production in the BNF for Core.
			**Id.java**-The Id class, corresponds to the <id> production in the BNF for Core.
			**IdList.java**-The IdList class, corresponds to the <id list> production in the BNF for Core.
			**If.java**-The If class, corresponds to the <if> production in the BNF for Core.
			**In.java**-The In class, corresponds to the <in> production in the BNF for Core.
			**Loop.java**-The Loop class, corresponds to the <loop> production in the BNF for Core.
			**Operand.java**-The Operand class, corresponds to the <op> production in the BNF for Core.
			**Out.java**-The Out class, corresponds to the <out> production in the BNF for Core.
			**PrintHelp.java**-Provides a few methods for formatted printing.
			**Program.java**-The Program class, corresponds to the <prog> production in the BNF for Core.
			**Statement.java**-The Statement class, corresponds to the <stmt> production in the BNF for Core.
			**StatementSequence.java**-The StatementSequence class, corresponds to the <stmt seq> production in the BNF for Core.
			**Tokenizer.java**-The Tokenizer class, responsible for separating Core code into tokens for parsing.
			**TokenizerSingleton.java**
				-This class is used for parsing to ensure only one instance of the Tokenizer is returned.
			
		>test
			>testData
				-This folder contains various test data files.
				NOTE: Corresponds to the test program with the same number.
			>testPrograms
				-This folder contains various test programs.
				NOTE: Corresponding data files are numbered with the same number.
			
		Documentation.txt
			-A description of the overall design of the interpreter
			-A brief user manual that explains how to use the interpreter
			-A brief description of testing
		
		README.txt
			-This file, outlining execution instructions and file information.
			
			
###COMPILATION / EXECUTION###
	-This program was written in Eclipse using JavaSE 1.8. 
		Compile and run it using the same.
		Follow Eclipse importing instructions here if needed:
			http://agile.csc.ncsu.edu/SEMaterials/tutorials/import_export/
	-Requires two command line arguments: the name of the file of the Core program
		then the name of the data file for that program. Command line arguments are
		set with: run>run configurations>arguments> click apply.
	-The entry point for the program is the file 'CoreInterpreterBootstrap.java'
		execute from here please.	