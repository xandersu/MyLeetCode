package $125_valid_palindrome;

/**
 * @author su
 * @date 2020/5/2111:46
 * @description
 */
public class ValidPalindrome200521 {

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0||s.length()==1) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;

        while (i < s.length() && j >= 0) {
            while (i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (i > s.length() || j < 0) {
                return false;
            }
            if (Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        if (i < s.length() || j >= 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
