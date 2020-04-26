package $001TwoSum;

/**
 * @author: suxun
 * @date: 2020/4/26 10:26
 * @description:
 */
public class TwoSum200426 {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int y = nums[j];
                if (x + y == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

}
