package $014;

/**
 * @author: suxun
 * @date: 2020/4/26 15:37
 * @description:
 */
public class longestCommonPrefix20042601 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String benchmark = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            String str = strs[i];
            for (; j < benchmark.length() && j < str.length(); j++) {
                if (benchmark.charAt(j) != str.charAt(j)) {
                    break;
                }
            }
            benchmark = benchmark.substring(0, j);
            if (benchmark.equals("")) {
                return "";
            }
        }
        return benchmark;
    }

    public static void main(String[] args) {
        longestCommonPrefix20042601 longestCommonPrefix20042601 = new longestCommonPrefix20042601();
        String[] strs = {"1334q23", "133rarfzfsfs","133r"};
        String s = longestCommonPrefix20042601.longestCommonPrefix(strs);
        System.out.println(s);
    }
}
