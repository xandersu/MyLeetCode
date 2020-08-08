package $001TwoSum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author suxun
 * @date 2020/8/8 14:34
 * @description
 */
public class TwoSum20200808 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int findNum = target - num;
            if (map.containsKey(findNum)) {
                Integer findIndex = map.get(findNum);
                return new int[]{i, findIndex};
            } else {
                map.put(num, i);
            }
        }
        return null;
    }
}
