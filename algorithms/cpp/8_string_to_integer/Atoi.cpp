class Atoi {
public:
	int myAtoi(string s) {
		if (s.size() == 0) 
            return 0;
        int index = 0;
        while (index < s.size() && s[index] == ' ')
            index++;
        if (index == s.size())
            return 0;
        int sign = 1;
        if (s[index] == '-') {
            sign = -1;
            index++;
        } else if (s[index] == '+') {
            index++;
        }
        int res = 0;
        while (index < s.size() && isdigit(s[index])) {
            int digit = s[index] - '0';
            if (res > (INT_MAX - digit) / 10) {
                return sign == -1 ? INT_MIN : INT_MAX;
            }
            res = res * 10 + digit;
            index++;
        }
        return res * sign;
	}
};
