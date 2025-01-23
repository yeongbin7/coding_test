// H-Index - 프로그래머스

#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    // 오름차순 정렬
    sort(citations.begin(), citations.end());
    for (int i = 0; i < citations.size(); i++) {
    // 같거나 커진다면 return;
        if (citations[i] >= citations.size() - i) return citations.size() - i;
    }
    return answer;
}