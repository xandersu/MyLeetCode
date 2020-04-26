package $009;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: suxun
 * @date: 2020/4/26 10:44
 * @description:
 */
public class PalindromeNumber0426 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x <= 9) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (x != 0) {
            int num = x % 10;
            list.add(num);
            x = x / 10;
        }
        int size = list.size();
        int mid = size / 2;

        for (int i = 0; i < mid; i++) {
            int a = list.get(i);
            int b = list.get(size - 1 - i);
            if (a != b) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        PalindromeNumber0426 palindromeNumber = new PalindromeNumber0426();
        boolean palindrome = palindromeNumber.isPalindrome(121);
        System.out.println(palindrome);
    }
}
