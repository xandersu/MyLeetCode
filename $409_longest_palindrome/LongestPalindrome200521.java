package $409_longest_palindrome;

import java.util.HashMap;
import java.util.Map;

/**
 * @author su
 * @date 2020/5/2111:27
 * @description 409. 最长回文串
 */
public class LongestPalindrome200521 {

    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            Integer count = map.getOrDefault(charAt, 0);
            map.put(charAt, ++count);
        }
        int result = 0;
        boolean processOne = false;
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            Integer value = characterIntegerEntry.getValue();
            if (value % 2 == 0) {
                result += value;
            } else {
                result += value - 1;
                if (!processOne) {
                    result += 1;
                    processOne = true;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
}
