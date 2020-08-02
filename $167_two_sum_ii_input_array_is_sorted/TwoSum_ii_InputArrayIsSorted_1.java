package $167_two_sum_ii_input_array_is_sorted;

/**
 * @author suxun
 * @date 2020/8/2 15:25
 * @description 暴力破解 O(n^2)
 */
public class TwoSum_ii_InputArrayIsSorted_1 {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{(i + 1), (j + 1)};
                }
            }
        }
        return null;
    }
}
