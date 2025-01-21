// 할인 행사 - 프로그래머스

#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0;
    int tot_num = 0;
    int A[number.size()];
    // 배열에 복사
    for (int i = 0; i < number.size(); i++) {
        tot_num += number[i];
        A[i] = number[i];
    }
    for (int i = 0; i <= discount.size() - tot_num; i++) {
        int num = 0;
        // discount 적용
        for (int j = 0 ; j < 10; j++) {
            for (int k = 0; k < want.size(); k++) {
                if (discount[i + j] == want[k] and number[k] > 0 ) number[k] -= 1;
            }   
        }
        // 할인 안받은 개수 홧인
        for (int k = 0; k < number.size(); k++) num += number[k];
        if (!num) {
            answer += 1;
        }
        // 다시 배열 복사
        for (int i = 0; i < number.size(); i++) {
            number[i] = A[i];
        }
    }
    return answer;
}