// 전화번호 목록 - 프로그래머스

#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    // 접두사면 sort에서 붙어있음
    sort(phone_book.begin(), phone_book.end());
    for (int i = 0; i < phone_book.size() - 1; i++) {
            if (phone_book[i].size() < phone_book[i+1].size()) {
                // find 함수로 속해있는지 확인
                if (phone_book[i+1].find(phone_book[i]) == 0) return false;
            }
            else {
                if (phone_book[i].find(phone_book[i+1]) == 0) return false;
            }
        }
    return answer;
}