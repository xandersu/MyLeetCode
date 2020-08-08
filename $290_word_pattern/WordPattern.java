package $290_word_pattern;

import java.util.HashMap;

/**
 * @author suxun
 * @date 2020/8/8 14:07
 * @description
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        HashMap<String, Character> scMap = new HashMap<>();
        HashMap<Character, String> csMap = new HashMap<>();
        String[] split = str.split(" ");
        if (split.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            char c = pattern.charAt(i);

            if (scMap.containsKey(s)) {
                char scGetChar = scMap.get(s);
                if (scGetChar != c) {
                    return false;
                }
            } else {
                scMap.put(s, c);
            }

            if (csMap.containsKey(c)) {
                String getStr = csMap.get(c);
                if (!getStr.equals(s)) {
                    return false;
                }
            } else {
                csMap.put(c, s);
            }
        }
        return true;
    }
}
