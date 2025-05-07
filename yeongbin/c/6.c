#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
    double pi = 0;

    for (int i = 1; i <= 1000000000; i += 4) {
        pi += 1.0 / i;
    }
    for (int i = 3; i <= 1000000000; i += 4) {
        pi -= 1.0 / i;
    }

    printf("pi = %.18f\n", 4 * pi);
}