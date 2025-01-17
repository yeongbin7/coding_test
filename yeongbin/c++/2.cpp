// 구명보트 - 프로그래머스

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    int start = 0;
    int end = people.size() - 1;
    // 오름차순 정렬
    sort(people.begin(), people.end());
    int count = 0;
    // 가장 작은 수와 큰 수를 비교하여 count 더하기 (최대 2명 태울 수 있는걸 생각!!!)
    while (start <= end) {
        if(people[start] + people[end] <= limit) {
            start += 1;
            end -= 1;
        }
        else end -= 1;
        count += 1;
    }
    return count;
}