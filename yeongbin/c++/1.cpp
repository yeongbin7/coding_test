// 귤고르기 - 프로그래머스

#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

int solution(int k, vector<int> tangerine) {
    int answer = 0;
    // max 값 뽑기.
    sort(tangerine.begin(), tangerine.end());
    int n = tangerine[tangerine.size() - 1];
    vector <int> A(n + 1);
    // 인덱스에 개수 저장
    for (int i = 0; i < tangerine.size(); i++) A[tangerine[i]] += 1;
    // 내림차순으로 정렬
    sort(A.begin(), A.end(), greater<int>());
    int d = 0;
    // 다른 종류 최솟값 구하기
    while (k > 0) {
        if (A[d] != 0) A[d] -= 1;
        else {
            d++;
            continue;
        }
        k -= 1;
    }
    
    return d+1;
}