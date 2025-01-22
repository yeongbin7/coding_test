// 행렬의 곱셈 - 프로그래머스

#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr1, vector<vector<int>> arr2) {
    vector<vector<int>> answer;
    // 총 3행이 나올것을 알고있기에 resize
    answer.resize(arr1.size());
    for (int i = 0; i < arr1.size(); i++) {
        for (int j = 0; j < arr2[0].size(); j++) {
            // 행렬 곱 계산!!
            int num = 0;
            for (int k = 0; k < arr1[0].size(); k++) {
                num += arr1[i][k] * arr2[k][j];
            }
            answer[i].push_back(num);
        }
    }
    return answer;
}