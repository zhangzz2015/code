import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
* Given a String and a dictionary, find the minimum number of partitions to cut the String and return cut ways, each
* partition is in the dictionary.
* e.g.
* "catsandog" dic = ["cat", "cats", "and", "san", "dog", "o", "g"]
* return ["cat", "and", "dog"]
*/
public class SplitWords {
   public List<String> splitWords(String wordStr, Set<String> dic) {
       int len = wordStr.length();
       int[] minCuts = new int[len + 1];
       int[] preIndex = new int[len + 1];
       for (int index = 1; index <= len; index++) {
           if (dic.contains(wordStr.substring(0, index))) {
               minCuts[index] = 1;
               preIndex[index] = 0;
               continue;
           }
           for (int idx = 1; idx < index; idx++) {
               String subStr = wordStr.substring(idx, index);
               if (shouldUpdate(dic, subStr, minCuts, idx, index)) {
                   minCuts[index] = minCuts[idx] + 1;
                   preIndex[index] = idx;
               }
           }
       }
       return generateResult(wordStr, preIndex);
   }

   private boolean shouldUpdate(Set<String> dic, String str, int[] arr, int begin, int end) {
       if (!dic.contains(str)) {
           return false;
       }
       if (arr[begin] == 0) {
           return false;
       }
       if (arr[end] != 0 && arr[begin] + 1 > arr[end]) {
           return false;
       }
       return true;
   }

   private List<String> generateResult(String wordStr, int[] preIndex) {
       List<String> words = new ArrayList<>();
       int index = preIndex.length - 1;
       while (index > 0) {
           words.add(wordStr.substring(preIndex[index], index));
           index = preIndex[index];
       }
       Collections.reverse(words);
       return words;
   }

   public static void main(String[] args) {
       SplitWords splitWords = new SplitWords();
       Set<String> set = Set.of("cat", "cats", "and", "san", "dog", "o", "g");
       List<String> res = splitWords.splitWords("catsanddog", set);
       res.forEach(System.out::println); // cats and dog
   }
}