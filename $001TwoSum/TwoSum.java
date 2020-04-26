package $001TwoSum;

/**
 * @ClassName: $007.ReverseInt
 * @Description:
 * @Author: suxun
 * @Date: 2018/7/24 10:35
 * @Version: 1.0
 **/
class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int k = nums[i] + nums[j];
				if (k == target) {
					return new int[]{i, j};
				}
			}
		}
		return new int[]{0, 0};
	}
}
