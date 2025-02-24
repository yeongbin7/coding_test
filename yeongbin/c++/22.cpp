#include <vector>
#include <string>
#include <iostream>
using namespace std;

int dx[4] = {0,0,1,-1};
int dy[4] = {1,-1,0,0};
int to_idx(char a);
int move(vector<pair <int, int> > &k, char a);
int check(vector<pair <int, int> > &k, int a);
int solution(string dirs) {
    vector <pair <int, int> > k;
    int answer = 0;
    k.push_back(make_pair(0, 0));
    // 0,0에서 다음 점을 찾아가면서 만약 선이 이미 지나쳤다면 0으로 리턴, 처음 지난다면 1로 리턴.
    for (int i = 0; i< dirs.size(); i++) {
        answer += move(k, dirs[i]);
    }
    return answer;
}
int move(vector<pair <int, int> > &k, char a) {
    const auto& l = k.back();
    int x = l.first;
    int y = l.second;
    int r = 1;
    int idx = to_idx(a);
    // 범위를 넘어서면 바로 0으로 리턴
    if (abs(x + dx[idx]) > 5 or abs(y + dy[idx]) > 5) return 0;
    r = check(k, idx);
    k.push_back(make_pair(x + dx[idx], y + dy[idx]));
    return r;
}
int to_idx(char a) {
    // 리턴 char to int(index)
    switch (a) {
        case 'U': 
            return 0;
        case 'D': 
            return 1;
        case 'R': 
            return 2;
        case 'L': 
            return 3;
    }
}

// 이미 지나갔는지 체크하기
int check(vector<pair <int, int> > &k, int a) {
    const auto& l = k.back();
    int x = l.first;
    int y = l.second;
    // 두 연결점을 이전, 이후와 확인하면서 만약 지나쳤다면 0으로 리턴
    for (int i = 0; i < k.size(); i++) {
        if (k[i].first == x and k[i].second == y) {
            if (i == 0) {
                if (k[i+1].first == x + dx[a] and k[i+1].second == y + dy[a]) {
                    return 0;
                }
            }
            else if (i == k.size()-1) {
                if (k[i-1].first == x + dx[a] and k[i-1].second == y + dy[a]) {
                    return 0;
                }                        
            }
            else {
                if (k[i-1].first == x + dx[a] and k[i-1].second == y + dy[a]) {
                    return 0;
                }
                if (k[i+1].first == x + dx[a] and k[i+1].second == y + dy[a]) {
                    return 0;
                }                           
            }
        }
    }
    return 1;
}