#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define max 1000
int main(int argc , char *argv[])
{
		char s[max], a[max], b[max],c[max],d[max];// s ��}�C  a ��r�� b �����N�r��     
		char *e, *ptr;                            
		int sl, al, bl, el, num;                  // sl ��}�C�`���� al ��r���`���� bl �����N�r���`���� el �s�r���`���� num ���N�Ӽ�
        int i=0,j=0,k=0;                          
        if(argc<3||argc>5){
       		printf("error");
        		return -1 ;}
        		if((argv[0][0]=='.'||(argv[1][0])=='-'||argv[2][0]=='-')&&argc==3){
        				printf("error");
        				return -1;}
        while(fgets(s,max,stdin)!=NULL){          // �qfilex�@��@��Ū�����  Ū��S�F��
       if(argv[1][0]=='-'&&argv[1][1]=='w'&&argv[2][0]!='-'&&argc==4){      // ��argv[2]�Margv[3]����Ƥ��O�@�Ӧr�@�Ӧr�ƻs��a�Mb
        j=strlen(argv[2]);
		for(i=0;i<j;i++){
			a[i]=argv[2][i];}			
		k=strlen(argv[3]);	
		for(i=0;i<k;i++){
			b[i]=argv[3][i];}
		sl = strlen(s)-1 ; 
		s[sl] = '\0'; 
		al = strlen(a) ; 
		bl = strlen(b) ; 
		num = 0;
		ptr = strstr(s, a);  
		while (ptr!=NULL) {                       
				if(((*(ptr-1)>='a'&&*(ptr-1)<='z')||(*(ptr-1)>='0'&&*(ptr-1)<='9'))||(*(ptr+al)>='a'&&*(ptr+al)<='z')||*(ptr+al)>='0'&&(*(ptr+al)<='9')){  //�P�_��r��e��O�_������L��r
						ptr = strstr ( ptr + al , a );}
						else {
     	*ptr = '\0';
				num++;
				ptr = strstr(ptr + al, a);}
		}}
		else if((argv[1][0]=='-'&&argv[1][1]=='i'&&argv[2][0]=='-'&&argv[2][1]=='w'&&argc==5)||(argv[1][0]=='-'&&argv[1][1]=='w'&&argv[2][0]=='-'&&argv[2][1]=='i'&&argc==5) ){
				j=strlen(argv[3]);
		for(i=0;i<j;i++){
				a[i]=argv[3][i];}
				k=strlen(argv[4]);
				for(i=0;i<k;i++){
						b[i]=argv[4][i];}
						sl=strlen(s)-1;
						s[sl]='\0';
						al=strlen(a);
                        bl=strlen(b);
                        num=0;
                        ptr=strcasestr(s,a);
                        while(ptr!=NULL){
                        		if(((*(ptr-1)>='a'&&*(ptr-1)<='z')||*(ptr-1)>='0'&&*(ptr-1)<='9')||(*(ptr+al)>='a'&&*(ptr+al)<='z')||*(ptr+al)>='0'&&(*(ptr+al)<='9')){
                        				ptr=strcasestr(ptr+al,a);}
                        				else{
                        						*ptr='\0';
                        						num++;
                        						ptr=strcasestr(ptr+al,a);}}}
		else if(argv[1][0]=='-'&&argv[1][1]=='i'&&argv[2][0]!='-'&&argc==4){
				j=strlen(argv[2]);
				for(i=0;i<j;i++){
						a[i]=argv[2][i];}
						k=strlen(argv[3]);
						for(i=0;i<k;i++){
								b[i]=argv[3][i];}
								sl=strlen(s)-1;
								s[sl]='\0';
								al=strlen(a);
								bl=strlen(b);
								num=0;
								ptr=strcasestr(s,a);
								while(ptr!=NULL){
										*ptr='\0';
										num++;
										ptr=strcasestr(ptr+al,a);}}
		else if (argc==3&&argv[1][0]!='-') { 
		j=strlen(argv[1]);
		for(i=0;i<j;i++){
				a[i]=argv[1][i];}
				k=strlen(argv[2]);
				for(i=0;i<k;i++){
						b[i]=argv[2][i];}
		sl=strlen(s)-1;
		s[sl]='\0';
		al=strlen(a);
		bl=strlen(b);
		num=0;
		ptr=strstr(s,a);
		while(ptr!=NULL){
				*ptr='\0';
				num++;
				ptr=strstr(ptr+al,a);}
	   }
	    else {
	    		printf("error");return -1;}
		el = sl + num * (bl - al);             //�s�`����=���`����+���N�Ӽ�*��r��t
		e = (char *) malloc(el + 1);
		ptr = s;
		while (num > 0)
		{
	//			printf("L1:%s\n",e);
				strcat(e,ptr);
	//			printf("L2:%s\n",e);
				strcat(e,b);
	//			printf("L3:%s\n",e);
				ptr = ptr + strlen(ptr)+ al ;
				num--;
	//			printf("L4:%s\n",ptr);
		}
		strcat(e, ptr);
		printf("%s\n", e);}
		return(0);                  
}

