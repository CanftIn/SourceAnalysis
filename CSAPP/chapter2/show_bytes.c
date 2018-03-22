#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef unsigned char *byte_pointer;

void show_bytes(byte_pointer start, int len){
    int i;
    for (i = 0; i < len; i++)
        printf(" %.2x", start[i]);
    printf("\n");
}

void show_int(int x){
    printf("\tprint int:");
    show_bytes((byte_pointer) &x, sizeof(int));
}

void show_float(float x){
    printf("\tprint float:");
    show_bytes((byte_pointer) &x, sizeof(float));
}

void show_pointer(void *x){
    printf("\tprint pointer:");
    show_bytes((byte_pointer) &x, sizeof(void *));
}

void test_show_bytes(int val){
    int ival = val;
    float fval = (float)ival;
    int *pval = &val;
    show_int(ival);
    show_float(fval);
    show_pointer(pval);
}


int main(){
    printf("print 12345:\n");
    test_show_bytes(12345);
    printf("\tprint 12345 in ASCII:");
    show_bytes("12345", 6);

    printf("练习题2.5:\n");
    int val = 0x87654321;
    byte_pointer valp = (byte_pointer)&val;
    show_bytes(valp, 1);
    show_bytes(valp, 2);
    show_bytes(valp, 3);
    
    printf("练习题2.7:\n");
    const char *s = "abcdef";
    printf("print string:");
    show_bytes((byte_pointer)s, strlen(s));
    return 0;
}

/*
test result:

    print 12345:
        print int: 39 30 00 00
        print float: 00 e4 40 46
        print pointer: 90 fe 61 00
        print 12345 in ASCII: 31 32 33 34 35 00
    练习题2.5:
        21
        21 43
        21 43 65
    练习题2.7:
        print string: 61 62 63 64 65 66
*/