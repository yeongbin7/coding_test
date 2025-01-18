// 예상 대진표 - 프로그래머스

#include <iostream>

using namespace std;

int solution(int n, int a, int b)
{
    int c = n;
    // 2의 몇제곱인지 먼저 확인
    int num = 0;
    while (c > 1) {
        c /= 2;
        num += 1;
    }
    // 이진 탐색으로 나뉜다면 return하도록. 같은 구간이면 num -= 1
    int start, end;
    start = 1;
    end = n;
    while (start <= end) {
        int mid = (start + end) / 2;
        if (a <= mid and b <= mid) {
            end = mid - 1;
            num -= 1;
        }
        else if (a > mid and b > mid) {
            start = mid + 1;
            num -= 1;
        }
        else return num;
    }
}