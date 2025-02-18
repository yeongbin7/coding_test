// 게임 맵 최단거리 - 프로그래머스

#include<vector>
#include<deque>
#include<iostream>
using namespace std;
int dx[4] = {1,-1,0,0};
int dy[4] = {0,0,1,-1};
int bfs(vector<vector<int> > maps, vector<vector<bool>> visited, vector<vector<int>> graph);
int solution(vector<vector<int> > maps)
{
    int answer = 0;
    int h = maps.size();
    int w = maps[0].size();
    vector<vector<bool>> visited(h, vector<bool>(w, false));
    vector<vector<int>> graph(h, vector<int>(w, 0));
    answer = bfs(maps, visited, graph);
    
    return answer;
}

int bfs(vector<vector<int> > maps, vector<vector<bool>> visited, vector<vector<int>> graph) {
    deque <pair <int, int> > A;
    int x = 0;
    int y = 0;
    int h = maps.size();
    int w = maps[0].size();
    visited[x][y] = true;
    graph[x][y] = 1;
    A.push_back(make_pair(x, y));
    while(!A.empty()) {
        pair<int, int> B = A.front();
        x = B.first;
        y = B.second;
        A.pop_front();
        for(int i = 0; i < 4; i++) {
            int x0 = x + dx[i];
            int y0 = y + dy[i];
            if (x0 < 0 or x0 >= h or y0 < 0 or y0 >= w or visited[x0][y0] == true or maps[x0][y0] == 0) continue;
            // 목적지 도착하면 리턴
            if (x0 == (h - 1) and y0 == (w - 1)) return graph[x][y] + 1;
            // 아니면 deque에 추가
            visited[x0][y0] = true;
            A.push_back(make_pair(x0, y0));
            graph[x0][y0] = graph[x][y] + 1;
        }
    }
    return -1;
}