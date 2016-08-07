all:
	java -cp antlr-3.5.1-complete.jar org.antlr.Tool myChecker.g
	javac -cp antlr-3.5.1-complete.jar:. myChecker_test.java
	java -cp antlr-3.5.1-complete.jar:. myChecker_test input3.c

