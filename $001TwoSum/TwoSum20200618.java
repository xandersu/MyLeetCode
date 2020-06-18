package $001TwoSum;

import java.util.Arrays;

/**
 * @author: suxun
 * @description:
 * @data: 2020/6/18 15:37
 */
public class TwoSum20200618 {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(twoSum(arr, 6)));

    }
}
