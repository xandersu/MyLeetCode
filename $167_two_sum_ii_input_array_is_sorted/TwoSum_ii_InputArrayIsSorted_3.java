package $167_two_sum_ii_input_array_is_sorted;

import java.util.Arrays;

/**
 * @author suxun
 * @date 2020/8/2 15:20
 * @description 双指针 对撞指针 O(n)
 */
public class TwoSum_ii_InputArrayIsSorted_3 {

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{(i + 1), (j + 1)};
            }
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
