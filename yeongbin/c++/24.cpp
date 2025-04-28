// 주식가격 - 프로그래머스

#include <string>
#include <vector>
#include <queue>
using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    queue<int> q;
    int price_size = prices.size();
    for (int i = 0; i < price_size; i++) {
        q.push(prices[i]);
    }
    int first = 0;
    while (q.size()) {
        first = q.front();
        q.pop();
        int count = 0;
        for (int i = price_size - q.size(); i < b; i++) {
            if (first > prices[i]) {
                count += 1;
                break;
            }
            count += 1;
        }
        answer.push_back(count);
    }
    return answer;
}