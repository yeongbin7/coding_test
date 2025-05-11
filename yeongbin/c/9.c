#include <stdio.h>

int main() {
    for (int i = 1; i <= 5; i++) {
        for (int j = 1; j <= i; j++) printf("*");
        printf("\n");
    }
    printf("\n");
    
    for(int i = 1; i <= 5; i++) {
        for (int j = 1; j <= i * 2 - 1;j++) printf("*");
        printf("\n");
    }
    printf("\n");
    
    for (int i = 1; i <= 5; i++) {
        for (int j = 5-i+1;j--;) printf("*");
       printf("\n");
    }
    printf("\n");

    for (int i = 1; i <= 5 ; i++) {
        for (int j = 1; j <= 5-i;j++) printf(" ");
        for (int j = 1; j <= i; j++) printf("*");
        printf("\n");
    }
    printf("\n");

    for (int i = 1; i <= 5; i++) {
        for (int j = 1; j <= 5-i; j++) printf(" ");
        for (int j = 1; j <= 2*i-1; j++) printf("*");
        printf("\n");
    }
    printf("\n");

    for (int i = 1;i <= 5;i++) {
        for (int j = 1; j <= i-1; j++) printf(" ");
        for (int j = 1; j <= 2*(5-i) + 1; j++) printf("*");
        printf("\n");
    }
}