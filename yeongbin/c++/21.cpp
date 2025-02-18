// 롤케이크 자르기 - 프로그래머스

#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

int solution(vector<int> topping) {
    int answer = 0;
    int topping_len = topping.size();
    // 배열 개수가 1개면 바로 리턴
    if (topping_len == 1) return 0;
    vector <int> A(topping_len, 0) , D(topping_len, 0), B , C;
    A[topping[0]] = 1;
    D[topping[topping_len - 1]] = 1;
    // 맨처음은 무조건 1개이므로 추가
    B.push_back(1);
    C.push_back(1);
    for(int i = 1; i < topping_len-1; i++) {
        // 앞에서부터 축적
        if(A[topping[i]] == 1) B.push_back(B[i-1]);
        else {
            A[topping[i]] = 1;
            B.push_back(B[i-1] + 1);
        }
        // 뒤에서부터 축적
        if(D[topping[topping_len - i - 1]] == 1) C.push_back(C[i-1]);
        else {
            D[topping[topping_len - i - 1]] = 1;
            C.push_back(C[i-1] + 1);
        }
    }
    // 같은지 확인
    for(int i = 0; i < B.size(); i++) {
        if (B[i] == C[C.size() - 1 - i]) answer += 1;
    }
    return answer;
}