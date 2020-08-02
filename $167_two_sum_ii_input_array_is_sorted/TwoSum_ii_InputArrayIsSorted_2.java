package $167_two_sum_ii_input_array_is_sorted;

/**
 * @author suxun
 * @date 2020/8/2 15:25
 * @description 二分搜索
 */
public class TwoSum_ii_InputArrayIsSorted_2 {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int t = target - numbers[i];
            int l = i + 1;
            int r = numbers.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (t == numbers[mid]) {
                    return new int[]{(i + 1), (mid + 1)};
                }
                if (t < numbers[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return null;
    }
}
