// 기능개발 - 프로그래머스

#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue<int> A;
    
    // 나머지가 있으면 몫+1 해줘야 함. 아니면 몫 구하기
    for(int i = 0; i < speeds.size(); i++) {
        int j = 100 - progresses[i];
        if(j % speeds[i] == 0) A.push(j / speeds[i]);
        else A.push(j / speeds[i] + 1);
    }
    int value = 0;
    int count = 0;
    // A를 다 뺄때까지
    while (!A.empty()) {
        // value 초기화면 새롭게 시작하는 노드
        if (value == 0) {
            value = A.front();
            A.pop();
            count += 1;
            continue;
        }
        // 포함할 수 있다면 그냥 count++
        if(value >= A.front()) {
            A.pop();
            count += 1;
        }
        // 포함할 수 없다면 answer에 push 후 초기화
        else {
            answer.push_back(count);
            value = 0;
            count = 0;
        }
    }
    answer.push_back(count);
    return answer;
}