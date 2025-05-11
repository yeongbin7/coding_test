#include <stdio.h>
#include <stdbool.h>

int main() {
    int i, a, b, c;
    int day, month, year;
    char s[100];

    int x = scanf("%d %c %d", &a, &i, &b);
    printf("Scanf입력값 = %d \n",x);
    printf("(1) %d %c %d\n", a, i, b);
    c = getchar();
    scanf("%[0-9]", s);
    printf("(2) %s \n", s);
    scanf("%[^\n]", s);
    printf("(3) %s \n", s);
    scanf("%*d%s", &s);
    printf("(4) %s \n", s);
    scanf("%d%*c%d%*c%d", &day, &month, &year);
    printf("(5) %d %d %d\n",year, month, day);
    scanf("%d%*s%d%*s%d%*s", &year, &month, &day);
    printf("(6) %d %d %d\n", year, month, day);
    scanf("%5d%[^\n]", &i,s);
    printf("(7) %d\n", i);
    printf("(7) %s\n", s);
    scanf("%5d%2d", &a, &b);
    printf("(8) %d %d\n", a, b);
    printf("(7) %s\n", s);

}