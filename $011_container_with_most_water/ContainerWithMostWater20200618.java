package $011_container_with_most_water;

/**
 * @author: suxun
 * @data: 2020/6/18 16:06
 * @description:
 */
public class ContainerWithMostWater20200618 {

    public static int maxArea(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int areaTemp = (j - i) * Math.min(height[i], height[j]);
                if (areaTemp > area) {
                    area = areaTemp;
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(arr));
    }
}
