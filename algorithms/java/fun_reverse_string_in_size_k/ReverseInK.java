public class ReverseInK {

    public String reverseInK(String s, int k) {
        if (s == null) return "";
        String[] eachWord = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : eachWord) {
            char[] tmp = word.toCharArray();
            int start = 0;
            while (start < tmp.length) {
                int next = Math.min(start + k - 1, tmp.length - 1);
                reverse(tmp, start, next);
                start = next + 1;
            }
            sb.append(new String(tmp));
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void reverse(char[] target, int l, int r) {
        while (l < r) {
            char tmp = target[l];
            target[l] = target[r];
            target[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        ReverseInK solve = new ReverseInK();
        String s1 = "microsoft hiring event"; // cimsortfo rihgni evetn
        String s2 = "is"; // si
        String s3 = "i"; // i
        System.out.println(solve.reverseInK(s1, 3));
        System.out.println(solve.reverseInK(s2, 3));
        System.out.println(solve.reverseInK(s3, 3));
    }
}