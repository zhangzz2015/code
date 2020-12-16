class SubtractString {
	public String subtract1(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return null;
        int sign1 = num1.charAt(0) == '-' ? -1 : 1;
        int sign2 = num2.charAt(0) == '-' ? -1 : 1;
        num1 = num1.replace("-", "");
        num2 = num2.replace("-", "");
        if (sign1 == 1 && sign2 == 1) {
            if (isSmaller(num1, num2)) {
                StringBuilder tmp = new StringBuilder(findDiff(num1, num2));
                tmp.insert(0, "-");
                return tmp.toString();
            } else {
                return findDiff(num1, num2);
            }
        } else if (sign1 == -1 && sign2 == 1) {
            StringBuilder tmp = new StringBuilder(findSum(num1, num2));
            tmp.insert(0, "-");
            return tmp.toString();
        } else if (sign1 == 1 && sign2 == -1) {
            return findSum(num1, num2);
        } else {
            if (isSmaller(num1, num2)) {
                return findDiff(num1, num2);
            } else {
                StringBuilder tmp = new StringBuilder(findDiff(num1, num2));
                tmp.insert(0, "-");
                return tmp.toString();
            }
        }
    }

    private String findSum(String num1, String num2) {
        int n = num1.length() - 1;
        int m = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (n >= 0 || m >= 0) {
            int sum = carry;
            if (n >= 0) {
                sum += num1.charAt(n) - '0';
            }
            if (m >= 0) {
                sum += num2.charAt(m) - '0';
            }
            sb.append(sum % 10);
            carry = sum / 10;
            n--;
            m--;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    private String findDiff(String num1, String num2) {
        if (isSmaller(num1, num2)) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        StringBuilder sb = new StringBuilder();
        int n1 = num1.length();
        int n2 = num2.length();
        int carry = 0;
        for (int i = 0; i < n2; i++) {
            int digit = (num1.charAt(n1 - 1 - i) - '0') - (num2.charAt(n2 - 1 - i) - '0');
            if (digit < 0) {
                digit += 10;
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(digit);
        }
        for (int i = n1 - n2 - 1; i >= 0; i--) {
            if (num1.charAt(i) == '0' && carry > 0) {
                sb.append('9');
                continue;
            }
            int digit = num1.charAt(i) - '0' - carry;
            carry = 0;
            sb.append(digit);
        }
        sb = sb.reverse();
        int i = sb.charAt(0) == '-' ? 1 : 0;
        while (sb.charAt(i) == '0' && sb.length() > 1) {
            sb.deleteCharAt(i);
        }
        return sb.toString();
    }

    private boolean isSmaller(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        if (n < m) return true;
        if (n > m) return false;
        for (int i = 0; i < n; i++) {
            if (num1.charAt(i) > num2.charAt(i)) {
                return false;
            } else if (num1.charAt(i) < num2.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
