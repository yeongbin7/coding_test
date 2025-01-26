// 피로도 - 프로그래머스

#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;
// 탐색하는 함수 만들기
int search(vector<vector<int>> B, vector <int> A, int K);
int solution(int k, vector<vector<int>> dungeons) {
    vector <int> A;
    int max_value = 0;
    // permuation을위한 배열 만들어주기
    for (int i = 0; i < dungeons.size(); i++) A.push_back(i);
    // permutation 실행
    do {
        int a = k;
        max_value = max(search(dungeons, A, a), max_value);
    } while (next_permutation(A.begin(), A.end()));
    return max_value;
}

int search(vector<vector<int>> B, vector <int> A, int K) {
    int a = 0;
    for (int i : A) {
        if (B[i][0] <= K) {
            K -= B[i][1];
            a++;
        }
        else {
            return a;
        }
    }
    return a;
}