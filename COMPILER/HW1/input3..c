#include <stdio.h>  
#include <stdlib.h>   
#include <string.h>  

int main(void)  
{  
		char a[100];  
		int i,j=0,m,n,l,aa=0,bb=0,cc=0,dd=0,ee=0,ff=0,gg=0,hh=0,ii=0,jj=0;  
		fgets(a,40,stdin);  
		char *ptr;  
		l=strlen(a);  
		a[l]='\0';  
		ptr=a;  
		while(*ptr!='\0'){  
				if(*ptr=='1'){ (++aa) ; ptr++;}  
				else if(*ptr=='0'){ (++jj);ptr++;}  
				else if(*ptr=='2'){  (++bb) ; ptr++;}  
				else if(*ptr=='3') { (++cc) ; ptr++;}  
				else if(*ptr=='4')  {(++dd) ; ptr++;}  
				else if(*ptr=='5') { (++ee) ; ptr++;}  
				else if(*ptr=='6') { (++ff) ; ptr++;}   
				else if(*ptr=='7') { (++gg) ; ptr++;}  
				else if(*ptr=='8') { (++hh) ; ptr++;}  
				else if(*ptr=='9') { (++ii) ; ptr++;}  
				else ptr++;  
		}  
		if(aa>bb&&aa>cc&&aa>dd&&aa>ee&&aa>ff&&aa>gg&&aa>hh&&aa>ii&&aa>jj&&aa>=l/4)  
				printf("Majority is 1\n");  
		else  if(jj>aa&&jj>bb&&jj>cc&&jj>dd&&jj>ee&&jj>ff&&jj>gg&&jj>hh&&jj>ii&&jj>=l/4)  
				printf("Majority is 0\n");  
		else  if(bb>aa&&bb>cc&&bb>dd&&bb>ee&&bb>ff&&bb>gg&&bb>hh&&bb>ii&&bb>jj&&bb>=l/4)  
				printf("Majority is 2\n");  
		else  if(cc>bb&&cc>aa&&cc>dd&&cc>ee&&cc>ff&&cc>gg&&cc>hh&&cc>ii&&cc>jj&&cc>=l/4)  
				printf("Majority is 3\n");  
		else  if(dd>bb&&dd>cc&&dd>aa&&dd>ee&&dd>ff&&dd>gg&&dd>hh&&dd>ii&&dd>jj&&dd>=l/4)  
				printf("Majority is 4\n");  
		else  if(ee>bb&&ee>cc&&ee>dd&&ee>aa&&ee>ff&&ee>gg&&ee>hh&&ee>ii&&ee>jj&&ee>=l/4)  
				printf("Majority is 5\n");  
		else  if(ff>bb&&ff>cc&&ff>dd&&ff>ee&&ff>aa&&ff>gg&&ff>hh&&ff>ii&&ff>jj&&ff>=l/4)  
				printf("Majority is 6\n");  
		else  if(gg>bb&&gg>cc&&gg>dd&&gg>ee&&gg>ff&&gg>aa&&gg>hh&&gg>ii&&gg>jj&&gg>=l/4)  
				printf("Majority is 7\n");  
		else  if(hh>bb&&hh>cc&&hh>dd&&hh>ee&&hh>ff&&hh>gg&&hh>aa&&hh>ii&&hh>jj&&hh>=l/4)  
				printf("Majority is 8\n");  
		else  if(ii>bb&&ii>cc&&ii>dd&&ii>ee&&ii>ff&&ii>gg&&ii>hh&&ii>aa&&ii>jj&&ii>=l/4)  
				printf("Majority is 9\n");  
		else printf("No Majority\n");  

		return 0;  
} 
