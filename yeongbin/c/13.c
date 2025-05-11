#include <stdio.h>

int main() {
    char s[10] = {'a', 'b', 'c', 'd', 'e'};
    char t[] = {'a', 'b', 'c', 'd', 'e', '\0'};
    char u[] = {"abcde"};
    char v[] = "안녕하세요";

    printf("s = |%s| size = %lu\n", s, sizeof(s));
    printf("t = |%s| size = %lu\n", t, sizeof(t));
    printf("u = |%s| size = %lu\n", u, sizeof(u));
    printf("v = |%s| size = %lu\n", v, sizeof(v));

}