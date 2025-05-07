#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define CARDS 52
#define CLOVER 0
#define HEART 1
#define SPADE 2
#define DIAMOND 3

int main() {
    int check[CARDS] = {0};
    int cards_order[CARDS] = {0};
    int rand_max = 51;
    char suit;

    srand(time(0));
    for (int i = 0; i < CARDS; i++) {
        int x;
        do {
            x = (int) ((double)rand() / (RAND_MAX+1.0) * 52);
        } while(check[x] != 0);
        check[x] = 1;
        cards_order[i] = x;
    }

    printf("cards_order[]: \n");
    for (int i = 0; i < CARDS; i++) printf("%-5d%c", cards_order[i], (i+1) % 13 == 0 ? '\n' : ' ');
    printf("\n");

    printf("cards: \n");
    for (int i = 0; i < CARDS; i++) {
        int denom = cards_order[i] % 13 + 1;
        switch (cards_order[i] / 13)
        {
        case CLOVER:
            suit = 'C';
            break;
        case HEART:
            suit = 'H';
            break;
        case SPADE:
            suit = 'S';
            break;
        case DIAMOND:
            suit = 'D';
            break;
        default:
            break;
        }
        printf("%c %2d %s", suit, denom, (i+1) % 13 == 0 ? "\n" : ", ");
    }
}