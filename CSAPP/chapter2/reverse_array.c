#include <stdio.h>

void inplace_swap(int *x, int *y){
    *y = *x ^ *y;
    *x = *x ^ *y;
    *y = *x ^ *y;
}

void reverse_array(int a[], int cnt){
    int first, last;
    for(first = 0, last = cnt-1; first < last; first++, last--){
        inplace_swap(&a[first], &a[last]);
    }
}

int main(){
    int x[5];
    int i=0;
    for(i=0; i<5; i++)
        x[i] = i+1;
    reverse_array(x, 5);
    for(i=0; i<5; i++)
        printf("x[%d]=%d\n", i,x[i]);
    return 0;
}

/*
test result:
    x[0]=5
    x[1]=4
    x[2]=3
    x[3]=2
    x[4]=1
*/