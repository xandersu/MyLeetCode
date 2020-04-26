package $014;

/**
 * @author: suxun
 * @date: 2020/4/26 13:23
 * @description:
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        String first = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            String thisStr = strs[i];
            for (; j < first.length() && j < thisStr.length(); j++) {
                if (first.charAt(j) != thisStr.charAt(j)) {
                    break;
                }
            }
            first = first.substring(0, j);
            if (first.equals("")) {
                return first;
            }

        }
        return first;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strs = {"1334q23", "133rarfzfsfs","133r"};
        String s = longestCommonPrefix.longestCommonPrefix(strs);
        System.out.println(s);
    }
}
