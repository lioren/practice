#include<iostream>
#include<fstream>
using namespace std;
int funtion1(float *);
void funtion2(int , float *);
void funtion3(int ,float *,float*);
float funtion4(int ,float *, float );
fstream fin;
int main()
{
		fstream fin;
		int i,high;
		while(1){
				float array[50];
				float darray[50];
				int comd1,comd2,con=0;
				char line[50];
				char *ptr;
				cout << "1.Choose method to do this program 2.Exit:";
				cin >> comd1;
				if(comd1==1){
						fpurge(stdin);
						cout << "0.Read file 1.Insert by yourself:";
						cin >> comd2;
						if(comd2==1){
								cout << "Please insert highest power and each coefficient:" ;
								fpurge(stdin);
								fgets(line,50,stdin);
								ptr=strtok(line," ");
								high=atoi(ptr);
								while(ptr!=NULL){
										array[con]=atof(ptr);
										ptr=strtok(NULL," ");
										con++;
								}
								if((con-2)!=high){
										printf("Error input\n");
										continue;
								}

						/*		cin >> array[0];
								high=array[0];
								for(i=1;i<=high+1;i++)
										cin >> array[i];*/
								funtion2(high,array);
								funtion3(high,array,darray);

						}
						else if(comd2==0){
								high=funtion1(array);    // from file to array
								if(high==-1){
										continue;
								}
								funtion2(high,array);
								funtion3(high,array,darray);
						}
				}
				else if(comd1==2)
						return 0;
				else {
						cout << "Wrong command ! Please input again!" << endl ;
						continue;
				}
		}
}
int funtion1(float *ary)
{
		static int a=1;
		char *pch;
		int con=0;
		int highest;
		char line[50];
		while(a){
				fin.open("polydata.txt",ios::in);
				a--;}
		fin.getline(line,sizeof(line),'\n');
		if(fin==NULL){
				cout << "End of file" << endl;
				return -1;
		}
		pch=strtok(line," ");
		highest= atoi(pch);
		while(pch!=NULL){
				*ary=atof(pch);
				pch=strtok(NULL," ");
				ary++;
				con++;
		}
		if((con-2)!=highest){
				printf("Error input\n");
				return -1;
		}
		return highest ;
}
void funtion2(int highest , float *ary)
{
		float count=0,now,ans,i;
		float *rp =ary;
		int a=0;
		int first=0;
        if(highest!=0){
		if(*(ary+highest+1)==0){
				cout << "Wrong insert" << endl;
				return;
		}
		}
		while(a<=highest){
				ary++;
				if(*ary==0&&highest==0){
						cout << count << endl;
						for(i=0;i<=1;i=i+0.2)
						cout << "x=" << i << " : " << 0.0 << endl;
						return;
				} 
				if(*ary==0){
						a++;
						count++;
						if(*(ary+1)>0){
								if(first==0)
										continue;
								cout << '+';
						}
						continue;
				}
				cout << *ary  ;
				first++;
				if(count<=highest){
						now=count;
						while(now!=0){
								if(*ary==0)
										break;
								cout << "*x";
								now--;

						}
						if(a<highest){
								if(*(ary+1)>0)
										cout << '+';
								count++;
						}
				}
				a++;
		}
		cout << '\n' ;
		for(i=0;i<=1;i=i+0.2){
				ans=funtion4(highest,rp,i);
				cout << "x=" << i << " : " << ans <<'\n' ;
		}
		cout << endl;
}
void funtion3(int highest,float *ary,float *dary)
{
		int a=1;
		float i;
		int first=0;
		float count=0,now,ans;
		float *rp=dary;
        if(highest!=0){
		if(*(ary+highest+1)==0){
				return;
		}
		}
		ary++;
		if(*ary==0&&highest==0){
				cout << count <<endl;
				for(i=0;i<=1;i=i+0.2){
						cout << "x=" << i << " : " << 0.0 << '\n';
				}
				cout << '\n';
				return;
		}
		*dary=highest-1;
		dary++;
		while(a<=highest){
				ary++;
				if((*ary)==0){
						a++;
						count++;
						*dary=*ary;
						dary++;
						continue;
				}
				*dary=(*ary)*a;
				dary++;
				a++;
		}
		dary=rp;
		count=0;
		a=0;
		while(a<=highest-1){
				dary++;
				if(*dary==0){
						a++;
						count++;
						if(*(dary+1)>0){
								if(first==0)
										continue;
								cout << '+';
						}
						continue;
				}
				cout << *dary  ;
				first++;
				if(count<=highest-1){
						now=count;
						while(now!=0){
								if(*dary==0)
										break;
								cout << "*x";
								now--;
						}
						if(a<highest-1){
								if(*(dary+1)>0)
										cout << '+';
								count++;
						}
				}
				a++;
		}
		cout << '\n' ;
		for(i=0;i<=1;i=i+0.2){
				ans=funtion4(highest,rp,i);
				cout << "x=" << i << " : "<< ans << '\n' ;
		}
		cout << endl;
}
float funtion4(int highest,float *array,float x)
{
		float sum=0;
		float count=*array;
		int i,j=1;
		float buf=1;
		array++;
		sum=*array;
		while(count>0){
				array++;
				for(i=0;i<j;i++){
						buf=buf*x;
				}
				buf=buf*(*array);
				sum=sum+buf;
				j++;
				count--;
				buf=1;
		}
		return sum;
}
