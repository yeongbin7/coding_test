// 프로세스 - 프로그래머스

#include <string>
#include <vector>
#include <queue>
#include <iostream>
#include <algorithm>
using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    queue <pair<int, int> > A;
    // queue를 선언(index 포함)
    for (int i = 0; i < priorities.size(); i++) A.push(make_pair(priorities[i], i));
    // 최댓값을 계속 출력하기위해 내림차순
    sort(priorities.begin(), priorities.end());
    int a, b;
    while(!A.empty()) {
        a = A.front().first;
        b = A.front().second;
        // 제일 큰 값이면 pop하기
        if (a == priorities[priorities.size() - 1]) {
            priorities.pop_back();
            A.pop();
            answer += 1;
            if (b == location) return answer;
        }
        // 제일 큰 값이 아니라면 pop 후 뒤에 push
        else {
            A.pop();
            A.push(make_pair(a, b));
        }   
    }
}