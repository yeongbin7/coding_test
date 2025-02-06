// 타겟 넘버 - 프로그래머스

#include <string>
#include <vector>

using namespace std;
static int answer = 0;
// 깊이우선탐색(DFS 함수선언)
void DFS(vector<int> numbers, int num, int total, int target);
int solution(vector<int> numbers, int target) {
    DFS(numbers, 0, 0, target);
    return answer;
}
void DFS(vector<int> numbers, int num, int total, int target) {
    // numbers size만큼 나왔다면 return
    if (num == numbers.size()) {
        if (total == target) answer += 1;
        return;
    }
    // 더하기, 뺄셈 나눠서 진행
    DFS(numbers, num + 1, total + numbers[num], target);
    DFS(numbers, num + 1, total - numbers[num], target);
}