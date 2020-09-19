class Atoi {
    public int atoi(String str) {
        if (str == null || str.length() == 0) return 0;
        int index = 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (index == str.length()) return 0;
        int sign = 1;
        if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (str.charAt(index) == '+') {
            index++;
        }
        int res = 0;
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            int digit = str.charAt(index) - '0';
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + digit;
            index++;
        }
        return res * sign;
    }

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.atoi("130"));
        System.out.println(atoi.atoi("    -128"));
        System.out.println(atoi.atoi("4193 with word"));
        System.out.println(atoi.atoi("word 4193"));
        System.out.println(atoi.atoi("-91283472332")); // underflow return -2147483648
        System.out.println(atoi.atoi("2147483647"));
    }
}
