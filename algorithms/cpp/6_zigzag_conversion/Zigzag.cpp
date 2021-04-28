class Zigzag {
public:
    string convert(string s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int n = s.size();
        int cycle = numRows * 2 - 2;
        string res;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycle) {
                res += s[i + j];
                if (i != 0 && i != numRows - 1 && j + cycle - i < n) {
                    res += s[j + cycle - i];
                }
            }
        }
        return res;
    }
	
	// for a half of cycle, we add all the same place in the rest of the cycles
	string convert1(string s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		int size = s.size();
		int cycle = numRows * 2 - 2;
		string res;
		for (int i = 0; i <= cycle / 2; i++) {
			int front = i, back = cycle - i;
			while (front < size) {
				res += s[front];
				if (back < s.size() && back != front && back != front + cycle) {
					res += s[back];
				}
				front += cycle;
				back += cycle;
			}
		}
		return res;
	}
};
