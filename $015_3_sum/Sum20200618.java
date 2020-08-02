package $015_3_sum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: suxun
 * @data: 2020/6/18 16:06
 * @description:
 */
public class Sum20200618 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};

        System.out.println(threeSum(arr));
    }
}
