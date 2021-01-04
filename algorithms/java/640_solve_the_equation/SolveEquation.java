class SolveEquation {
	// 1. partition once
	public String solveEquation1(String equation) {
        int left = 0;
        int right = 0;
        int x = 1;
        int num = -1;
        int positive = 1;
        int count = 0;
        int index = 0;
        while (index < equation.length()) {
            if (Character.isDigit(equation.charAt(index))) {
                count = count * 10 + equation.charAt(index) - '0';
            } else if (equation.charAt(index) == 'x') {
                left += x * positive * count;
                if (index >= 1 && equation.charAt(index - 1) == '0') {
                    // deal with 0x=0
                    index++;
                    continue;
                }
                if (count == 0) {
                    // deal with +x
                    left += x * positive;
                }
                count = 0;
                positive = 1;
            } else if (equation.charAt(index) == '+') {
                right += num * positive * count;
                count = 0;
                positive = 1;
            } else if (equation.charAt(index) == '-') {
                right += num * positive * count;
                count = 0;
                positive = -1;
            } else if (equation.charAt(index) == '=') {
                if (equation.charAt(index - 1) == 'x') {
                    left += x * positive * count;
                } else {
                    right += num * positive * count;
                }
                count = 0;
                positive = 1;
                x = -1;
                num = 1;
            }
            index++;
        }
        right += num * positive * count;
        
        if (left == 0) {
            if (right == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            return "x=" + right / left;
        }
    }


	// 2. left and right compare
	static class Expression {
        int coefficient;
        int constant;
        Expression(int coefficient, int constant) {
            this.coefficient = coefficient;
            this.constant = constant;
        }
    }

	public String solveEquation2(String equation) {
        if (equation == null || equation.length() == 0) {
            return "No solution";
        }
        String[] expressions = equation.split("=");
        Expression left = getExpression(expressions[0]);
        Expression right = getExpression(expressions[1]);
        if (left.coefficient == right.coefficient && left.constant == right.constant) {
            return "Infinite solutions";
        } else if (left.coefficient == right.coefficient) {
            return "No solution";
        } else {
            return "x=" + (right.constant - left.constant) / (left.coefficient - right.coefficient);
        }
    }

    private Expression getExpression(String s) {
        String[] tokens = s.split("(?=[-+])");
        Expression res = new Expression(0, 0);
        for (String token : tokens) {
            if (token.equals("+x") || token.equals("x")) {
                res.coefficient++;
            } else if (token.equals("-x")) {
                res.coefficient--;
            } else if (token.contains("x")) {
                res.coefficient += Integer.valueOf(token.substring(0, token.length() - 1));
            } else {
                res.constant += Integer.valueOf(token);
            }
        }
        return res;
    }
}
