all:
	java -cp antlr-3.5.1-complete.jar org.antlr.Tool mylexer.g
	javac -cp ./antlr-3.5.1-complete.jar testLexer.java mylexer.java
	java -cp ./antlr-3.5.1-complete.jar:. testLexer input1.c
