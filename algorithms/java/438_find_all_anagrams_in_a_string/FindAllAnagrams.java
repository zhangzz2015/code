import java.util.*;

public class FindAllAnagrams {
    public Set<String> findAllAnagrams(String s, String target) {
        Set<String> res = new HashSet<>();
        if (s.length() == 0) return res;
        if (target.length() > s.length()) return res;
        Map<Character, Integer> freq = countFreq(target);
        int match = 0;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            Integer count = freq.get(tmp);
            if (count != null) {
                freq.put(tmp, count - 1);
                if (count == 1) {
                    match++;
                }
            }
            if (i >= target.length()) {
                tmp = s.charAt(i - target.length());
                count = freq.get(tmp);
                if (count != null) {
                    freq.put(tmp, count + 1);
                    if (count == 0) {
                        match--;
                    }
                }
            }
            if (match == freq.size()) {
                res.add(s.substring(i - target.length() + 1, i + 1));
            }
        }
        return res;
    }

    private Map<Character, Integer> countFreq(String target) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : target.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        FindAllAnagrams findAllAnagrams = new FindAllAnagrams();
        System.out.println(findAllAnagrams.findAllAnagrams("abcab", "abc"));
        System.out.println(findAllAnagrams.findAllAnagrams("abcab", "ab"));
  
    }
}