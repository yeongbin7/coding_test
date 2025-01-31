// [1차] 뉴스 클러스터링 - 프로그래머스

#include <string>
#include <ctype.h>
#include <cctype>
#include <algorithm>
#include <iostream>
#include <deque>

using namespace std;

int solution(string str1, string str2) {
    // 소문자로 만들어주기
    transform(str1.begin(), str1.end(), str1.begin(), ::tolower);
    transform(str2.begin(), str2.end(), str2.begin(), ::tolower);
    deque <string> A, B;
    // 문자로만 이루어졌다면 deque에 추가
    for (int i = 0; i < str1.size() - 1; i++) {
        if (isalpha(str1[i]) == 0 or isalpha(str1[i+1]) == 0) continue;
        string a;
        a += str1[i];
        a += str1[i+1];
        A.push_back(a);
    }
    for (int i = 0; i < str2.size() - 1; i++) {
        if (isalpha(str2[i]) == 0 or isalpha(str2[i+1]) == 0) continue;
        string a;
        a += str2[i];
        a += str2[i+1];
        B.push_back(a);
    }
    // t 전체 크기
    int t = A.size() + B.size();
    int num = 0;
    if (t == 0) return 65536;
    // check 가 false가 아니면 겹치는게 없으므로 탈출
    bool check = false;
    while (!check) {
        check = true;
        // 겹치는거 있는지 조사하고 있으면 erase
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < B.size(); j++) {
                if (A[i] == B[j]) {
                    A.erase(A.begin() + i);
                    B.erase(B.begin() + j);
                    num++;
                    check = false;
                    break;
                }
            }
            if (!check) break;
        }
        
    }
    // 계산
    float result = float(num)/float(t-num);
    return result * 65536;
}