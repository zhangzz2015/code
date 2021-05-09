class ValidParentheses {
public:
	bool isValid(string s) {
        stack<char> current_stack;
        for (char& c : s) {
            switch (c) {
                case '(':
                case '{':
                case '[': current_stack.push(c); break;
                case ')': if (current_stack.empty() || current_stack.top() != '(') return false; else current_stack.pop(); break;
                case '}': if (current_stack.empty() || current_stack.top() != '{') return false; else current_stack.pop(); break;
                case ']': if (current_stack.empty() || current_stack.top() != '[') return false; else current_stack.pop(); break;
            }
        }
        return current_stack.empty();
    }
};
