/*************************************************************************
g++ -std=c++11 test.cpp
 ************************************************************************/
#include <vector> 
#include<iostream>
using namespace std;
int max(int cap, vector<int> &array) {
	vector<int> m(array.size());
	m[0] = array[0] <= cap ? array[0] : 0;
	int res = 0;
	for (int i = 1; i <= m.size(); i++) {
		//m[i] = array[i] <= cap ? array[0] : 0;
		for (int j = 0; j < i; j++) {
			if (array[i] + array[j] <= cap) {
				m[i] = max(m[i], array[i] + array[j]);
			}
			if (array[i] + m[j] <= cap) {
				m[i] = max(m[i], array[i] + m[j]);
			}
		}
		res = max(res, m[i]);
	}
	return res;
}

int main() {
	vector<int> test{5, 12, 7, 18};
	cout << max(26, test);
	return 0;
}
