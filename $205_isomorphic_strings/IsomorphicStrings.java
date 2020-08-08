package $205_isomorphic_strings;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author suxun
 * @date 2020/8/8 14:22
 * @description
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            Character character = map.get(sc);
            if (character == null) {
                map.put(sc, tc);
            } else {
                if (character != tc) {
                    return false;
                }
            }
        }
        Collection<Character> values = map.values();
        Set<Character> set = new HashSet<>(values);
        return set.size() == values.size();
    }
}
