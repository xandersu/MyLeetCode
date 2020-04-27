package $033;

/**
 * @author: suxun
 * @date: 2020/4/27 10:08
 * @description: 搜索旋转排序数组
 * 二分查找
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] <= nums[mid]) {
                //左边有序
                if (nums[start] <= target && target < nums[mid]) {

                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else {
                //右边有序
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                }
                end = mid - 1;
            }

        }

        return -1;
    }


    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int[] nums = {3, 4, 5, 1, 2};
        int search = searchInRotatedSortedArray.search(nums, 2);
        System.out.println(search);
    }
}
