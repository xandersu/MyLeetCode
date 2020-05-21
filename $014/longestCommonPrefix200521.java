package $014;

/**
 * @author: suxun
 * @date: 2020/4/26 15:37
 * @description:
 */
public class longestCommonPrefix200521 {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            for (; j < strs[i].length(); j++) {
                if (j >= result.length() || result.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            result = result.substring(0, j);
            if (result.equals("")) {
                return "";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"1334q23", "133rarfzfsfs", "133r"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }
}
