package $703_kth_largest_element_in_a_stream;


import java.util.PriorityQueue;

/**
 * @author su
 * @date 2020/5/24 9:12
 * @description 703. 数据流中的第K大元素
 */
public class $703_KthLargestElementInAStream {

    private PriorityQueue<Integer> pq;
    private final int k;

    public $703_KthLargestElementInAStream(int k, int[] nums) {
        pq = new PriorityQueue<>(k);
        this.k = k;
        for (int num : nums) {
                add(num);
        }
    }

    public int add(int val) {
        if (pq.size() < k) {
            pq.add(val);
        }else{
            Integer peek = pq.peek();
            if (peek == null) {
                pq.add(val);
            }else{
                if (val > peek) {
                    pq.poll();
                    pq.add(val);
                }
            }
        }
        return pq.peek();
    }
}
