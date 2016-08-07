all: main.o Mixed.o
	g++ main.o Mixed.o
main.o:
	g++ -c main.cpp
Mixed.o:
	g++ -c Mixed.cpp Mixed.h
clean:
	rm -f a.out
