// 연속 부분 수열 합의 개수 - 프로그래머스

#include <string>
#include <vector>

using namespace std;
static vector <bool> A;

int count(vector<int> elements, int n);
int solution(vector<int> elements) {
    int answer = 0;
    int sum = 0;
    // A 배열 개수 만들기위함.
    for (int i = 0; i < elements.size(); i++) sum += elements[i];
    A.resize(sum+1);
    fill(A.begin(), A.end(), false);
    // 숫자 세기
    for (int i = 1; i < elements.size(); i++) {
        answer += count(elements, i);
    }
    return answer + 1;
}

int count(vector<int> elements, int n) {
    int res = 0;
    // false면 숫자 더하기
    for(int i = 0; i < elements.size(); i++) {
        int num = 0;
        for (int j = 0; j < n; j++) num += elements[(i + j)%elements.size()];
        if (A[num] == false) {
            res += 1;
            A[num] = true;
        }
    }
    return res;
}