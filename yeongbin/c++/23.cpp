// 모음사전 - 프로그래머스

#include <string>
#include <vector>

using namespace std;

// index 찾기
int find_index(char a) {
    switch (a) {
        case 'A':
            return 0;
        case 'E':
            return 1;
        case 'I':
            return 2;
        case 'O':
            return 3;
        case 'U':
            return 4;
    }
}
int solution(string word) {
    int answer = 0, index = 0;
    // 자리가 변경될때마다 해당과같이 변함 (a*5 +1)의 공식을 적용해주면 좋음
    for (int i = 0; i < 5; i++) index = index * 5 + 1;
    for (int i = 0; i < word.size(); i++) {
        int z = find_index(word[i]);
        answer += index * z + 1;
        index = index / 5;
    }
    return answer;
}