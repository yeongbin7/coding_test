// [1차] 캐시 - 프로그래머스

#include <vector>
#include <deque>
#include <algorithm>
using namespace std;

int solution(int cacheSize, vector<string> cities) {
    int answer = 0;
    // 특정 index에서 제거해야되므로 deque를 선언해준다.
    deque <string> q;
    if (cacheSize == 0) return cities.size() * 5;
    // 대소문자 구분을 없애기위해 선언해줌.
    for (int i = 0; i < cities.size(); i++) transform(cities[i].begin(), cities[i].end(), cities[i].begin(), ::tolower);
    
    for(int k = 0; k < cities.size(); k++) {
        // 0일 때는 cache에 아무것도 없으니 메모리 덜 사용
        if (k == 0) {
            q.push_back(cities[k]);
            answer += 5;
            continue;
        }
        // cache에 있는지 없는지 확인할 check 변수
        bool check = false;
        for (int i = 0; i < q.size(); i++) {
            // 있으면 새롭게 업데이트(LRU 알고리즘 적용을위해 오래된 것을 제일 앞으로 보내기)
            if (cities[k] == q[i]) {
                check = true;
                q.erase(q.begin() + i);
                q.push_back(cities[k]);
                break;
            }
        }
        // true면 continue
        if (check) {
            answer += 1;
            continue;
        }
        // false인 경우 cacheSize를 넘지않으면 뒤에 push
        if (q.size() < cacheSize) q.push_back(cities[k]);
        // cacheSize라면 앞의 변수 빼고 뒤에 넣기
        else {
            q.pop_front();
            q.push_back(cities[k]);
        }
        answer += 5;
        
    }
    return answer;
}