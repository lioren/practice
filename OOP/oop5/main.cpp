#include<iostream>
#include"Mixed.h"
using namespace std;
int main()
{
		Mixed x(1,1,1);
		Mixed y(1,1,1);
		char buf[10];
		cout << "You enter first number x: " ;
		cin >> x;
		cout << "You enter second number y: ";
		cin >> y;
		cout << "You entered:\n";
		cout << "x=" << x ;
		cout << "y=" << y ;
        while(1){
        		int num;
        		cout <<"1.Evaluate 2.Simplify 3.ToFraction 4.Comparison 5.Arithmetic 6.Increment and Decrement 7.Exit:" ;
        		cin >> num ;
        		if(num==1){
        				cout << "Decimal equivalent of x is:" << x.Evaluate() << endl; 
        				cout << "Decimal equivalent of y is:" << y.Evaluate() << endl; 
				}
				else if(num==2){
						x.Simplify();
						y.Simplify();
						cout << "x simlified = " << x ;
						cout << "y simlified = " << y ;
				}
				else if(num==3){
						x.ToFraction();
						y.ToFraction();
						cout << "x simplified = " << x;
						cout << "y simplified = " << y;
				}
				else if(num==4){
						while(1){
							cout << "1.Insert two object to compare 2.Exit:";
							int num2;
							cin >> num2;
							if(num2==1){
									x.ToFraction();
									y.ToFraction();
									cin.ignore(256,'\n');
									char buf2[20]={'\0'};
									int a=0,b=0,c=0;
									char a1[5]={'\0'},b1[5]={'\0'},c1[10]={'\0'};
									cin.getline(buf2,20);
									if(sscanf(buf2,"%s%s%d%s",a1,b1,&a,c1)==4){
											char *ptr=c1;
											bool ans;
											while((*ptr)!='/')
													ptr++;
													*ptr=' ';
													sscanf(c1,"%d%d",&b,&c);
													Mixed tmp(a,b,c);
											if(strcmp(a1,"x")==0){
													if(strcmp(b1,"<")==0)
															ans =(x<tmp);
													else if(strcmp(b1,">")==0)
															ans =(x>tmp);
													else if(strcmp(b1,"<=")==0)
															ans =(x<=tmp);
													else if(strcmp(b1,">=")==0)
															ans =(x>=tmp);
													else if(strcmp(b1,"==")==0)
															ans =(x==tmp);
													else if(strcmp(b1,"!=")==0)
															ans =(x!=tmp);
											}
											else if(strcmp(a1,"y")==0){
													if(strcmp(b1,"<")==0)
															ans =(y<tmp);
													else if(strcmp(b1,">")==0)
															ans =(y>tmp);
													else if(strcmp(b1,"<=")==0)
															ans =(y<=tmp);
													else if(strcmp(b1,">=")==0)
															ans =(y>=tmp);
													else if(strcmp(b1,"==")==0)
															ans =(y==tmp);
													else if(strcmp(b1,"!=")==0)
															ans =(y!=tmp);
											}
											if(ans==true)
													cout << "Yes" << endl;
											else    cout << "No" << endl;
									}
									else if(sscanf(buf2,"%s%s%s",a1,b1,c1)==3){
											bool ans;
											if(isdigit(c1[0])||isdigit(c1[1])){
													Mixed tmp(atoi(c1));
												if(strcmp(a1,"x")==0){
														if(strcmp(b1,"<")==0)
																ans =(x<tmp);
														else if(strcmp(b1,">")==0)
																ans =(x>tmp);
														else if(strcmp(b1,"<=")==0)
																ans =(x<=tmp);
														else if(strcmp(b1,">=")==0)
																ans =(x>=tmp);
														else if(strcmp(b1,"==")==0)
																ans =(x==tmp);
														else if(strcmp(b1,"!=")==0)
																ans =(x!=tmp);
												}
												else if(strcmp(a1,"y")==0){
														if(strcmp(b1,"<")==0)
																ans =(y<tmp);
														else if(strcmp(b1,">")==0)
																ans =(y>tmp);
														else if(strcmp(b1,"<=")==0)
																ans =(y<=tmp);
														else if(strcmp(b1,">=")==0)
																ans =(y>=tmp);
														else if(strcmp(b1,"==")==0)
																ans =(y==tmp);
														else if(strcmp(b1,"!=")==0)
																ans =(y!=tmp);
												}
											}
											else {
													if(strcmp(a1,"x")==0){
														if(strcmp(b1,"<")==0)
																ans =(x<y);
														else if(strcmp(b1,">")==0)
																ans =(x>y);
														else if(strcmp(b1,"<=")==0)
																ans =(x<=y);
														else if(strcmp(b1,">=")==0)
																ans =(x>=y);
														else if(strcmp(b1,"==")==0)
																ans =(x==y);
														else if(strcmp(b1,"!=")==0)
																ans =(x!=y);
													}
													else if(strcmp(a1,"y")==0){
														if(strcmp(b1,"<")==0)
																ans =(y<x);
														else if(strcmp(b1,">")==0)
																ans =(y>x);
														else if(strcmp(b1,"<=")==0)
																ans =(y<=x);
														else if(strcmp(b1,">=")==0)
																ans =(y>=x);
														else if(strcmp(b1,"==")==0)
																ans =(y==x);
														else if(strcmp(b1,"!=")==0)
																ans =(y!=x);
													}
													
											}
											if(ans==true)
													cout << "Yes" << endl;
											else    cout << "No" << endl;
									}
									else continue;
							}
							else if(num2==2)
									break;
							else  continue;

						}
				}
				else if(num==5){
						while(1){
							cout << "1.Insert two object to do arithmetic  2.Exit:";
							int num2;
							cin >> num2;
							if(num2==1){
									x.ToFraction();
									y.ToFraction();
									cin.ignore(256,'\n');
									char buf2[20]={'\0'};
									int a=0,b=0,c=0;
									char a1[5]={'\0'},b1[5]={'\0'},c1[10]={'\0'};
									cin.getline(buf2,20);
									if(sscanf(buf2,"%s%s%d%s",a1,b1,&a,c1)==4){
											char *ptr=c1;
											while((*ptr)!='/')
													ptr++;
													*ptr=' ';
													sscanf(c1,"%d%d",&b,&c);
													Mixed tmp(a,b,c);
											if(strcmp(a1,"x")==0){
													if(strcmp(b1,"+")==0){
															Mixed ans = x+tmp;
															cout << ans;
													}
													else if(strcmp(b1,"-")==0){
															Mixed ans = x-tmp;
															cout << ans;
													}
													else if(strcmp(b1,"*")==0){
															Mixed ans = x*tmp;
															cout << ans;
													}
													else if(strcmp(b1,"/")==0){
															Mixed ans = x/tmp;
															cout << ans;
													}
											}
											else if(strcmp(a1,"y")==0){
													if(strcmp(b1,"+")==0){
															Mixed ans = y+tmp;
															cout << ans;
													}
													else if(strcmp(b1,"-")==0){
															Mixed ans = y-tmp;
															cout << ans;
													}
													else if(strcmp(b1,"*")==0){
															Mixed ans = y*tmp;
															cout << ans;
													}
													else if(strcmp(b1,"/")==0){
															Mixed ans = y/tmp;
															cout << ans;
													}
											}
									}
									else if(sscanf(buf2,"%s%s%s",a1,b1,c1)==3){
											if(isdigit(c1[0])||isdigit(c1[1])){
													Mixed tmp(atoi(c1));
												if(strcmp(a1,"x")==0){
													if(strcmp(b1,"+")==0){
															Mixed ans = x+tmp;
															cout << ans;
													}
													else if(strcmp(b1,"-")==0){
															Mixed ans = x-tmp;
															cout << ans;
													}
													else if(strcmp(b1,"*")==0){
															Mixed ans = x*tmp;
															cout << ans;
													}
													else if(strcmp(b1,"/")==0){
															Mixed ans = x/tmp;
															cout << ans;
													}
												}
												else if(strcmp(a1,"y")==0){
													if(strcmp(b1,"+")==0){
															Mixed ans = y+tmp;
															cout << ans;
													}
													else if(strcmp(b1,"-")==0){
															Mixed ans = y-tmp;
															cout << ans;
													}
													else if(strcmp(b1,"*")==0){
															Mixed ans = y*tmp;
															cout << ans;
													}
													else if(strcmp(b1,"/")==0){
															Mixed ans = y/tmp;
															cout << ans;
													}
												}
											}
											else {
													if(strcmp(a1,"x")==0){
														if(strcmp(b1,"+")==0){
																Mixed ans = x+y;
																cout << ans;
														}
														else if(strcmp(b1,"-")==0){
																Mixed ans = x-y;
																cout << ans;
														}
														else if(strcmp(b1,"*")==0){
																Mixed ans = x*y;
																cout << ans;
														}
														else if(strcmp(b1,"/")==0){
																Mixed ans = x/y;
																cout << ans;
														}
													}
													else if(strcmp(a1,"y")==0){
														if(strcmp(b1,"+")==0){
																Mixed ans = y+x;
																cout << ans;
														}
														else if(strcmp(b1,"-")==0){
																Mixed ans = y-x;
																cout << ans;
														}
														else if(strcmp(b1,"*")==0){
																Mixed ans = y*x;
																cout << ans;
														}
														else if(strcmp(b1,"/")==0){
																Mixed ans = y/x;
																cout << ans;
														}
													}
													
											}
									}
							}
							else if(num2==2){
									break;
							}
						}
				}
				else if(num==6){
						while(1){
							cout << "1.Insert two object to do arithmetic  2.Exit:";
							int num2;
							cin >> num2;
							if(num2==1){
									cin.ignore(256,'\n');
									char buf2[10]={'\0'};
									cin.getline(buf2,20);
									if(strcmp(buf2,"++x")==0){
											cout << "++x:" << ++x;
											cout << "x is now:" << x;
									}
									else if(strcmp(buf2,"--x")==0){
											cout << "--x:" << --x;
											cout << "x is now:" << x;
									}
									else if(strcmp(buf2,"++y")==0){
											cout << "++y:" << ++y;
											cout << "y is now:" << y;
									}
									else if(strcmp(buf2,"--y")==0){
											cout << "--y:" << --y;
											cout << "y is now:" << y;
									}
									if(strcmp(buf2,"x++")==0){
											cout << "x++:" << x++;
											cout << "x is now:" << x;
									}
									if(strcmp(buf2,"x--")==0){
											cout << "x--:" << x--;
											cout << "x is now:" << x;
									}
									if(strcmp(buf2,"y++")==0){
											cout << "y++:" << y++;
											cout << "y is now:" << y;
									}
									if(strcmp(buf2,"y--")==0){
											cout << "y--:" << y--;
											cout << "y is now:" << y;
									}
							}
							else if(num2==2){
									break;
							}
						}

				}
				else if(num==7){
						break;
				}
		}
}
