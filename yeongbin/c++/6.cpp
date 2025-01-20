// 영어 끝말잇기 - 프로그래머스

#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    vector<int> answer;
    // 이전의 값들 기록하기
    vector<string> save[26];
    save[words[0][0] - 'a'].push_back(words[0]);
    for(int i = 1; i < words.size(); i++) {
        // 끝말잇기가 되었다면 진행
        if(words[i-1][words[i-1].size()-1] == words[i][0]) {
            for(string word : save[words[i][0] - 'a']) {
                if(word == words[i]) {
                    return {i%n+1, i/n+1};
                }
            }
        }
        // 문자가 맞지 않는다면 리턴
        else {
            return {i%n+1, i/n+1};
        }
        save[words[i][0] - 'a'].push_back(words[i]);
    }
    // 다 통과되었다면 0,0으로 리턴
    return {0,0};
}