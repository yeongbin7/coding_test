// 서버 증설 횟수 - 프로그래머스

#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(vector<int> players, int m, int k) {
    int answer = 0;
    queue<int> q;
    int data, q_size, remain;
    for (int i = 0; i < players.size(); i++) {
        q_size = q.size();
        remain = players[i] / m - q_size;
        if (remain > 0) {
            answer += players[i]/m - q_size;
            for(int j = 0; j < remain; j++) {
                q.push(0);
            }
            q_size += remain;
        }
        for (int v = 0; v < q_size; v++) {
            data = q.front();
            q.pop();
            data += 1;
            if (data == k) continue;
            q.push(data);
        }
    }
    return answer;
}