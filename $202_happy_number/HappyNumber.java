package $202_happy_number;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: suxun
 * @date: 2020/4/30 11:22
 * @description: 202. 快乐数
 */
public class HappyNumber {

    public static boolean isHappy(int n) {
        return isHappy(n, 1);
    }

    public static boolean isHappy(int n, int count) {
        count++;
        if (count >= 1000) {
            return false;
        }
        if (n <= 0) {
            return false;
        }
        if (n >= Integer.MAX_VALUE) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            int i = n % 10;
            n = n / 10;
            list.add(i);
        }
        int result = 0;
        for (Integer integer : list) {
            result += Math.pow(integer, 2);
        }
        if (result >= Integer.MAX_VALUE) {
            return false;
        }
        if (result == 1) {
            return true;
        }
        list.clear();
        return isHappy(result, count);
    }

    public static void main(String[] args) {
//        System.out.println(Math.pow(10, 2));
        System.out.println(isHappy(2));
    }


}
