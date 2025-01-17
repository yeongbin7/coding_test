// 멀리 뛰기 - 프로그래머스

#include <string>
#include <vector>

using namespace std;
// dp로 풀려고 만들었는데 시간초과가 발생했다. 재귀의 깊이가 너무 깊어서 그런가보다?
long long dp(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    return dp(n-1) + dp(n-2);
}

long long solution(int n) {
    long long A[n];
    A[0] = 1;
    A[1] = 2;
    // 배열로 만들어서 바로 for문에 돌림.
    // 함수에 접근하는거보다 배열에서 바로 처리하는게 더 속도가 빠름.
    for (int i = 2; i < n; i++) {
        A[i] = (A[i-1] + A[i-2])%1234567;
    }
    return A[n-1];
}