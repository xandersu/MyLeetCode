package $242;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author suxun
 * @date 2020/8/8 13:55
 * @description
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            if (!map.containsKey(key)) {
                return false;
            } else {
                map.put(key, map.get(key) - 1);
            }
        }
        Collection<Integer> values = map.values();
        for (Integer value : values) {
            if (value > 0) {
                return false;
            }
        }
        return true;
    }
}
