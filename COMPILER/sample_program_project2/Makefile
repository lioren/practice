all:
	java -cp antlr-3.5.1-complete.jar org.antlr.Tool myC.g
	javac -cp antlr-3.5.1-complete.jar:. myC_test.java
	java -cp antlr-3.5.1-complete.jar:. myC_test input4.c

