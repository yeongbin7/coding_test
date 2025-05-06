#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
    int a[10];
    int min, max;
    int sum = 0;

    for (int i =0; i < 10; i++) {
        printf("%d 번째 숫자를 입력하시오: ", i+1);
        scanf("%d", &a[i]);
    }
    for (int i = 0; i < 10; i++) {
        sum += a[i];
    }
    min = max = a[0];

    for (int i = 1; i < 10; i++) {
        if (min > a[i]) min = a[i];
        if (max < a[i]) max = a[i]; 
    }

    printf("min = %d, max = %d, average = %.2f \n", min, max, sum / 10.0);
}