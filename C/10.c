#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define MAX 1000
int swap(char** ,char** );
int main(int argc, char *argv[])
{
		char line[MAX],b,t;
		int c,d=0,i=0,j=0,z,y;
		float e,f;
		if(argc==1||argc==2||argc==3){
				printf("fuck");
				return -1;}
				if(argv[1][0]!='-'){
						printf("fuck\n");}
				else 	if(argv[1][1]!='a'&&argv[1][1]!='m'&&argv[1][1]!='u'&&argv[1][1]!='d'&&argv[1][1]!='s'){
						printf("fuck\n");return 0;}
				if (argv[1][0]=='-'){
				//		if(argv[2][0]!='-'){
								if(argc<=4&&argv[1][1]!='s'){
                                if(strcmp(argv[1],"-a")==0||strcmp(argv[1],"-m")==0||strcmp(argv[1],"-u")==0||strcmp(argv[1],"-d")==0){
                                		 y=strlen(argv[2]);
                                		 for(z=0;z<y;z++){
                                              t=argv[2][z];
                                              if(isdigit(t)==0){
                                              printf("fuck");                                             
                                              return -1;}}
										switch(argv[1][1]){
												case 'a':
														d=(atoi(argv[2]))+(atoi(argv[3]));
														printf("%d",d);
														break;
												case 'm':
														d=0;
														d=(atoi(argv[2]))-(atoi(argv[3]));
														printf("%d",d);
														break;
												case 'u':
														d=0;
														d=(atoi(argv[2]))*(atoi(argv[3]));
														printf("%d",d);
														break;
												case 'd':
														d=0;
														d=(atoi(argv[2]))/(atoi(argv[3]));
														printf("%d",d);
														break;
										}}
										else printf("fuck");
										}
								else if (argc>=4&&strcmp(argv[1],"-s")==0&&argv[2][0]!='-'){
					//					if(strcmp(argv[1],"-s")==0){
										switch(argv[1][1]){
												case 's':
														for(i=2;i<argc;i++){
																for(j=2;j<argc-1;j++){
																		if(strcmp(argv[j],argv[j+1])>0){
																				swap(&argv[j],&argv[j+1]);}}}
														for(i=2;i<argc;i++){
																printf("%s\n",argv[i]);
														}
														break;
												default:
														printf("fuck\n");
														break;}}
														//              else printf("fuck");
				//		}
				                else  if(argv[2][0]=='-'){
								if(argc<=4){
										printf("fuck\n");}
								else if(argv[2][1]!='f'&&argv[2][1]!='n'){
										printf("fuck\n");}
								else if(argv[1][1]=='a'&&argv[2][1]=='f'){
										e=(atoi(argv[3]))+(atoi(argv[4]));
										printf("%f",e);}
								else if(argv[1][1]=='m'&&argv[2][1]=='f'){
										e=0;
										e=(atoi(argv[3]))-(atoi(argv[4]));
										printf("%f",e);}
								else if(argv[1][1]=='u'&&argv[2][1]=='f'){
										e=0;
										e=(atoi(argv[3]))*(atoi(argv[4]));
										printf("%f",e);}
								else if(argv[1][1]=='d'&&argv[2][1]=='f'){
										e=0;
										f=atoi(argv[4]);
										e=(atoi(argv[3]))/(f);
										printf("%f",e);}
								else if(argv[1][1]=='s'&&argv[2][1]=='n'&&argv[3][0]=='-'&&argv[3][1]=='r'){
										i=0;j=0;
										for(i=4;i<argc;i++){
												for(j=4;j<argc-1;j++)
														if(atoi(argv[j])<atoi(argv[j+1])){
																swap(&argv[j],&argv[j+1]);}}
																for(i=4;i<argc;i++){
																		printf("%s\n",argv[i]);}}
								else if(argv[1][1]=='s'&&argv[2][1]=='n'){
										i=0;j=0;
										for(i=3;i<argc;i++){
												for(j=3;j<argc-1;j++)
														if(atoi(argv[j])>atoi(argv[j+1])){
																swap(&argv[j],&argv[j+1]);}}
										for(i=3;i<argc;i++){
												printf("%s\n",argv[i]);
										}}
								else  printf("fuck\n");
						}
				}                                
}
int swap(char ** c,char ** d)
{char *temp;
		temp=*c;
		*c=*d;
		*d=temp;
}
