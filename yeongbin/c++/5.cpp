// 점프와 순간 이동 - 프로그래머스

#include <iostream>
#include <algorithm>
using namespace std;

int solution(int n)
{
    int ans = 0;
    while (n > 1) {
        if (n % 2 == 1) {
            n -= 1;
            ans += 1;
        }
        n /= 2;
    }
    return ans+1;
}