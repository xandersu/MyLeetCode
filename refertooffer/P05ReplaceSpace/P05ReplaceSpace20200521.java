package refertooffer.P05ReplaceSpace;

/**
 * @author su
 * @date 2020/5/2110:52
 * @description
 */
public class P05ReplaceSpace20200521 {

    public static String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String rp = "%20";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append(rp);
            } else {
                sb.append(c);
            }

        }
        return sb.toString();
    }


    public static void main(String[] args) {

    }
}
