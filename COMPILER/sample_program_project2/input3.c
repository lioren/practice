main()  
{  
		int a=0;
		int b=0;
		int c=0;
		int n;    
		while(a<n){  

				while(b<a)
				{  
						if(a+b==0)
						{  
								c=c+b;  
								b++;}  
						else{   int i=0;
								b++;
						}
				}  

				b=1;    
				if(a==1){  
						printf("a");
				}
				if(c==a){ 
						printf("c");
				}
				c=0;  
				a++;     
		} 
		if(a==1){ break;}
		else if(b==2){ 
				if(c==3){
						continue;
				}
		}
		return 0;  
}  
