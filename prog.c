#include<stdio.h>
int div2(int x){
    if((x%10)%2==0){
        return 1;
    }
    else return 0;
}
int sumdigits(int x){
        int r=0;
    while(x/10!=0){
        r+=(int)x%10;
        x=(int)x/10;
    }
    r+=(int)x%10;
    return r;
}
int sumanddiv3(int x){
    if(sumdigits(x)%3==0){
        return 1;
    }
    else return 0;
}
int last2digitdiv4(int x){
    if((x%100)%4==0)
        return 1;
    else return 0;
}
int div5(int x){
    if((x%10)%5==0){
        return 1;
    }
    else return 0;
}
int div6(int x){
    if(div2(x)==1 && sumanddiv3(x)==1){
        return 1;
    }
    else{
        return 0;
    }
}
int div9(int x){
    if(sumanddiv3(x)==1 && sumdigits(x)%9==0){
        return 1;
    }
    else{
        return 0;
    }
}
int div10(int x){
    if(div2(x)==1 && div5(x)==1){
        return 1;
    }
    else{
        return 0;
    }
}
void test(){
    int x;
    scanf("%d",&x);
    printf("%d\n",div2(x));
    printf("%d\n",sumanddiv3(x));
    printf("%d\n",last2digitdiv4(x));
    printf("%d\n",div5(x) );
    printf("%d\n",div6(x));
    printf("%d\n",div9(x) );
    printf("%d\n",div10(x));
}
int main(){
    test();
    return 0;
}