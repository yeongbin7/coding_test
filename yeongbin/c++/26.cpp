// 프로그래머스 - 이모티콘 할인행사

#include <string>
#include <vector>
#include <iostream>

using namespace std;
int global_x, global_y = 0;

void generateMultisetPermutations(vector<int>& nums, vector<int>& current, int depth, int r, vector<vector<int>>& users, vector<int>& emoticons, int u_size) {
    if (depth == r) {
        // local x,y 구해주기
        int x = 0, y = 0;
        for (int i = 0; i < u_size; i++) {
            int num = 0;
            for (int j = 0; j < r; j++) {
                if (users[i][0] <= current[j]) {
                    num += emoticons[j] * float((100 - current[j]) * 0.01);
                }
            }
            if (num >= users[i][1]) x += 1;
            else y += num;
        }
        // global_x 중에 제일 큰 값을 원하기에 미리 return하기
        if (global_x > x) return;
        // update하기
        if (global_x < x) {
            global_x = x;
            global_y = y;
        }
        else if (global_x == x) {
            if (global_y < y) global_y = y; 
        }
        return;
    }
    // depth에 도달하지않으면 계속 원소 추가해주기
    for (int i = 0; i < nums.size(); i++) {
        current[depth] = nums[i];
        generateMultisetPermutations(nums, current, depth + 1, r, users, emoticons, u_size);
    }
}

vector<int> solution(vector<vector<int>> users, vector<int> emoticons) {
    // 중복순열
    vector <int> A;
    for (int i = 1; i <= 4; i++) A.push_back(i*10);
    vector <int> current(emoticons.size());
    generateMultisetPermutations(A, current, 0, emoticons.size(), users, emoticons, users.size());
    vector<int> answer;
    answer.push_back(global_x);
    answer.push_back(global_y);
    return answer;
}