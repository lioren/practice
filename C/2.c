#include<stdio.h>
main()
{
		int nc,na,nb,nd,ne,nf,ng,nh,ni,nj,c,Chinese;
		nc=0,na=0,nb=0,nd=0,ne=0,nf=0,ng=0,nh=0,ni=0,nj=0,Chinese=0;
		while((c=getchar())!=EOF){
			++nc;
			if((c>='0')&&(c<='9'))
            ++na;
            if((c>='A')&&(c<='Z'))
            ++nb;
            if(c=='\n')
            ++nd;
            if(c>='a'&&c<='z'||c>='A'&&c<='Z')
            ++ne;
            if(c=='a'||c=='A')
            ++nf;
            if(c=='e'||c=='E')
            ++ng;
            if(c=='i'||c=='I')
            ++nh;
            if(c=='o'||c=='O')
            ++ni;
            if(c=='u'||c=='U')
            ++nj;
            if(c>=128){
            ++Chinese;
            getchar();
            nc++;
            }

		}
         
    
        printf("數字:%d\n英文:%d\n中文:%d\n英文大寫:%d\n行數:%d\nByte數:%d\na:\t%f%%\ne:\t%f%%\ni:\t%f%%\no:\t%f%%\nu:\t%f%%\n",na,ne,Chinese,nb,nd,nc,(float)nf*100/ne,(float)ng*100/ne,(float)nh*100/ne,(float)ni*100/ne,(float)nj*100/ne);
}        

