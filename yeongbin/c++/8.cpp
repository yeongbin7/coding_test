// 괄호 회전하기 - 프로그래머스

#include <string>
#include <vector>
#include <iostream>

using namespace std;
// 왼쪽으로 i회 로테이션하는 과정
string rotation(string s, int i);
// 올바른 괄호인지 체크하는 과정
int check(string s);
int solution(string s) {
    int answer = 0;
    for(int i = 0; i < s.size(); i++) {
        string a = rotation(s, i);
        answer += check(a);
    }
    return answer;
}

string rotation(string s, int i) {
    string a;
    for (int j = 0; j < s.size(); j++) { 
        a += s[(j + i)%s.size()];
    }
    return a;
}

int check(string a) {
    int i = 0;
    while (i < a.size()) {
        string b;
        b += a[i];
        b += a[i+1];
        // 올비른 괄호가있으면 없애고 새롭게 string 선언
        if (b =="[]" or b == "()" or b == "{}")
        {
            string c;
            for(int j = 0; j < i; j++) c += a[j];
            for(int j = i+2; j < a.size(); j++) c += a[j];
            a = c;
            i = 0;
        }
        else i += 1;
    }
    if (a.size()) return 0;
    else return 1;
}
