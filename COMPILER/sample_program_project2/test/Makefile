all:
	java -cp antlr-3.5.1-complete.jar org.antlr.Tool myparser.g
	javac -cp antlr-3.5.1-complete.jar:. testParser.java
	java -cp antlr-3.5.1-complete.jar:. testParser input3.c

