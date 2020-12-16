class AddString {
	public String addStrings(String num1, String num2) {
        if (num1 == null && num2 == null) return null;
        if (num1 == null || num2 == null) return num1 == num2 ? num2 : num1;
        if (num1.length() == 0 && num2.length() == 0) return "0";
 
 
        int i = 0;
        while (i < num1.length() - 1) {
            if (num1.charAt(num1.length() - 1 - i) == '.') {
                break;
            }
            i++;
        }
        i = i == num1.length() - 1 ? 0 : i;
        int j = 0;
        while (j < num2.length() - 1) {
            if (num2.charAt(num2.length() - 1 - j) == '.') {
                break;
            }
            j++;
        }
        j = j == num2.length() - 1 ? 0 : j;
 
        String shorter = i < j ? num1 : num2;
        String longer = i >= j ? num1 : num2;
 
        for (int k = 0; k < Math.abs (i - j); k++) {
            shorter += "0";
        }
 
        StringBuilder sb = new StringBuilder();
        int one = shorter.length() - 1;
        int two = longer.length() - 1;
        int carry = 0;
        while(one >= 0 || two >= 0) {
            if (one >= 0 && shorter.charAt(one) == '.') {
                sb.append('.');
            } else {
                int n1 = one >= 0 ? shorter.charAt(one) - '0' : 0;
                int n2 = two >= 0 ? longer.charAt(two) - '0' : 0;
                int tmp = n1 + n2 + carry;
                carry = tmp / 10;
                sb.append(tmp % 10);
            }
            one--;
            two--;
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
