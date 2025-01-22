// 제출 내역 - 프로그래머스

#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    // mapping 시키기위해 두 벡터 만들기
    vector <string> A;
    vector <int> B;
    for(int i = 0; i < clothes.size(); i++) {
        bool check = false;
        // 겹치는지 확인
        for (int j = 0; j < A.size(); j++) {
            if (A[j] == clothes[i][1]) {
                check = true;
                B[j] += 1;
            }
        }
        // 겹치는게 없다면 새롭게 추가
        if(!check) {
            A.push_back(clothes[i][1]);
            B.push_back(1);
        }
    }
    // 여집합으로 값 도출
    for (int i = 0; i < B.size(); i++) answer *= (B[i]+1);
    return answer-1;
}