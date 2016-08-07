all:
	java -jar ./antlr-3.5.1-complete.jar myCompiler.g
	javac -cp ./antlr-3.5.1-complete.jar myCompilerLexer.java myCompilerParser.java  myCompiler_test.java register.java
	java -cp ./antlr-3.5.1-complete.jar:. myCompiler_test input1.c > input1.s
	gcc input1.s 
	-./a.out >> result.txt
	java -cp ./antlr-3.5.1-complete.jar:. myCompiler_test input2.c > input2.s
	gcc input2.s
	-./a.out >> result.txt
	java -cp ./antlr-3.5.1-complete.jar:. myCompiler_test input3.c > input3.s
	gcc input3.s
	-./a.out >> result.txt
	java -cp ./antlr-3.5.1-complete.jar:. myCompiler_test input4.c > input4.s
	gcc input4.s
	-./a.out >> result.txt
	java -cp ./antlr-3.5.1-complete.jar:. myCompiler_test input5.c > input5.s
	gcc input5.s
	-./a.out >> result.txt
