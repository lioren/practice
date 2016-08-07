#include<iostream>
using namespace std;
main()
{
		int number;
		int sum;
		int grade;
		int command;
		float average;

		while(1){
				number=0;
				sum=0;
				average=0;
				while(1){
						cout << "1.input number 2. calculate result:";
						cin >> command;
						if(command == 2)
								break;
					    else if(command!=1){
					    		cout << "Wrong command\n";
					    		continue;}
						cout << "Input number:";		
						cin >> grade;
					    if(grade > 100 || grade < 0){
								cout << "Illegal number !! 1.back 2.exit:" ;
								cin >> command;
								if(command == 1)
										continue;
								else if(command == 2)
										return 0;
								else {
										cout << "Are you kidding ? ";
										return 0;}
						}

						else if(grade>=0){
								sum = sum + grade;
								number = number + 1;

						}
				}
				if(number == 0){
						cout << "No data\n";
						return 0;}
				average =(float)sum/number;
				cout << average;
				cout << " \n1.exit 2.calculate new average:";
				cin >> command;
				if(command == 1)
						break;
				else if(command == 2)
						continue;
				else  {
						cout << "Are you kidding ? ";
						return 0;}
		}
		return 0;

}
