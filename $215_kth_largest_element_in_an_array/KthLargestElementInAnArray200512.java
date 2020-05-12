package $215_kth_largest_element_in_an_array;

/**
 * @author su
 * @date 2020/5/1223:25
 * @description 215. 数组中的第K个最大元素
 */
public class KthLargestElementInAnArray200512 {
    public int findKthLargest(int[] nums, int k) {
        int i = k - 1;

        int l = 0;
        int r = nums.length - 1;

        int p;
        while (true) {
            p = partition(nums, l, r);
            if (p == i) {
                return nums[i];
            } else if (p < i) {
                l = p + 1;
            } else if (p > i) {
                r = p - 1;
            }
        }
    }

    private int partition(int[] nums, int l, int r) {
        int v = nums[l];
        //[l+1,j]<v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > v) {
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, l, j);

        return j;
    }

    public static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray200512 a = new KthLargestElementInAnArray200512();

        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(a.findKthLargest(nums, 4));
    }

}
