#include<stdio.h>
#define IN 1
#define OUT 0
main()
{
		int c,nl,nw,nb,nc,value,state,a,b;
		
		
        nl=0,nw=0,nb=0,nc=0,a=0,b=0,value=0,state=0;
        while((c=getchar())!=EOF){

        		if(c=='\n')
        				nl++;
        		if(c==' '||c=='\n'||c=='\t'){
        				state=OUT;}
        		else if(state==OUT){
        		         state=IN;
        				nw++;
				}
				if(state==IN){
						a++;
						}

				if(a>b){
						b=a;}
				              
				if(state==OUT){
						a=0;
				}
								

				if(c>=128){
						nb++;
						getchar();
						a++;
                        
				}
				
				if(c>='0'&&c<='9'){
					value=(c-'0');
                    nc=nc+value;
				}


		}
		      
		printf("1.行數%d \n2.word number%d \n3.中文字個數%d \n4.最長單字長度%d \n5.所有數字加總%d \n",nl,nw,nb,b,nc);
}
