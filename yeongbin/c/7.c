#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>
#include <math.h>

bool isPowerOfTen(int x) {
    for (int i = 1; i < 10; i++) {
        if (x == pow(10, i)) return true;
    }
    return false;
}

int main() {
    int x, y;
    int iCnt = 0;
    int oCnt = 0;
    int radius = 50;
    double pi;

    for (int i = 1; i <= 100000000; i++) {
        x = rand() % 100;
        y = rand() % 100;
        if ((x - radius) * (x - radius) + (y - radius) * (y - radius) <= radius * radius) iCnt++;
        else oCnt++;
        pi = (double)iCnt / (iCnt+oCnt) * 4;
        if(isPowerOfTen(i)) printf("i=%d, pi = %f\n", i, pi);
    }
    printf("iCnt=%d, oCnt=%d, pi= %f\n", iCnt, oCnt, pi);
}