package $026;

import java.util.Arrays;

/**
 * @author: suxun
 * @date: 2020/4/26 15:46
 * @description: 26. 删除排序数组中的重复项
 * 1, 2, 3, 4, 5
 * 1, 1, 2, 2, 3
 * <p>
 * 1, 1, 1, 2, 3, 3, 4,
 * 1, 2, 1, 1, 3, 3, 4,
 * 123114
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int length = nums.length;
        if (length == 0 || length == 1) {
            return length;
        }
        int slowPoint = 0;
        int fastPoint = 1;
        for (; fastPoint < length; ) {
            if (nums[slowPoint] == nums[fastPoint]) {
                fastPoint++;
            } else if (nums[slowPoint] != nums[fastPoint] && fastPoint - slowPoint > 1) {
                slowPoint++;
                int temp = nums[slowPoint];
                nums[slowPoint] = nums[fastPoint];
                nums[fastPoint] = temp;
                fastPoint++;
            } else if (nums[slowPoint] != nums[fastPoint]) {
                slowPoint++;
                fastPoint++;
            }

        }
        return slowPoint + 1;
    }

    //官方解答
    public int removeDuplicatesV2(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int length = nums.length;
        if (length == 0 || length == 1) {
            return length;
        }

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {1, 1, 2};
        int bool = removeDuplicates.removeDuplicates(nums);
        System.out.println(bool);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int bool2 = removeDuplicates.removeDuplicates(nums2);
        System.out.println(bool2);
        System.out.println(Arrays.toString(nums2));

    }

}
